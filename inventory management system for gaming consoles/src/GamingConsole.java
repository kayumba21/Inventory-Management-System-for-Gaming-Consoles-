public class GamingConsole implements ConsoleActions {
    private String modelName;
    private double price;
    private int stock;
    private boolean isHighDemand;

    public GamingConsole(String modelName, double price, int stock, boolean isHighDemand) {
        this.modelName = modelName;
        this.price = price;
        this.stock = stock;
        this.isHighDemand = isHighDemand;
    }

    @Override
    public void addStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.stock += quantity;
    }

    @Override
    public double calculateDiscount() {
        return isHighDemand ? price * 0.15 : price * 0.05;
    }

    public void applyBulkDiscount(double percentage) {
        if (percentage < 0 || percentage > 50) {
            throw new IllegalArgumentException("Discount percentage must be between 0% and 50%.");
        }
        this.price -= (this.price * (percentage / 100));
    }

    public void displayDetails() {
        System.out.println("Model: " + modelName + ", Price: $" + price + ", Stock: " + stock);
    }

    public String getModelName() {
        return modelName;
    }
}
