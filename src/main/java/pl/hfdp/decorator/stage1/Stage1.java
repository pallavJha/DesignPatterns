package pl.hfdp.decorator.stage1;

abstract class Beverage {
    private String description;

    Beverage() {
        description = "Sample Beverage.";
    }

    public String getDescription() {
        return this.description;
    }

    public abstract double getCost();
}

class HouseBlend extends Beverage {

    private String description;

    HouseBlend() {
        this.description = "House Blend";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getCost() {
        return 10.5;
    }
}

class DarkRoast extends Beverage {

    private String description;

    DarkRoast() {
        this.description = "Dark Roast";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getCost() {
        return 5.6;
    }
}

class HouseBlendWithMochaAndStreamedMilk extends Beverage {

    private String description;

    HouseBlendWithMochaAndStreamedMilk() {
        this.description = "House Blend With Mocha And Streamed Milk";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getCost() {
        return 11.45;
    }
}

class DecalWithSoyAndMocha extends Beverage {

    private String description;

    DecalWithSoyAndMocha() {
        this.description = "Decal With Soy And Mocha";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getCost() {
        return 9.44;
    }
}

public class Stage1 {
    public static void main(String[] args) {
        System.out.println("Stage1 of Decorator Design Pattern");
    }
}
