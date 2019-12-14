package pl.hfdp.factory.stage2;

import org.junit.Before;
import org.junit.Test;
import pl.hfdp.factory.stage1.MilkShake;
import pl.hfdp.factory.stage1.StrawBerryMilkShake;

import static org.junit.Assert.*;

public class MilkShakeShopTest {

    private MilkShakeShop milkShakeShop;

    @Before
    public void setUp() throws Exception {
        milkShakeShop = new MilkShakeShop(new MilkShakeFactory());
    }

    @Test
    public void orderShake() {
        MilkShake milkShake = milkShakeShop.orderShake(StrawBerryMilkShake.name());
        assertEquals(milkShake.getClass(), StrawBerryMilkShake.class);
    }
}