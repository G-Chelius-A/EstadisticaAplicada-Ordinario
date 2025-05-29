
/**
 *
 * @author Gerardo Chelius
 */
import java.io.*;

public class OperacionesIO {

    private File f = new File("Numeros.txt");
    public int numeros[] = new int[obtenNumeroRegistros(f)];

    public OperacionesIO(String line) {
        cargaArreglo();
        llenaArchivos(line);
    }

    public int obtenNumeroRegistros(File f) {
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

    public void cargaArreglo() {
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
            //System.out.println("Carga terminada.");
            //System.out.println("Procesos iniciados.");

        } catch (IOException e) {
            System.out.println("Error en el archivo");
        }
    }

    public void creaArchivo(File arch) {
        if (!arch.exists()) {
            try {
                arch.createNewFile();
            } catch (IOException e) {
                System.out.println("El archivo ya existe.");
            }
        }
    }

    public void llenaArchivos(String line) {
        try {
            for (int i = 0; i < obtenNumeroRegistros(f); i++) {
                File aux = new File(line+Integer.toString(numeros[i]) + ".txt");
                FileOutputStream fos = new FileOutputStream(aux, true);
                creaArchivo(aux);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(Integer.toString(numeros[i]));
                bw.close();
                //System.out.println("Archivo creado " + Integer.toString(i + 1));
            }
        } catch (IOException e) {
            System.out.println("Error en el archivo.");
        }
    }
}
