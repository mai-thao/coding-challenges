package designpatterns.singleton;

class PrinterService {
    private static volatile PrinterService uniqueInstance = null;

    private String mode;

    private PrinterService() {
        this.mode = "Grayscale";
    }

    public static PrinterService getInstance() {
        if (uniqueInstance == null) {                       // 1. First check without locking
            synchronized (PrinterService.class) {           // 2. Lock on class object to prevent multiple threads from modifying the same instance
                if (uniqueInstance == null) {               // 3. Double-check to make sure it's null before creating
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
