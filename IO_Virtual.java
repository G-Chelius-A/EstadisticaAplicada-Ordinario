
/**
 *
 * @author Gerardo Yeray Chelius Altamirano
 */
public class IO_Virtual {

    public static void main(String[] args) {

        HiloVirtualIO[] threadArray = new HiloVirtualIO[11];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new HiloVirtualIO();
            threadArray[i].numero = i;
            threadArray[i].join();
        }

    }
}

class HiloVirtualIO {

    int numero;
    Thread thread;

    public HiloVirtualIO() {
        Runnable task = () -> {
            long initTime = System.currentTimeMillis();
            OperacionesIO myOperacionesIO = new OperacionesIO(numero + "Virt");
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
