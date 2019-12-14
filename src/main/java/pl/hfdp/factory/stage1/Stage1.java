package pl.hfdp.factory.stage1;

class MilkShakeShop {

    MilkShake orderShake(String type) {
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

        milkShake.addMilk();
        milkShake.addIngredients();
        milkShake.blend();

        return milkShake;
    }
}
