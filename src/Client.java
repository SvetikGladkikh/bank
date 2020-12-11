public class Client implements Runnable {
    private FrontSystem frontSystem;
    private String name;

    Client(String name, FrontSystem frontSystem) {
        this.name = name;
        this.frontSystem = frontSystem;
    }

    @Override
    public void run() {
        int sum = (int) ( Math.random() *  100);
        int numOfOperation = (int) ( Math.random() * 2);
        Operation operation = numOfOperation == 1 ? Operation.CREDIT : Operation.REPAYMENT;
        Request request = new Request(this.name, sum, operation);

        frontSystem.add(request);
        System.out.println("Client " + this.name + " send request for " + operation + " " + sum + "$");
    }
}
