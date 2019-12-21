package pl.hfdp.factory.stage3;


import pl.hfdp.factory.stage1.BananaMilkShake;
import pl.hfdp.factory.stage1.ChocolateMilkShake;
import pl.hfdp.factory.stage1.MilkShake;
import pl.hfdp.factory.stage1.StrawBerryMilkShake;

/**
 * This new milk cake shop is delegating the object creation process to its concrete classes3
 */
abstract class MilkShakeShop {

    abstract MilkShake createMilkShake(String type);

    MilkShake orderShake(String type) {
        MilkShake milkShake;

        milkShake = createMilkShake(type);

        milkShake.addMilk();
        milkShake.addIngredients();
        milkShake.blend();

        return milkShake;
    }
}

class DelhiMilkShakeShop extends MilkShakeShop {
    MilkShake createMilkShake(String type) {
        MilkShake milkShake;
        if (StrawBerryMilkShake.name().equals(type)) {
            milkShake = new StrawBerryMilkShake();
        } else {
            throw new RuntimeException("the passed milk shake type is not available with us.");
        }
        return milkShake;
    }
}

class MumbaiMilkShakeShop extends MilkShakeShop {
    MilkShake createMilkShake(String type) {
        MilkShake milkShake;
        if (ChocolateMilkShake.name().equals(type)) {
            milkShake = new ChocolateMilkShake();
        } else if (BananaMilkShake.name().equals(type)) {
            milkShake = new BananaMilkShake();
        } else {
            throw new RuntimeException("the passed milk shake type is not available with us.");
        }
        return milkShake;
    }
}
