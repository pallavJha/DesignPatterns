package pl.hfdp.singleton.stage1;

import java.util.HashMap;
import java.util.Map;

/**
 * This the config manager.
 * The actual configuration properties are present in the HashMap configMap.
 */
class ConfigManager {

    private Map<String, String> configMap = new HashMap<String, String>() {{
        put("host", "internal.db");
        put("port", "8179");
        put("user", "admin");
        put("password", "pa$$w0rD");
    }};

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
}