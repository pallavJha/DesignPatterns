package pl.hfdp.singleton.stage3;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class ConfigManagerWithEagerInitializationTest {

    @Test
    public void updateANewKey() {
        String previousValue = ConfigManagerWithEagerInitialization.getInstance().update("encryption", "required");
        assertNull(previousValue);
    }

    @Test
    public void updateAnAlreadyPresentKey() {
        String previousValue = ConfigManagerWithEagerInitialization.getInstance().update("host", "internal.db2");
        assertEquals("internal.db", previousValue);
    }

    @Test
    public void get() {
        String port = ConfigManagerWithEagerInitialization.getInstance().get("port");
        assertEquals("8179", port);
    }

    @Test
    public void checkIfGetInstanceIsSingular() {
        ConfigManagerWithEagerInitialization configManager1 = ConfigManagerWithEagerInitialization.getInstance();
        ConfigManagerWithEagerInitialization configManager2 = ConfigManagerWithEagerInitialization.getInstance();
        assertEquals(configManager1, configManager2);
    }
}