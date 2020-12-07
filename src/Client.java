public class Client extends Thread {
    private FrontSystem frontSystem;

    Client(String name, FrontSystem frontSystem) {
        super(name);
        this.frontSystem = frontSystem;
    }

    @Override
    public void run() {
        int sum = (int) ( Math.random() *  100);
        int numOfOperation = (int) ( Math.random() * 2);
        Operation operation = numOfOperation == 1 ? Operation.CREDIT : Operation.REPAYMENT;

        Request request = new Request(this.getName(), sum, operation);
        frontSystem.add(request);
        System.out.println("Client " + this.getName() + " send request for " + operation + " " + sum + "$");
    }
}
