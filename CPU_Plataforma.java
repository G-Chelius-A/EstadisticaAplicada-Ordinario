
/**
 *
 * @author Gerardo Yeray Chelius Altamirano
 */
public class CPU_Plataforma {

    public static void main(String[] args) {

        HiloPlataformaCPU[] threadArray = new HiloPlataformaCPU[11];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new HiloPlataformaCPU();
            threadArray[i].join();
        }
    }
}

class HiloPlataformaCPU implements Runnable {

    private Thread platformThread;

    public HiloPlataformaCPU() {
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
        OperacionesCPU myOperacionesCPU = new OperacionesCPU(38);
        long finishTime = System.currentTimeMillis();
        long totalTime = finishTime - initTime;
        System.out.println("Hilo de plataforma " + totalTime + " ms.");
    }
}
