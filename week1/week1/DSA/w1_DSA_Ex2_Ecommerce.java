public class w1_DSA_Ex2_Ecommerce {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Smartphone", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Headphones", "Electronics")
        };

        // Sort for binary search
        java.util.Arrays.sort(products, java.util.Comparator.comparingInt(p -> p.productId));

        System.out.println("🔍 Linear Search for productId 104:");
        Product foundLinear = SearchUtils.linearSearch(products, 104);
        System.out.println(foundLinear != null ? foundLinear : "Product not found");

        System.out.println("\n🔍 Binary Search for productId 104:");
        Product foundBinary = SearchUtils.binarySearch(products, 104);
        System.out.println(foundBinary != null ? foundBinary : "Product not found");
    }
}

// Class representing a product
class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + "] " + productName + " - " + category;
    }
}

// Class containing search utility methods
class SearchUtils {
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
