package Food2Door;

public class Application {
    public static void main(String[] args) {
        Food2Door food2Door = new Food2Door();
        Order order = new Order("GlutenFreeShop",1,"Kapcie");
        food2Door.processOrder(order);
    }
}
