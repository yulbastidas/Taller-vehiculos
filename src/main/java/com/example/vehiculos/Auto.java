package com.example.vehiculos;

public class Auto extends Vehiculo implements Asegurable {
    public static final int ASIENTOS = 5;
    public Auto(String placa, String marca, String modelo, double km) {
        super(placa, marca, modelo, km);
    }
    @Override public double costoBaseDia() { return 80.0; }
    @Override public double calcularSeguro(int dias) { return 15.0 * dias; }
}
