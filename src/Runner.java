public class Runner {
    public static void main(String[] args) {
        int client_numbers = Integer.valueOf(args[0]);
        FrontSystem frontSystem = new FrontSystem();
        BackSystem backSystem = new BackSystem();

        for(int i = 1; i <= client_numbers; i++) {
            StringBuilder name = new StringBuilder("Client_");
            name.append(i);
            new Client(name.toString(), frontSystem).start();
        }

        new RequestHandler("RequestHandler_1", frontSystem, backSystem).start();
        new RequestHandler("RequestHandler_1", frontSystem, backSystem).start();
    }
}
