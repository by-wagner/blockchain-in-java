import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StockItem {
    private String name;
    private double pricePerUnit;
    private int quantity;

    public StockItem(String name, double pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": " + pricePerUnit + ", " + quantity + ";";
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalValue() {
        return pricePerUnit * quantity;
    }
}

class Utils {
    public static List<StockItem> sort(List<StockItem> stockItems) {
        Collections.sort(stockItems, new Comparator<StockItem>() {
            @Override
            public int compare(StockItem s1, StockItem s2) {
                double totalValue1 = s1.getTotalValue();
                double totalValue2 = s2.getTotalValue();
                return Double.compare(totalValue2, totalValue1);
            }
        });
        return stockItems;
    }
}