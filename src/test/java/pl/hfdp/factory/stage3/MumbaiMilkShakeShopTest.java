package pl.hfdp.factory.stage3;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import pl.hfdp.factory.simple.stage1.BananaMilkShake;
import pl.hfdp.factory.simple.stage1.ChocolateMilkShake;
import pl.hfdp.factory.simple.stage1.MilkShake;
import pl.hfdp.factory.simple.stage1.StrawBerryMilkShake;

public class MumbaiMilkShakeShopTest {

    private MumbaiMilkShakeShop milkShakeShop;

    @Before
    public void setUp() throws Exception {
        milkShakeShop = new MumbaiMilkShakeShop();
    }

    @Test(expected = RuntimeException.class)
    public void orderStrawBerryShake() {
        milkShakeShop.orderShake(StrawBerryMilkShake.name());

    }

    @Test
    public void orderBananaShake() {
        MilkShake milkShake = milkShakeShop.orderShake(BananaMilkShake.name());
        TestCase.assertEquals(milkShake.getClass(), BananaMilkShake.class);
    }

    @Test
    public void orderChocolateShake() {
        MilkShake milkShake = milkShakeShop.orderShake(ChocolateMilkShake.name());
        TestCase.assertEquals(milkShake.getClass(), ChocolateMilkShake.class);
    }

    @Test
    public void createMilkShake() {
        MilkShake milkShake = milkShakeShop.createMilkShake(ChocolateMilkShake.name());
        TestCase.assertEquals(milkShake.getClass(), ChocolateMilkShake.class);
    }
}