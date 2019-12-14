package pl.hfdp.factory.stage2;

import pl.hfdp.factory.stage1.BananaMilkShake;
import pl.hfdp.factory.stage1.ChocolateMilkShake;
import pl.hfdp.factory.stage1.MilkShake;
import pl.hfdp.factory.stage1.StrawBerryMilkShake;

class MilkShakeShop {

    private MilkShakeFactory milkShakeFactory;

    MilkShakeShop(MilkShakeFactory milkShakeFactory) {
        this.milkShakeFactory = milkShakeFactory;
    }

    MilkShake orderShake(String type) {
        MilkShake milkShake;

        milkShake = milkShakeFactory.createMilkShake(type);

        milkShake.addMilk();
        milkShake.addIngredients();
        milkShake.blend();

        return milkShake;
    }
}

class MilkShakeFactory {
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

public class Stage2 {
}

