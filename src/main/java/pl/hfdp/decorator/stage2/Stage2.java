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

    void setMilk() {
        this.milk = true;
    }

    void setSoy() {
        this.soy = true;
    }

    void setMocha() {
        this.mocha = true;
    }

    void setWhip() {
        this.whip = true;
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