class LibraryBook {

    // Final variable
    final String ISBN;

    String title;
    String author;
    double price;

    // Constructor
    LibraryBook(String ISBN, String title, String author, double price) {

        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBook() {

        System.out.println("Book ISBN: " + ISBN);
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs. " + price);
    }

    public static void main(String[] args) {

        LibraryBook book = new LibraryBook(
            "978-0135166307",
            "Java Programming",
            "Herbert Schildt",
            650
        );

        book.displayBook();

        
    }
}