package pl.hfdp.strategy.stage2;

/**
 * 🦆
 */
abstract class Duck {

    public String quack() {
        return "Quack!";
    }

    public String swim() {
        return "Swim!";
    }

    /**
     * This method will be inherited by all the concrete ducks
     * and it will enable each of their objects to fly.
     *
     * @return the way the ducks fly
     */
    public String fly() {
        return "Fly!";
    }

    abstract public String display();
}

class MallardDuck extends Duck {

    @Override
    public String display() {
        return "Looks like a Mallard Duck!";
    }
}

class RedHeadDuck extends Duck {

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

    @Override
    public String display() {
        return "Rubber duck is yellow!";
    }

    /**
     * This is a Rubber Duck and it cannot fly(naturally). As the {@link pl.hfdp.strategy.stage2.Duck}
     * already has the method fly, that behaviour was inherited by the Rubber Duck.
     * <br/>
     * To stop that we have to override the {@link pl.hfdp.strategy.stage2.Duck#fly()} method of the Rubber Duck.
     *
     * @return actually, nothing
     * @throws UnsupportedOperationException because a rubber duck cannot fly
     */
    @Override
    public String fly() {
        throw new UnsupportedOperationException("a rubber duck cannot fly");
    }
}