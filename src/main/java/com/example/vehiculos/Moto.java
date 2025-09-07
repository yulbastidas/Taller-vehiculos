package com.example.vehiculos;

public class Moto extends Vehiculo {
    public static final int ASIENTOS = 2;
    public Moto(String placa, String marca, String modelo, double km) {
        super(placa, marca, modelo, km);
    }
    @Override public double costoBaseDia() { return 50.0; }
}
