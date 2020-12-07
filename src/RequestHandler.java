import java.lang.ref.ReferenceQueue;

public class RequestHandler extends Thread {
    private FrontSystem frontSystem;
    private  BackSystem backSystem;

    public RequestHandler(String name, FrontSystem frontSystem, BackSystem backSystem) {
        super(name);
        this.frontSystem = frontSystem;
        this.backSystem = backSystem;
    }

    @Override
    public void run() {
       while (true) {
           Request request = frontSystem.get();
           System.out.println("RequestHandler " + this.getName() + " get request for client" + request.getName() + " for " + request.getOperation() + " " + request.getSum() + "$");
           backSystem.changeBalance(request);
       }
    }
}
