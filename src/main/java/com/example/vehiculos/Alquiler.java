package com.example.vehiculos;

public class Alquiler {
    private final Vehiculo vehiculo;
    private final int dias;
    private final double total;

    public Alquiler(Vehiculo vehiculo, int dias) {
        if (vehiculo == null) throw new IllegalArgumentException("Vehículo no puede ser null");
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.total = vehiculo.calcularPrecioAlquiler(dias);
    }

    public double getTotal() { return total; }
}