package inventario;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class analisAlgoritmos {
    // Variables globales para capturar los tiempos exactos de ejecución
    private static double tiempoRec = 0;
    private static double tiempoTD = 0;
    private static double tiempoBU = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Datos comerciales base del problema
        int[] valores = {150, 300, 200, 400, 100}; 
        int[] pesos = {2, 4, 3, 5, 1};             
        int[] costos = {100, 250, 150, 300, 50};   
        int n = valores.length;

        System.out.println("=================================================");
        System.out.println("         SISTEMA DE MOCHILA DINÁMICA");
        System.out.println("=================================================\n");

        System.out.println("PRODUCTOS DISPONIBLES");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("Producto %d -> Peso: %d | Beneficio: %d | Costo: $%d\n", 
                    (i + 1), pesos[i], valores[i], costos[i]);
        }

        System.out.println("\n=================================================");
        System.out.println("CONFIGURACIÓN DEL INVENTARIO");
        System.out.println("=================================================\n");
        System.out.print("Ingrese la capacidad máxima de peso: ");
        int capacidad = sc.nextInt();
        System.out.print("Ingrese el presupuesto disponible: $");
        int presupuesto = sc.nextInt();

        System.out.println("\n=================================================");
        System.out.println("ANÁLISIS DE ALGORITMOS");
        System.out.println("=================================================");

        // [1] ENFOQUE RECURSIVO
        System.out.println("\n[1] ENFOQUE RECURSIVO");
        System.out.println("-------------------------------------------------");
        tiempoRec = medirRendimiento(() -> {
            int res = recursiva.optimizar(pesos, valores, costos, capacidad, presupuesto, n);
            System.out.println("Beneficio óptimo: " + res);
        });

        // [2] ENFOQUE TOP-DOWN (MEMOIZACIÓN)
        System.out.println("[2] ENFOQUE TOP-DOWN (MEMOIZACIÓN)");
        System.out.println("-------------------------------------------------");
        recursiva_con_memoria.limpiarMemoria(); 
        tiempoTD = medirRendimiento(() -> {
            int res = recursiva_con_memoria.optimizar(pesos, valores, costos, capacidad, presupuesto, n);
            System.out.println("Beneficio óptimo: " + res);
            
            // Mostrar los productos seleccionados usando la lógica inversa
            mostrarSeleccionados(pesos, valores, costos, capacidad, presupuesto, n);
        });

        // [3] ENFOQUE BOTTOM-UP
        System.out.println("\n[3] ENFOQUE BOTTOM-UP");
        System.out.println("-------------------------------------------------");
        tiempoBU = medirRendimiento(() -> {
            int res = iterativa_por_tabla.optimizar(pesos, valores, costos, capacidad, presupuesto, n);
            System.out.println("Beneficio óptimo: " + res);
        });

        // COMPARACIÓN FINAL Y CONCLUSIÓN INTELIGENTE
        System.out.println("=================================================");
        System.out.println("COMPARACIÓN FINAL");
        System.out.println("=================================================\n");
        System.out.println("Recursivo:");
        System.out.println("- Complejidad temporal: O(2^n)\n");
        System.out.println("Top-Down:");
        System.out.println("- Complejidad temporal: O(n * W)\n");
        System.out.println("Bottom-Up:");
        System.out.println("- Complejidad temporal: O(n * W)\n");
        
        System.out.println("Conclusión:");
            if (tiempoRec < tiempoTD && tiempoRec < tiempoBU) {
        System.out.println("El enfoque RECURSIVO fue más rápido para este conjunto pequeño de datos.");
            } else if (tiempoTD < tiempoBU) {
        System.out.println("El enfoque TOP-DOWN optimizó subproblemas mediante memoización.");
            }  else {
        System.out.println("El enfoque BOTTOM-UP obtuvo el mejor rendimiento iterativo.");
}
        System.out.println();
        
        System.out.println("=================================================");
        System.out.println("FIN DEL PROGRAMA");
        System.out.println("=================================================");

        sc.close();
    }

    public static void mostrarSeleccionados(int[] pesos, int[] valores, int[] costos, int capacidad, int presupuesto, int n) {
        int[][][] tabla = new int[n + 1][capacidad + 1][presupuesto + 1];
        for (int i = 1; i <= n; i++) 
        {
            for (int w = 1; w <= capacidad; w++) {
                for (int p = 1; p <= presupuesto; p++) {
                    if (pesos[i - 1] <= w && costos[i - 1] <= p) {
                        tabla[i][w][p] = Math.max(valores[i - 1] + tabla[i - 1][w - pesos[i - 1]][p - costos[i - 1]], tabla[i - 1][w][p]);
                    } else {
                        tabla[i][w][p] = tabla[i - 1][w][p];
                    }
                }
            }
        }

        List<String> seleccionados = new ArrayList<>();
        int w = capacidad;
        int p = presupuesto;

        for (int i = n; i > 0; i--) {
            if (tabla[i][w][p] != tabla[i - 1][w][p]) {
                seleccionados.add(0, "- Producto " + i + " (Peso: " + pesos[i - 1] + " | Beneficio: " + valores[i - 1] + ")");
                w -= pesos[i - 1];
                p -= costos[i - 1];
            }
        }

        System.out.println("\nProductos seleccionados:");
        if (seleccionados.isEmpty()) {
            System.out.println("- Ninguno (Recursos insuficientes)");
        } else {
            for (String prod : seleccionados) {
                System.out.println(prod);
            }
        }
    }

    // Modificado para retornar el tiempo exacto calculado en milisegundos
    public static double medirRendimiento(Runnable tarea) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); 

        long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();
        long tiempoInicio = System.nanoTime();

        tarea.run();

        long tiempoFin = System.nanoTime();
        long memoriaDespues = runtime.totalMemory() - runtime.freeMemory();

        double tiempoMs = (tiempoFin - tiempoInicio) / 1_000_000.0;
        long memoriaUsada = memoriaDespues - memoriaAntes;

        System.out.printf("Tiempo de ejecución: %.4f ms\n", tiempoMs);
        System.out.printf("Memoria estimada: %d bytes\n\n", Math.max(0, memoriaUsada));
        
        return tiempoMs; // Retornamos el valor para la comparación lógica
    }
}