package pl.hfdp.factory.simple.stage2;

import org.junit.Before;
import org.junit.Test;
import pl.hfdp.factory.simple.stage1.BananaMilkShake;
import pl.hfdp.factory.simple.stage1.ChocolateMilkShake;
import pl.hfdp.factory.simple.stage1.MilkShake;
import pl.hfdp.factory.simple.stage1.StrawBerryMilkShake;

import static org.junit.Assert.assertEquals;

public class MilkShakeFactoryTest {

    private MilkShakeFactory factory;

    @Before
    public void setUp() {
        factory = new MilkShakeFactory();
    }

    @Test
    public void createStrawBerryMilkShake() {
        MilkShake strawBerryMilkShake = factory.createMilkShake(StrawBerryMilkShake.name());
        assertEquals(strawBerryMilkShake.getClass(), StrawBerryMilkShake.class);
    }

    @Test
    public void createBananaMilkShake() {
        MilkShake strawBerryMilkShake = factory.createMilkShake(BananaMilkShake.name());
        assertEquals(strawBerryMilkShake.getClass(), BananaMilkShake.class);
    }

    @Test
    public void createChocolateMilkShake() {
        MilkShake strawBerryMilkShake = factory.createMilkShake(ChocolateMilkShake.name());
        assertEquals(strawBerryMilkShake.getClass(), ChocolateMilkShake.class);
    }

    @Test(expected = RuntimeException.class)
    public void orderShake() {
        factory.createMilkShake("Bad name");
    }
}