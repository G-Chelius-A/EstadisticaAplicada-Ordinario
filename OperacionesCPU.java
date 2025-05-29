
/**
 * Algoritmo que calcula las series de Fibonacci.
 *
 * @author Gerardo Yeray Chelius Altamirano
 */
public class OperacionesCPU {

    public OperacionesCPU(int maximum) {
        for (int i = 0; i < maximum; i++) {
            int value = fibonacci(maximum);
            //Si desea imprimir esta línea, remueva las diagonales del comentario.
            //System.out.println(value+" ");
        }
    }

    public int fibonacci(int maximum) {
        if (maximum <= 1) {
            return maximum;
        } else {
            return fibonacci(maximum - 2) + fibonacci(maximum - 1);
        }
    }
}
