package com.example.vehiculos;

public abstract class Vehiculo implements Rentable {
    private final String placa;
    private final String marca;
    private final String modelo;
    private double km;
    private EstrategiaPrecio estrategia;

    protected Vehiculo(String placa, String marca, String modelo, double km) {
        if (km < 0) throw new IllegalArgumentException("KM inicial no puede ser negativo");
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.km = km;
    }

    public abstract double costoBaseDia();

    public void sumarKm(double km) {
        if (km < 0) throw new IllegalArgumentException("Los km a sumar no pueden ser negativos");
        this.km += km;
    }

    @Override
    public String toString() {
        return "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", km=" + km;
    }

    public EstrategiaPrecio getEstrategia() { return estrategia; }
    public void setEstrategia(EstrategiaPrecio estrategia) { this.estrategia = estrategia; }
    public Vehiculo conEstrategia(EstrategiaPrecio e) { this.estrategia = e; return this; }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        if (dias <= 0) throw new IllegalArgumentException("Los días deben ser > 0");
        double costoBase = costoBaseDia() * dias;
        double seguro = (this instanceof Asegurable a) ? a.calcularSeguro(dias) : 0.0;
        EstrategiaPrecio e = (estrategia != null) ? estrategia : new PrecioEstandar();
        return e.total(dias, costoBase, seguro);
    }
}
