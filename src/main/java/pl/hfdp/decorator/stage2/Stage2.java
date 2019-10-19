package pl.hfdp.decorator.stage2;

class Beverage {

    private String description;

    private boolean milk;

    private boolean soy;

    private boolean mocha;

    private boolean whip;

    Beverage() {
        this.description = "Default Beverage";
    }

    String getDescription() {
        return description;
    }

    void setMilk(boolean milk) {
        this.milk = milk;
    }

    void setSoy(boolean soy) {
        this.soy = soy;
    }

    void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    void setWhip(boolean whip) {
        this.whip = whip;
    }

    long cost() {
        return this.description.hashCode() + (this.milk ? 1 : 0) +
                (this.soy ? 1 : 0) + (this.mocha ? 1 : 0) +
                (this.whip ? 1 : 0);
    }
}

class HouseBlend extends Beverage {

    @Override
    long cost() {
        return "House Blend".hashCode() + super.cost();
    }
}

class DarkRoast extends Beverage {

    @Override
    long cost() {
        return "Dark Roast".hashCode() + super.cost();
    }
}

class Decaf extends Beverage {

    @Override
    long cost() {
        return "Decaf".hashCode() + super.cost();
    }
}

class Espresso extends Beverage {

    @Override
    long cost() {
        return "Espresso".hashCode() + super.cost();
    }
}

public class Stage2 {
    public static void main(String[] args) {
        System.out.println("Stage2 of Decorator Design Pattern");
    }
}