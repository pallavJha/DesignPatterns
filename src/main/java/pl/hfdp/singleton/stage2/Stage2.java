package pl.hfdp.singleton.stage2;

import java.util.HashMap;
import java.util.Map;

/**
 * This config manager now has a private constructor.
 */
class ConfigManager {

    public static ConfigManager instance;

    private Map<String, String> configMap = new HashMap<String, String>() {{
        put("host", "internal.db");
        put("port", "8179");
        put("user", "admin");
        put("password", "pa$$w0rD");
    }};

    /**
     * There's a private constructor as we don't want any object of this class created anywhere outside this class
     */
    private ConfigManager() {

    }

    /**
     * This method updates the configuration by adding the new key and value pair to the configMap
     *
     * @param key   name of the key
     * @param value value for the key
     * @return previous value
     */
    public String update(String key, String value) {
        return configMap.put(key, value);
    }

    /**
     * @param key key for which the value is to be retrieved
     * @return value, null if not present
     */
    public String get(String key) {
        return configMap.get(key);
    }

    /**
     * @return the singleton instance of the Config Manager
     */
    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
}
