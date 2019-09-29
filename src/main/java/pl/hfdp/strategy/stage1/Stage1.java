package pl.hfdp.strategy.stage1;

/**
 * In real world there aren't any simple ducks.
 * That's why it is an abstract duck.
 */
abstract class Duck {
    /**
     * All ducks can quack and the implementation of quack is same for all
     * of the ducks. So this method is a part of the superclass
     *
     * @return Quack!
     */
    public String quack() {
        return "Quack!";
    }

    /**
     * Like the method {@link #quack()}, swim can also be taken care of by the
     * Superclass
     *
     * @return Swim!
     */
    public String swim() {
        return "Swim!";
    }

    /**
     * As different ducks look different, this method will be overridden by the concrete
     * implementations
     */
    abstract public String display();

}

/**
 * The mallard is a dabbling duck that breeds throughout the temperate and subtropical Americas,
 * Eurasia, and North Africa and has been introduced to New Zealand, Australia, Peru, Brazil, Uruguay,
 * Argentina, Chile, Colombia, the Falkland Islands, and South Africa.
 */
class MallardDuck extends Duck {

    /**
     * This method defines the display properties of a mallard duck.
     * I understand that the implementation of this method can't be
     * better.
     *
     * @return the way the Mallard Duck Looks
     */
    @Override
    public String display() {
        return "Looks like a Mallard Duck!";
    }
}

/**
 * The redhead is a medium-sized diving duck.
 * The scientific name is derived from Greek aithuia an unidentified seabird mentioned by authors including Hesychius
 * and Aristotle, and Latin americana, of America.
 * <p>
 * The redhead is 37 cm long with an 84 cm wingspan.
 */
class RedHeadDuck extends Duck {

    /**
     * This method defines the display properties of a Red Head Duck.
     * Like any other Duck it swims but it has a red head.
     * <p>
     * 🦆
     *
     * @return the way the red head looks
     */
    @Override
    public String display() {
        return "Red head Duck has a red head!";
    }
}


public class Stage1 {
    public static void main(String[] args) {

    }
}
