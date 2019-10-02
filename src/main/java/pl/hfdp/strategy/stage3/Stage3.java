package pl.hfdp.strategy.stage3;

/**
 * This is the extracted out behaviour.
 * Multiple concrete behaviours will be used by the {@link Duck} class to
 * execute it's performFly method.
 * <br/>
 * This behaviour is a must have for a duck.
 */
interface FlyBehaviour {
    String fly();
}

/**
 * This algorithm utilized the wings to fly.
 * ✈️
 */
class FlyWithWings implements FlyBehaviour {

    @Override
    public String fly() {
        return "fly with two wings";
    }
}

/**
 * Does not fly.
 * 🥝
 */
class FlyNoWay implements FlyBehaviour {

    @Override
    public String fly() {
        return "cannot fly";
    }
}

abstract class Duck {

    private FlyBehaviour flyBehaviour;

    /**
     * @param flyBehaviour pass the flyBehaviour object that will be used to fly
     */
    Duck(FlyBehaviour flyBehaviour) {
        if (flyBehaviour != null) {
            this.flyBehaviour = flyBehaviour;
        } else {
            throw new UnsupportedOperationException("a duck cannot be created with null fly behaviour");
        }
    }

    public String quack() {
        return "Quack!";
    }

    public String swim() {
        return "Swim!";
    }

    /**
     * Here the {@link #flyBehaviour} would be used. This method calls
     * the {@link FlyBehaviour#fly()} of the passed behaviour.
     * <p>
     * <br/>
     * This method will be inherited by all the concrete ducks
     * and it will enable each of their objects to fly.
     *
     * @return the way the ducks fly
     */
    String performFly() {
        return flyBehaviour.fly();
    }

    abstract public String display();
}

class MallardDuck extends Duck {

    MallardDuck(FlyBehaviour flyBehaviour) {
        super(flyBehaviour);
    }

    @Override
    public String display() {
        return "Looks like a Mallard Duck!";
    }
}

class RedHeadDuck extends Duck {

    RedHeadDuck(FlyBehaviour flyBehaviour) {
        super(flyBehaviour);
    }

    @Override
    public String display() {
        return "Red head Duck has a red head!";
    }
}

/**
 * 🐤
 * Rubber Duck is added to the catalogue of ducks because
 */
class RubberDuck extends Duck {

    RubberDuck(FlyBehaviour flyBehaviour) {
        super(flyBehaviour);
    }

    @Override
    public String display() {
        return "Rubber duck is yellow!";
    }
}