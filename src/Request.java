public class Request {
    private String name;
    private int sum;
    private Operation operation;

    public Request(String name, int sum, Operation operation) {
        this.name = name;
        this.sum = sum;
        this.operation = operation;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public Operation getOperation() {
        return operation;
    }
}
