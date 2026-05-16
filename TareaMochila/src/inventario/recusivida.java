package inventario;
public class recusivida {
    
public static int optimizar(int[] pesos, int[] valores, int[] costos, int capacidad, int presupuesto, int n) {
        if (n == 0 || capacidad == 0 || presupuesto == 0) {
            return 0;
        }

        if (pesos[n - 1] > capacidad || costos[n - 1] > presupuesto) {
            return optimizar(pesos, valores, costos, capacidad, presupuesto, n - 1);
        }

        int incluir = valores[n - 1] + optimizar(pesos, valores, costos, capacidad - pesos[n - 1], presupuesto - costos[n - 1], n - 1);
        int excluir = optimizar(pesos, valores, costos, capacidad, presupuesto, n - 1);

        return Math.max(incluir, excluir);
    }

}
