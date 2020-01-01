package pl.hfdp.singleton.stage1;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConfigManagerTest {

    private ConfigManager configManager;

    @Before
    public void setUp() {
        configManager = new ConfigManager();
    }

    @Test
    public void updateANewKey() {
        String previousValue = configManager.update("encryption", "required");
        TestCase.assertNull(previousValue);
    }

    @Test
    public void updateAnAlreadyPresentKey() {
        String previousValue = configManager.update("host", "internal.db2");
        assertEquals("internal.db", previousValue);
    }

    @Test
    public void get() {
        String port = configManager.get("port");
        assertEquals("8179", port);
    }
}