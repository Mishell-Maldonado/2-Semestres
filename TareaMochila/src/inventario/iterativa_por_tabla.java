package inventario;

public class iterativa_por_tabla {
    public static int optimizar(int[] pesos, int[] valores, int[] costos, int capacidad, int presupuesto, int n) {
        int[][][] tabla = new int[n + 1][capacidad + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
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
        return tabla[n][capacidad][presupuesto];
    }
}