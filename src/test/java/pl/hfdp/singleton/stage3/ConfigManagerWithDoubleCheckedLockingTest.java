package pl.hfdp.singleton.stage3;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class ConfigManagerWithDoubleCheckedLockingTest {

    @Test
    public void updateANewKey() {
        String previousValue = ConfigManagerWithDoubleCheckedLocking.getInstance().update("encryption", "required");
        assertNull(previousValue);
    }

    @Test
    public void updateAnAlreadyPresentKey() {
        String previousValue = ConfigManagerWithDoubleCheckedLocking.getInstance().update("host", "internal.db2");
        assertEquals("internal.db", previousValue);
    }

    @Test
    public void get() {
        String port = ConfigManagerWithDoubleCheckedLocking.getInstance().get("port");
        assertEquals("8179", port);
    }

    @Test
    public void checkIfGetInstanceIsSingular() {
        ConfigManagerWithDoubleCheckedLocking configManager1 = ConfigManagerWithDoubleCheckedLocking.getInstance();
        ConfigManagerWithDoubleCheckedLocking configManager2 = ConfigManagerWithDoubleCheckedLocking.getInstance();
        assertEquals(configManager1, configManager2);
    }

    @Test
    public void checkIfGetInstanceIsSingular2() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<ConfigManagerWithDoubleCheckedLocking> result = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.submit(() -> result.add(finalI, ConfigManagerWithDoubleCheckedLocking.getInstance()));
        }
        executor.awaitTermination(1, TimeUnit.SECONDS);

        assertEquals(1, new HashSet<>(result).size());
    }
}