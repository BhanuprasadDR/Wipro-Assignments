
public class InterfaceSegregation {
    public static void main(String[] args) {
        Printer basicPrinter = new SimplePrinter();
        basicPrinter.print();

        MultiFunctionPrinter mfp = new AllInOnePrinter();
        mfp.print();
        mfp.scan();
    }
}

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface MultiFunctionPrinter extends Printer, Scanner {}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing from SimplePrinter");
    }
}

class AllInOnePrinter implements MultiFunctionPrinter {
    public void print() {
        System.out.println("Printing from AllInOnePrinter");
    }
    public void scan() {
        System.out.println("Scanning from AllInOnePrinter");
    }
}
