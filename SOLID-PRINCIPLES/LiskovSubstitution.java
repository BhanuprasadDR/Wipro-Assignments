
public class LiskovSubstitution {
    public static void main(String[] args) {
        Bird bird = new Sparrow();
        bird.fly();  

        Bird another = new Crow();
        another.fly();  
    }
}

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    public void fly() {
        System.out.println("Sparrow is flying fast");
    }
}

class Crow extends Bird {
    public void fly() {
        System.out.println("Crow is flying high");
    }
}
