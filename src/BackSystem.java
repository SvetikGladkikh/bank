public class BackSystem{
    private int balance = 0;

    public synchronized void changeBalance(Request request) {
        Operation operation =  request.getOperation();
        int sum = request.getSum();

        switch (operation) {
            case CREDIT:
                if (sum > balance) {
                    System.out.println("BACK_SYSTEM: Request denied: client = " + request.getName() + "; type = " + operation + "; sum = " + sum + "$");
                    return;
                } else {
                    balance -= sum;
                }
                break;
            case REPAYMENT:
                balance += sum;
        }

        System.out.println("BACK_SYSTEM: Request accept: client = " + request.getName() + "; type = " + operation + "; sum = " + sum + "$");
        System.out.println("BACK_SYSTEM: Current balance = " + balance + "$");
    }

}
