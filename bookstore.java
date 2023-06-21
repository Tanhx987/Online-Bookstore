// Book class
public class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

//EBook class (subclass of Book)
public class EBook extends Book {
    private String fileFormat;

    public EBook(String title, String author, double price, int quantity, String fileFormat) {
        super(title, author, price, quantity);
        this.fileFormat = fileFormat;
    }

    //Getters and setters
    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    //Task methods
    public void openBook() {
        System.out.println("The book is opened and you may start reading.");
    }

    public void downloadBook() {
        System.out.println("The book has begun downloading.");
    }

    public boolean validateFormat() {
        return fileFormat.equals(".pdf") || fileFormat.equals(".epub");
    }
}

//PhysicalBook class (subclass of Book)
public class PhysicalBook extends Book {
    private double weight;

    public PhysicalBook(String title, String author, double price, int quantity, double weight) {
        super(title, author, price, quantity);
        this.weight = weight;
    }

    //Getters and setters
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //Task methods
    public double calculateShippingCost() {
        double initialWeight = 500.0;
        double initialCost = 4.50;
        double additionalWeight = weight - initialWeight;
        double additionalCost = Math.ceil(additionalWeight / 250) * 1.00;
        return initialCost + additionalCost;
    }

    public double getWeightInPounds() {
        return weight * 0.00220462;
    }
}

//Testing the classes
public class OnlineBookstore {
    public static void main(String[] args) {
        //Creating an EBook object
        EBook eBook = new EBook("Java: The Complete Reference", "Herbert Schildt", 9.99, 100, ".pdf");
        eBook.openBook();
        eBook.downloadBook();
        System.out.println("Valid format? " + eBook.validateFormat());

        //Creating a PhysicalBook object
        PhysicalBook physicalBook = new PhysicalBook("Clean Code", "Robert C. Martin", 29.99, 50, 1200.0);
        System.out.println("Shipping cost: $" + physicalBook.calculateShippingCost());
        System.out.println("Weight in pounds: " + physicalBook.getWeightInPounds() + " lbs");
    }
}
