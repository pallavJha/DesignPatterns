package pl.hfdp.factory.simple.stage2;

import pl.hfdp.factory.simple.stage1.BananaMilkShake;
import pl.hfdp.factory.simple.stage1.ChocolateMilkShake;
import pl.hfdp.factory.simple.stage1.MilkShake;
import pl.hfdp.factory.simple.stage1.StrawBerryMilkShake;

/**
 * The same shop that we created in the previous stage.
 */
class MilkShakeShop {

    /**
     * This object will take care of the concrete object generation.
     */
    private MilkShakeFactory milkShakeFactory;

    MilkShakeShop(MilkShakeFactory milkShakeFactory) {
        this.milkShakeFactory = milkShakeFactory;
    }

    /**
     * @param type the type of the shake
     * @return return the delicious Milk Shake
     */
    MilkShake orderShake(String type) {
        MilkShake milkShake;

        milkShake = milkShakeFactory.createMilkShake(type);

        milkShake.addMilk();
        milkShake.addIngredients();
        milkShake.blend();

        return milkShake;
    }
}

/**
 * Out factory for creating the milk shake objects
 */
class MilkShakeFactory {
    /**
     * @param type the type of the milk shake
     * @return the concrete object for the milk shake
     */
    MilkShake createMilkShake(String type) {
        MilkShake milkShake;
        if (StrawBerryMilkShake.name().equals(type)) {
            milkShake = new StrawBerryMilkShake();
        } else if (ChocolateMilkShake.name().equals(type)) {
            milkShake = new ChocolateMilkShake();
        } else if (BananaMilkShake.name().equals(type)) {
            milkShake = new BananaMilkShake();
        } else {
            throw new RuntimeException("the passed milk shake type is not available with us.");
        }
        return milkShake;
    }
}
