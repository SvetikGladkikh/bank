import java.util.concurrent.atomic.AtomicLong;

public class BackSystem{
    private AtomicLong balance = new AtomicLong(0);

    public long getBalance() {
        return balance.get();
    }

    public void changeBalance(Request request) {
        Operation operation =  request.getOperation();
        int sum = request.getSum();
        long value, next = 0;

        switch (operation) {
            case CREDIT:
                do {
                    value = balance.get();
                    if (sum > value) {
                        System.out.println("BACK_SYSTEM: Request denied: client = " + request.getName() + "; type = " + operation + "; sum = " + sum + "$");
                        return;
                    } else {
                        next = value - sum;
                    }
                } while(!balance.compareAndSet(value, next));
                break;
            case REPAYMENT:
                do {
                    value = balance.get();
                    next = value + sum;
                } while (!balance.compareAndSet(value, next));
        }

        System.out.println("BACK_SYSTEM: Request accept: client = " + request.getName() + "; type = " + operation + "; sum = " + sum + "$");
    }
}
