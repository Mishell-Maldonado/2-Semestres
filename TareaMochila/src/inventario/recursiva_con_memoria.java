package inventario;

import java.util.Arrays;

public class recursiva_con_memoria {
    private static int[][][] memoria;

    public static int optimizar(int[] pesos, int[] valores, int[] costos, int capacidad, int presupuesto, int n) {
        if (memoria == null) {
            memoria = new int[n + 1][capacidad + 1][presupuesto + 1];
            for (int[][] capa : memoria) {
                for (int[] fila : capa) {
                    Arrays.fill(fila, -1);
                }
            }
        }

        if (n == 0 || capacidad == 0 || presupuesto == 0) {
            return 0;
        }

        if (memoria[n][capacidad][presupuesto] != -1) {
            return memoria[n][capacidad][presupuesto];
        }

        if (pesos[n - 1] > capacidad || costos[n - 1] > presupuesto) {
            return memoria[n][capacidad][presupuesto] = optimizar(pesos, valores, costos, capacidad, presupuesto, n - 1);
        }

        int incluir = valores[n - 1] + optimizar(pesos, valores, costos, capacidad - pesos[n - 1], presupuesto - costos[n - 1], n - 1);
        int excluir = optimizar(pesos, valores, costos, capacidad, presupuesto, n - 1);

        return memoria[n][capacidad][presupuesto] = Math.max(incluir, excluir);
    }

    public static void limpiarMemoria() {
        memoria = null;
    }
}