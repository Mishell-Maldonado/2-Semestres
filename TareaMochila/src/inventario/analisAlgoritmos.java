package inventario;

import java.util.Scanner;

public class analisAlgoritmos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] valores = {150, 300, 200, 400, 100}; 
        int[] pesos = {2, 4, 3, 5, 1};             
        int[] costos = {100, 250, 150, 300, 50};   
        int n = valores.length;

        System.out.println("=== CONFIGURACIÓN DE RECURSOS DE INVENTARIO ===");
        System.out.print("Ingrese la capacidad límite de almacenamiento (peso): ");
        int capacidad = sc.nextInt();
        System.out.print("Ingrese el presupuesto financiero disponible ($): ");
        int presupuesto = sc.nextInt();

        System.out.println("\n--- Realizando Análisis de Rendimiento y Memoria ---");

        // 1. RECURSIVO SIMPLE
        medirRendimiento("Recursivo Simple", () -> {
            int res = recursiva_simple.optimizar(pesos, valores, costos, capacidad, presupuesto, n);
            System.out.println("  > Beneficio óptimo: " + res);
        });

        // 2. RECURSIVO CON MEMORIA
        recursiva_con_memoria.limpiarMemoria(); 
        medirRendimiento("Recursivo con Memoria", () -> {
            int res = recursiva_con_memoria.optimizar(pesos, valores, costos, capacidad, presupuesto, n);
            System.out.println("  > Beneficio óptimo: " + res);
        });

        // 3. ITERATIVO POR TABLA
        medirRendimiento("Iterativo por Tabla", () -> {
            int res = iterativa_por_tabla.optimizar(pesos, valores, costos, capacidad, presupuesto, n);
            System.out.println("  > Beneficio óptimo: " + res);
        });

        sc.close();
    }

    public static void medirRendimiento(String nombre, Runnable tarea) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 

        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long tiempoInicio = System.nanoTime();

        tarea.run();

        long tiempoFin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();

        double tiempoMs = (tiempoFin - tiempoInicio) / 1_000_000.0;
        long memoriaUsada = memoriaDespues - memoriaAntes;

        System.out.printf("%s:\n", nombre);
        System.out.printf("  > Tiempo: %.4f ms\n", tiempoMs);
        System.out.printf("  > Memoria estimada: %d bytes\n\n", Math.max(0, memoriaUsada));
    }
}