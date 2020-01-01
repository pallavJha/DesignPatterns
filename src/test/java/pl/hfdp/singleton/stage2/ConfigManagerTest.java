package pl.hfdp.singleton.stage2;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class ConfigManagerTest {

    @Test
    public void updateANewKey() {
        String previousValue = ConfigManager.getInstance().update("encryption", "required");
        assertNull(previousValue);
    }

    @Test
    public void updateAnAlreadyPresentKey() {
        String previousValue = ConfigManager.getInstance().update("host", "internal.db2");
        assertEquals("internal.db", previousValue);
    }

    @Test
    public void get() {
        String port = ConfigManager.getInstance().get("port");
        assertEquals("8179", port);
    }

    @Test
    public void checkIfGetInstanceIsSingular() {
        ConfigManager configManager1 = ConfigManager.getInstance();
        ConfigManager configManager2 = ConfigManager.getInstance();
        assertEquals(configManager1, configManager2);
    }
}