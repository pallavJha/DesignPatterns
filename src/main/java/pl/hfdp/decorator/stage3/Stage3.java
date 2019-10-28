package pl.hfdp.decorator.stage3;

/**
 * Beverages have kept the cost as abstract
 */
abstract class Beverage {
    String description = "Beverage";

    String getDescription() {
        return description;
    }

    public abstract double cost();
}

abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}

class Espresso extends Beverage {

    Espresso() {
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        return 5.7;
    }
}

class HouseBlend extends Beverage {

    HouseBlend() {
        this.description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 3.8;
    }
}

class Mocha extends CondimentDecorator {

    private Beverage beverage;

    Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.5D;
    }
}

class Whip extends CondimentDecorator {

    private Beverage beverage;

    Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.5D;
    }
}

public class Stage3 {
    public static void main(String[] args) {
        System.out.println("Stage3 of Decorator Design Pattern");
    }
}