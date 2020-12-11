import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Runner {
    private static FrontSystem frontSystem = new FrontSystem();
    private static BackSystem backSystem = new BackSystem();

    public static void main(String[] args) {
        int clientNumbers = Integer.valueOf(args[0]);

        if (clientNumbers <= 0){
            throw new RuntimeException("Invalid parameters: clients number should be more then 0.");
        }

        executeClientService(clientNumbers);
        executeHandlerService();
        executeCheckCurrentBalanceService();
    }

    private static void executeClientService(int clientNumber) {
        ExecutorService executorServiceClient = Executors.newFixedThreadPool(clientNumber);

        for(int i = 1; i <= clientNumber; i++) {
            String name = "Client_" + i;
            executorServiceClient.execute(new Client(name, frontSystem));
        }
    }

    private static void executeHandlerService() {
        ExecutorService executorServiceRequestHandler = Executors.newFixedThreadPool(2);

        executorServiceRequestHandler.execute(new RequestHandler("RequestHandler_1", frontSystem, backSystem));
        executorServiceRequestHandler.execute(new RequestHandler("RequestHandler_2", frontSystem, backSystem));
    }

    private  static void executeCheckCurrentBalanceService() {
        ExecutorService executorServiceCheckCurrentBalance = Executors.newSingleThreadExecutor();

        executorServiceCheckCurrentBalance.execute(new Runnable() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current Balance = " + backSystem.getBalance() + "$");
            }
        });
    }
}
