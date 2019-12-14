package pl.hfdp.decorator.stage1;

/**
 * Super class of all the beverages.
 * <br/>
 * It is an abstract class because the {@link Beverage#cost()} needs to be overridden by the
 * concrete implementations.
 * ☕
 */
abstract class Beverage {
    /**
     * The description of the beverage.
     */
    private String description;

    Beverage() {
        description = "Sample Beverage.";
    }

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}

/**
 * Extending the Beverage class, the HouseBlend coffee overrides the cost method.
 */
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
    public double cost() {
        return 10.5;
    }
}

/**
 * One more type of a Coffee
 */
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
    public double cost() {
        return 5.6;
    }
}

/**
 * House Blend Coffee With Mocha And Streamed Milk
 */
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
    public double cost() {
        return 11.45;
    }
}

/**
 * Decal With Soy And Mocha
 */
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
    public double cost() {
        return 9.44;
    }
}
