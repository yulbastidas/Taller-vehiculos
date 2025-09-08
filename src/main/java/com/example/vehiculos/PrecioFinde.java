package com.example.vehiculos;

public class PrecioFinde implements EstrategiaPrecio {
    @Override
    public double total(int dias, double costoBase, double seguro) {
        double subtotal = costoBase + seguro;
        if (dias >= 2) {
            return subtotal * 0.90; // 10% descuento
        }
        return subtotal;
    }
}