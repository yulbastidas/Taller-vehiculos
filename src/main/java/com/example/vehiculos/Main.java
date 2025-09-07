package com.example.vehiculos;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> inventario = new ArrayList<>();
        EstrategiaPrecio estandar = new PrecioEstandar();

        inventario.add(new Auto("ABC123", "Toyota", "Corolla", 12000).conEstrategia(estandar));
        inventario.add(new Moto("MOT777", "Yamaha", "FZ", 8000).conEstrategia(estandar));
        inventario.add(new Camioneta("CARG99", "Ford", "Ranger", 21000, 800).conEstrategia(estandar));
        inventario.add(new AutoElectrico("ELE111", "Nissan", "Leaf", 5000, 85).conEstrategia(estandar));
        inventario.add(new Camioneta("CARG01", "Chevrolet", "Colorado", 15000, 1000).conEstrategia(estandar));

        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== ALQUILER DE VEHÍCULOS ===");
            System.out.println("1) Listar vehículos");
            System.out.println("2) Asignar estrategia de precio");
            System.out.println("3) Simular alquiler");
            System.out.println("4) Recargar eléctrico");
            System.out.println("5) Ejecutar pruebas mínimas");
            System.out.println("0) Salir");
            System.out.print("Seleccione: ");

            switch (sc.nextLine().trim()) {
                case "1" -> listar(inventario);
                case "2" -> asignar(inventario, sc);
                case "3" -> alquilar(inventario, sc);
                case "4" -> recargar(inventario, sc);
                case "5" -> pruebas();
                case "0" -> salir = true;
            }
        }
    }

    static void listar(List<Vehiculo> inv) {
        for (int i = 0; i < inv.size(); i++) {
            Vehiculo v = inv.get(i);
            System.out.printf("%d) %s - %s\n", i, v.getClass().getSimpleName(), v);
        }
    }

    static void asignar(List<Vehiculo> inv, Scanner sc) {
        listar(inv);
        System.out.print("Seleccione índice: ");
        Vehiculo v = inv.get(Integer.parseInt(sc.nextLine()));
        System.out.println("1) Estandar 2) Finde 3) LargoPlazo");
        switch (sc.nextLine()) {
            case "1" -> v.setEstrategia(new PrecioEstandar());
            case "2" -> v.setEstrategia(new PrecioFinde());
            case "3" -> v.setEstrategia(new PrecioLargoPlazo());
        }
    }

    static void alquilar(List<Vehiculo> inv, Scanner sc) {
        listar(inv);
        System.out.print("Seleccione índice: ");
        Vehiculo v = inv.get(Integer.parseInt(sc.nextLine()));
        System.out.print("Días: ");
        int d = Integer.parseInt(sc.nextLine());
        Alquiler a = new Alquiler(v, d);
        System.out.println("Total: $" + a.getTotal());
    }

    static void recargar(List<Vehiculo> inv, Scanner sc) {
        listar(inv);
        System.out.print("Seleccione índice: ");
        Vehiculo v = inv.get(Integer.parseInt(sc.nextLine()));
        if (v instanceof Electrico e) {
            System.out.print("Minutos: ");
            e.recargar(Integer.parseInt(sc.nextLine()));
            System.out.println("Batería: " + e.nivelBateria() + "%");
        } else {
            System.out.println("No es eléctrico");
        }
    }

    static void pruebas() {
        Rentable r1 = new Auto("A1", "Ford", "Fiesta", 1000).conEstrategia(new PrecioEstandar());
        Rentable r2 = new Moto("M1", "Honda", "CB", 500).conEstrategia(new PrecioEstandar());
        Rentable r3 = new Camioneta("C1", "VW", "Amarok", 2000, 900).conEstrategia(new PrecioEstandar());
        Rentable r4 = new AutoElectrico("E1", "BYD", "Dolphin", 3000, 60).conEstrategia(new PrecioEstandar());
        System.out.println("Totales polimórficos: " + r1.calcularPrecioAlquiler(3) + ", " + r2.calcularPrecioAlquiler(3) + ", " + r3.calcularPrecioAlquiler(3) + ", " + r4.calcularPrecioAlquiler(3));

        Vehiculo v = new Auto("A2", "Chevy", "Onix", 2000).conEstrategia(new PrecioEstandar());
        System.out.println("Estandar 10d: " + v.calcularPrecioAlquiler(10));
        v.setEstrategia(new PrecioLargoPlazo());
        System.out.println("Largo plazo 10d: " + v.calcularPrecioAlquiler(10));

        Vehiculo moto = new Moto("M2", "Yamaha", "Crypton", 1000).conEstrategia(new PrecioEstandar());
        System.out.println("Moto sin seguro: " + moto.calcularPrecioAlquiler(2));

        AutoElectrico ae = new AutoElectrico("E2", "Renault", "Zoe", 2000, 95);
        ae.recargar(30);
        System.out.println("Batería Zoe: " + ae.nivelBateria());
    }
}
