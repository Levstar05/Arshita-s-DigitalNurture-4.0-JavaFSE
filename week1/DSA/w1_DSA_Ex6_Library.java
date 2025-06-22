import java.util.Arrays;
import java.util.Comparator;

public class w1_DSA_Ex6_Library {
    public static void main(String[] args) {
        Book[] library = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "1984", "George Orwell"),
            new Book(103, "Brave New World", "Aldous Huxley"),
            new Book(104, "To Kill a Mockingbird", "Harper Lee"),
            new Book(105, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        // LINEAR SEARCH (Unsorted)
        System.out.println("🔍 Linear Search: '1984'");
        Book foundLinear = linearSearchByTitle(library, "1984");
        System.out.println(foundLinear != null ? foundLinear : "Book not found.");

        // Sort library before binary search
        Arrays.sort(library, Comparator.comparing(b -> b.title));

        // BINARY SEARCH (Sorted)
        System.out.println("\n🧠 Binary Search: '1984'");
        Book foundBinary = binarySearchByTitle(library, "1984");
        System.out.println(foundBinary != null ? foundBinary : "Book not found.");
    }

    // Book class
    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int id, String title, String author) {
            this.bookId = id;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "[" + bookId + "] " + title + " by " + author;
        }
    }

    // 1. Linear Search
    static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    // 2. Binary Search (requires sorted array)
    static Book binarySearchByTitle(Book[] books, String targetTitle) {
        int low = 0, high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(targetTitle);

            if (cmp == 0)
                return books[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }
}
