
/**
 *
 * @author Gerardo Yeray Chelius Altamirano
 */
public class IO_Plataforma {

    public static void main(String[] args) {

        HiloPlataformaIO[] threadArray = new HiloPlataformaIO[11];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new HiloPlataformaIO();
            threadArray[i].numero = i;
            threadArray[i].join();
        }
    }
}

class HiloPlataformaIO implements Runnable {

    private Thread platformThread;
    int numero;

    public HiloPlataformaIO() {
        platformThread = new Thread(this, "Hilo de plataforma");
        platformThread.start();

    }

    public void join() {
        try {
            platformThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        long initTime = System.currentTimeMillis();
        OperacionesIO myOperacionesIO = new OperacionesIO(numero+"Plat");
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - initTime;
        System.out.println("Hilo de plataforma " + totalTime + " ms.");
    }
}
