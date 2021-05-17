package Food2Door;

public class Application {
    public static void main(String[] args) {
        Order order = new Order();
        OrderProcessor orderProcessor = new OrderProcessor(new EmailInformationService(),);
    }
}
