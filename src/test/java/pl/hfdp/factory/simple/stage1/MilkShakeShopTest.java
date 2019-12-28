package pl.hfdp.factory.simple.stage1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MilkShakeShopTest {

    private MilkShakeShop milkShakeShop;

    @Before
    public void setUp() throws Exception {
        milkShakeShop = new MilkShakeShop();
    }

    @Test
    public void orderStrawberryShake() {
        MilkShake shake = milkShakeShop.orderShake(StrawBerryMilkShake.name());
        assertEquals(shake.getClass(), StrawBerryMilkShake.class);
    }

    @Test
    public void orderBananaShake() {
        MilkShake shake = milkShakeShop.orderShake(BananaMilkShake.name());
        assertEquals(shake.getClass(), BananaMilkShake.class);
    }

    @Test
    public void orderChocolateShake() {
        MilkShake shake = milkShakeShop.orderShake(ChocolateMilkShake.name());
        assertEquals(shake.getClass(), ChocolateMilkShake.class);
    }

    @Test(expected = RuntimeException.class)
    public void orderShake() {
        milkShakeShop.orderShake("Bad name");
    }
}