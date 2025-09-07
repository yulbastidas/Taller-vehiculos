package com.example.vehiculos;

public interface Rentable {
    double calcularPrecioAlquiler(int dias);

    default String condiciones() {
        return "Se requiere licencia vigente y depósito reembolsable";
    }
}
