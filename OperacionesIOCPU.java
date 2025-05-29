
/**
 * Algoritmo que calcula las series de Fibonacci.
 *
 * @author Gerardo Yeray Chelius Altamirano
 */
import java.io.*;

public class OperacionesIOCPU {

    private static File f = new File("Numeros.txt");
    public static int numeros[] = new int[obtenNumeroRegistros(f)];
    
    public OperacionesIOCPU(String line){
        cargaArreglo();
        llenaArchivos(line);
    }

    public static int obtenNumeroRegistros(File f) {
        String aux;
        int i = 0;
        try {
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            while (true) {
                aux = br.readLine();
                if (aux == null) {
                    break;
                }
                i++;
            }

        } catch (IOException e) {
            System.out.println("Error en el archivo");
        }
        return i;
    }

    public static void cargaArreglo() {
        String aux;
        int i = 0;

        try {
            if (!f.exists()) {
                System.out.println("Error. No existe el achivo");
                return;
            }
            FileReader r = new FileReader(f);
            BufferedReader br = new BufferedReader(r);
            //System.out.println("Datos en el archivo: " + f.getName() + "\n");
            while (true) {
                aux = br.readLine();
                if (aux == null) {
                    break;
                }
                numeros[i] = Integer.parseInt(aux);
                //System.out.println("Posición: " + (i + 1) + "/" + numeros.length + ". Dato: " + numeros[i]);
                i++;
            }
            //System.out.println("Carga terminada. Procesos iniciando en 5 segundos...");
            //System.out.println("Procesos iniciados.");

        } catch (IOException e) {
            System.out.println("Error en el archivo");
        }
    }

    public static void creaArchivo(File arch) {
        if (!arch.exists()) {
            try {
                arch.createNewFile();
            } catch (IOException e) {
                System.out.println("El archivo ya existe.");
            }
        }
    }

    public static void llenaArchivos(String line) {
        try {
            for (int i = 0; i < obtenNumeroRegistros(f); i++) {
                File aux = new File(line+Integer.toString(numeros[i])+".txt");
                FileOutputStream fos = new FileOutputStream(aux, true);
                creaArchivo(aux);
                String mensajePrimo;
                if (primo(numeros[i])) {
                    mensajePrimo = "es primo.";
                } else{
                    mensajePrimo = "no es primo.";
                }
                String imprime = Integer.toString(numeros[i])+" "+mensajePrimo;
                OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(imprime);
                bw.close();
                //System.out.println("Archivo creado " + Integer.toString(i + 1) + ". Contenido: "+imprime);
            }
        } catch (IOException e) {
            System.out.println("Error en el archivo.");
        }
    }

    public static boolean primo(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
