public class RequestHandler implements Runnable {
    private FrontSystem frontSystem;
    private BackSystem backSystem;
    private String name;

    public RequestHandler(String name, FrontSystem frontSystem, BackSystem backSystem) {
        this.name = name;
        this.frontSystem = frontSystem;
        this.backSystem = backSystem;
    }

    @Override
    public void run() {
       while (true) {
           Request request = frontSystem.get();

           System.out.println("RequestHandler " + this.name + " get request for client" + request.getName() + " for " + request.getOperation() + " " + request.getSum() + "$");
           backSystem.changeBalance(request);
       }
    }
}
