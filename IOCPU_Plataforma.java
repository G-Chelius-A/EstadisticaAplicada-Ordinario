
/**
 *
 * @author Gerardo Yeray Chelius Altamirano
 */
public class IOCPU_Plataforma {

    public static void main(String[] args) {

        HiloPlataformaIOCPU[] threadArray = new HiloPlataformaIOCPU[11];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new HiloPlataformaIOCPU();
            threadArray[i].numero = i;
            threadArray[i].join();
        }
    }
}

class HiloPlataformaIOCPU implements Runnable {

    private Thread platformThread;

    int numero;

    public HiloPlataformaIOCPU() {
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
        OperacionesIOCPU myOperacionesIOCPU = new OperacionesIOCPU(numero + "PlatIOCPU");
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - initTime;
        System.out.println("Hilo de plataforma " + totalTime + " ms.");
    }
}
