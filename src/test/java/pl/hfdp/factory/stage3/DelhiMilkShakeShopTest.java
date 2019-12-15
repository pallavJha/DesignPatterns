package pl.hfdp.factory.stage3;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import pl.hfdp.factory.stage1.BananaMilkShake;
import pl.hfdp.factory.stage1.MilkShake;
import pl.hfdp.factory.stage1.StrawBerryMilkShake;

public class DelhiMilkShakeShopTest {

    private DelhiMilkShakeShop milkShakeShop;

    @Before
    public void setUp() {
        milkShakeShop = new DelhiMilkShakeShop();
    }

    @Test
    public void orderStrawBerryShake() {
        MilkShake milkShake = milkShakeShop.orderShake(StrawBerryMilkShake.name());
        TestCase.assertEquals(milkShake.getClass(), StrawBerryMilkShake.class);
    }

    @Test(expected = RuntimeException.class)
    public void orderBananaShake() {
        milkShakeShop.orderShake(BananaMilkShake.name());
    }

    @Test
    public void createMilkShake() {
        MilkShake milkShake = milkShakeShop.createMilkShake(StrawBerryMilkShake.name());
        TestCase.assertEquals(milkShake.getClass(), StrawBerryMilkShake.class);
    }

}