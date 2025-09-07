package com.example.vehiculos;

public class AutoElectrico extends Auto implements Electrico {
    private int bateria;
    public AutoElectrico(String placa, String marca, String modelo, double km, int bateriaInicial) {
        super(placa, marca, modelo, km);
        if (bateriaInicial < 0 || bateriaInicial > 100) throw new IllegalArgumentException("Batería debe estar entre 0 y 100");
        this.bateria = bateriaInicial;
    }
    @Override public void recargar(int minutos) {
        if (minutos <= 0) throw new IllegalArgumentException("Minutos debe ser > 0");
        int incremento = (int)Math.round(minutos * 0.5);
        bateria = Math.min(100, bateria + incremento);
    }
    @Override public int nivelBateria() { return bateria; }
}
