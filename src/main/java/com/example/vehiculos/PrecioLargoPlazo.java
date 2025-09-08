package com.example.vehiculos;

public class PrecioLargoPlazo implements EstrategiaPrecio {
    @Override
    public double total(int dias, double costoBase, double seguro) {
        double subtotal = costoBase + seguro;
        if (dias >= 10) {
            return subtotal * 0.85; // 15% descuento
        }
        return subtotal;
    }
}