package com.example.vehiculos;

public class Camioneta extends Vehiculo implements Asegurable {
    private final double capacidadCargaKg;
    public Camioneta(String placa, String marca, String modelo, double km, double capacidadCargaKg) {
        super(placa, marca, modelo, km);
        if (capacidadCargaKg <= 0) throw new IllegalArgumentException("Capacidad de carga inválida");
        this.capacidadCargaKg = capacidadCargaKg;
    }
    @Override public double costoBaseDia() { return 120.0; }
    @Override public double calcularSeguro(int dias) { return 25.0 * dias; }
}
