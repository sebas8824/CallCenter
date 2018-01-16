import java.util.concurrent.*;

public class Customer extends Thread {

    CyclicBarrier standByMessage;
    private Semaphore operators;

    public Customer(Semaphore operators, CyclicBarrier standByMessage,
                    String name) {
        this.standByMessage = standByMessage;
        this.operators = operators;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {

        long duration = ThreadLocalRandom.current().nextLong(5, 10);

        try {

            System.out.println(getName() + " is waiting to speak to the operator...");

            standByMessage.await();
            operators.acquire();
            System.out.println(getName() + " is getting the connection to the operator ...");
            Thread.sleep(TimeUnit.SECONDS.toMillis(duration));
            System.out.println(getName() + "´s phone call with the operator ending.");
            operators.release();

            System.out.println("Available operators=" + operators.availablePermits());

        } catch (InterruptedException | BrokenBarrierException e) {
            System.err.println(e);
        }

    }
}