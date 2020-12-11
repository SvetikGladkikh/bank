import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FrontSystem {
    private BlockingQueue<Request> queue;

    public FrontSystem() {
        queue = new ArrayBlockingQueue<> (2, true);
    }

    public void add(Request request) {
        try {
            this.queue.put(request);
        } catch (InterruptedException e) {
            throw new RuntimeException("QUEUE READING EXCEPTION:" + e);
        }
    }

    public Request get() {
        try {
            return this.queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException("QUEUE READING EXCEPTION:" + e);
        }
    }
}
