package pl.hfdp.factory.stage1;

/**
 * The Milk Shake Shop takes orders for the Milk Shakes and returns the exciting Milk Shakes
 * after adding milk and other ingredients and blending it
 */
class MilkShakeShop {

    /**
     * @param type the type of the milk shake
     * @return the prepared Milk Shake
     * @throws RuntimeException if the an unidentified type is passed in.
     */
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
