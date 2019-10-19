package pl.hfdp.decorator.stage1;

abstract class Beverage {
    private String description;

    Beverage() {
        description = "Sample Beverage.";
    }

    public String getDescription() {
        return this.description;
    }

    public abstract int getCost();
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
    public int getCost() {
        return this.getDescription().hashCode();
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
    public int getCost() {
        return this.getDescription().hashCode();
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
    public int getCost() {
        return this.description.hashCode();
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
    public int getCost() {
        return this.description.hashCode();
    }
}

public class Stage1 {
    public static void main(String[] args) {
        System.out.println("Stage1 of Decorator Design Pattern");
    }
}
