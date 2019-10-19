package pl.hfdp.decorator.stage3;

abstract class Beverage {
    String description = "Beverage";

    public String getDescription() {
        return description;
    }

    public abstract long cost();
}

public class Stage2 {
    public static void main(String[] args) {
        System.out.println("Stage3 of Decorator Design Pattern");
    }
}