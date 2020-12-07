import java.util.ArrayDeque;

public class FrontSystem {
        private ArrayDeque<Request> queue = new ArrayDeque<Request>();

        public synchronized void add(Request request) {
            while (queue.size() > 2) {
                try {
                    wait();
                } catch (InterruptedException e)  {
                    Thread.currentThread().interrupt();
                }
            }

            queue.addLast(request);
            notifyAll();
        }

        public synchronized Request get() {
            while (queue.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e)  {
                    Thread.currentThread().interrupt();
                }
            }

            notifyAll();
            return queue.removeFirst();
        }
}
