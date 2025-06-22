public class w1_DSA_Ex1_Inventory {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new MyProduct(101, "Laptop", 10, 60000));
        inventory.addProduct(new MyProduct(102, "Smartphone", 25, 25000));
        inventory.addProduct(new MyProduct(103, "Keyboard", 50, 700));

        inventory.updateProduct(102, 30, 24000);
        inventory.deleteProduct(103);
        inventory.displayInventory();
    }
}

// ✅ Rename class to avoid conflict
class MyProduct {
    int productId;
    String productName;
    int quantity;
    double price;

    public MyProduct(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " | Qty: " + quantity + " | ₹" + price;
    }
}

// Use the renamed class here too
class Inventory {
    private java.util.HashMap<Integer, MyProduct> inventoryMap = new java.util.HashMap<>();

    public void addProduct(MyProduct product) {
        inventoryMap.put(product.productId, product);
        System.out.println("✅ Added: " + product);
    }

    public void updateProduct(int id, int newQty, double newPrice) {
        MyProduct product = inventoryMap.get(id);
        if (product != null) {
            product.quantity = newQty;
            product.price = newPrice;
            System.out.println("🔄 Updated: " + product);
        } else {
            System.out.println("⚠️ Product ID " + id + " not found!");
        }
    }

    public void deleteProduct(int id) {
        MyProduct removed = inventoryMap.remove(id);
        if (removed != null) {
            System.out.println("🗑️ Deleted: " + removed);
        } else {
            System.out.println("⚠️ Product ID " + id + " not found!");
        }
    }

    public void displayInventory() {
        System.out.println("\n📦 Current Inventory:");
        for (MyProduct p : inventoryMap.values()) {
            System.out.println(p);
        }
    }
}
