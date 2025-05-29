
/**
 *
 * @author Gerardo Yeray Chelius Altamirano
 */
public class IOCPU_Virtual {

    public static void main(String[] args) {

        HiloVirtualIOCPU[] threadArray = new HiloVirtualIOCPU[11];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new HiloVirtualIOCPU();
            threadArray[i].numero = i;
            threadArray[i].join();
        }

    }
}

class HiloVirtualIOCPU {

    int numero;
    Thread thread;

    public HiloVirtualIOCPU() {
        Runnable task = () -> {
            long initTime = System.currentTimeMillis();
            OperacionesIOCPU myOperacionesIOCPU = new OperacionesIOCPU(numero + "VirtIOCPU");
            long finishTime = System.currentTimeMillis();
            long totalTime = finishTime - initTime;
            System.out.println("Hilo virtual " + totalTime + " ms.");
        };
        thread = Thread.startVirtualThread(task);
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
