public class w1_DSA_Ex3_SortingOrders {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Arshita", 3500.0),
            new Order(102, "Rahul", 1200.0),
            new Order(103, "Sneha", 5600.0),
            new Order(104, "Karan", 4200.0),
            new Order(105, "Priya", 2900.0)
        };

        System.out.println("🔢 Original Orders:");
        printOrders(orders);

        // Bubble Sort
        Order[] bubbleSorted = orders.clone();
        bubbleSort(bubbleSorted);
        System.out.println("\n🫧 After Bubble Sort (by totalPrice):");
        printOrders(bubbleSorted);

        // Quick Sort
        Order[] quickSorted = orders.clone();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\n⚡ After Quick Sort (by totalPrice):");
        printOrders(quickSorted);
    }

    // 1. Order class
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int id, String name, double price) {
            this.orderId = id;
            this.customerName = name;
            this.totalPrice = price;
        }

        @Override
        public String toString() {
            return "[" + orderId + "] " + customerName + " - ₹" + totalPrice;
        }
    }

    // 2. Bubble Sort: Simple but inefficient
    static void bubbleSort(Order[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    // swap
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // 3. Quick Sort: Divide & conquer
    static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Place pivot in the correct position
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Utility method to print orders
    static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}
