
/**
 *
 * @author Gerardo Yeray Chelius Altamirano
 */
public class CPU_Virtual {

    public static void main(String[] args) {

        HiloVirtualCPU[] threadArray = new HiloVirtualCPU[11];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new HiloVirtualCPU();
            threadArray[i].join();
        }

    }
}

class HiloVirtualCPU {

    Thread thread;

    public HiloVirtualCPU() {
        Runnable task = () -> {
            long initTime = System.currentTimeMillis();
            OperacionesCPU myOperacionesCPU = new OperacionesCPU(38);
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
