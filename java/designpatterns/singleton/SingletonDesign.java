package designpatterns.singleton;

/**
 * This class simulates a single printer in an office that is shared by everyone. It ensures that only
 * one `PrinterService` exists across the entire program and its setting (e.g. mode) is consistently
 * shared .
 */
class PrinterService {
    /**
     * The `volatile` keyword makes all changes to this variable immediately vislbe to all threads. It
     * is only assigned when `getInstance()` is invoked for the very first time.
     */
    private static volatile PrinterService uniqueInstance = null;

    private String mode;

    /**
     * This constructor is private to restrict public instantiations from outside. This is the backbone
     * of the Singleton pattern's "one instance" rule.
     */
    private PrinterService() {
        this.mode = "Grayscale";
    }

    /**
     * This is the only entryway to this Singleton class
     */
    public static PrinterService getInstance() {
        if (uniqueInstance == null) {                       // 1. First check without locking
            synchronized (PrinterService.class) {           // 2. Lock on class object to prevent multiple threads from modifying the same instance
                if (uniqueInstance == null) {               // 3. Double-check to make sure we ONLY create an instance for the first time, prevents waiting threads from creating a new instance again
                    uniqueInstance = new PrinterService();  // Create the instance
                }
            }
        }
        return uniqueInstance;                              // 4. Return the singleton instance
    }

    public String getPrinterStatus() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
        System.out.println("Mode changed to " + mode);
    }
}

/**
 * The Singleton is a creational pattern that ensures a class has at most one instance and provides
 * a global point of access to this instance.
 */
public class SingletonDesign {
    public static void main(String[] args) {
        PrinterService p1 = PrinterService.getInstance();
        PrinterService p2 = PrinterService.getInstance();

        p1.setMode("Color");
        p2.setMode("Grayscale");

        System.out.println(p1.getPrinterStatus()); // "Grayscale"
        System.out.println(p2.getPrinterStatus()); // "Grayscale"

        System.out.println(p1 == p2); // true
    }
}
