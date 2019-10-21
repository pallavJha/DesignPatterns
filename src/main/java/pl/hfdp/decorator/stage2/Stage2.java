package pl.hfdp.decorator.stage2;

class Beverage {

    private boolean milk;

    private boolean soy;

    private boolean mocha;

    private boolean whip;

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

    double cost() {
        return 0D + (this.milk ? 1 : 0) +
                (this.soy ? 1 : 0) + (this.mocha ? 1 : 0) +
                (this.whip ? 1 : 0);
    }
}

class HouseBlend extends Beverage {

    @Override
    double cost() {
        return 10.5 + super.cost();
    }
}

class DarkRoast extends Beverage {

    @Override
    double cost() {
        return 5.6 + super.cost();
    }
}

class Decaf extends Beverage {

    @Override
    double cost() {
        return 11.23 + super.cost();
    }
}

class Espresso extends Beverage {

    @Override
    double cost() {
        return 3.55 + super.cost();
    }
}

public class Stage2 {
    public static void main(String[] args) {
        System.out.println("Stage2 of Decorator Design Pattern");
    }
}