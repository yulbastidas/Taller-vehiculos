package com.example.vehiculos;

public interface Electrico {
    void recargar(int minutos);
    int nivelBateria(); // 0–100
}
