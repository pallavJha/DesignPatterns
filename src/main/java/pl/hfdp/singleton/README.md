Here we begin the chapter of Singleton Design Pattern. 
We'll start by creating a Config Manager and afterwards we'll try to find the problems in it's implementation.
The requirements for the Config manager are
- It should load the default properties for the system.
- It should support the updates for the properties and make the updates available.

```java
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
```

So what could be the problems in our implementation?
Well, there can be multiple objects of ConfigManager class and due to that there can be multiple values for the same key
among the multiple objects. For example,
```java    
    ConfigManager configManager1 = new ConfigManager();
    ConfigManager configManager2 = new ConfigManager();
  
    configManager1.update("password", "NĒwAndImPr0vĒD");
  
    // this password is not equal to "NĒwAndImPr0vĒD"
    String password = configManager2.get("password");
```   
The behaviour of this class requires it's object to be used in Singleton mode. 
That is, only one object throughout the process lifetime.

Let's re-implement our Config Manager so that only one instance of this class can be created.

```java
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
     * This block is synchronized as we want the threads to access this method one at a time.
     *
     * @return the singleton instance of the Config Manager
     */
    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
}
```
Now we've only one method that is initializing the object and as the constructor is private, this instance cannot be 
initialized outside the class.

You might notice that we've made the method synchronized because we don't want multiple initialization of the object. 
However, after the first time(after the object is initialized) synchronization is becoming an unnecessary evil. If that 
is a cause of concern for you then there are two possible solutions for that:
- Eager Initialization: Here the instance will be statically initialized even when it is not accessed. 
  This might not be a good solution if object creation is costly as it'll be initialized even when not being accessed.
```java
  class ConfigManagerWithEagerInitialization {
  
      /**
       * The instance object is now Eagerly initialized
       */
      public static ConfigManagerWithEagerInitialization instance = new ConfigManagerWithEagerInitialization();
  
      private Map<String, String> configMap = new HashMap<String, String>() {{
          put("host", "internal.db");
          put("port", "8179");
          put("user", "admin");
          put("password", "pa$$w0rD");
      }};
  
      private ConfigManagerWithEagerInitialization() {
  
      }
  
      public String update(String key, String value) {
          return configMap.put(key, value);
      }
  
      public String get(String key) {
          return configMap.get(key);
      }
  
      public static ConfigManagerWithEagerInitialization getInstance() {
          return instance;
      }
  }
```
- Using Double Checked Locking: Here we first check to see if an instance is created, and if not, THEN we synchronize.
```java
  class ConfigManagerWithDoubleCheckedLocking {
  
      /**
       * The volatile keyword ensures that multiple threads handle this instance correctly.
       */
      public volatile static ConfigManagerWithDoubleCheckedLocking instance;
  
      private Map<String, String> configMap = new HashMap<String, String>() {{
          put("host", "internal.db");
          put("port", "8179");
          put("user", "admin");
          put("password", "pa$$w0rD");
      }};
  
      private ConfigManagerWithDoubleCheckedLocking() {
  
      }
  
      public String update(String key, String value) {
          return configMap.put(key, value);
      }
  
      public String get(String key) {
          return configMap.get(key);
      }
  
      /**
       * The method uses double checked locking for initializing the instance.
       *
       * @return new Config Manager
       */
      public static ConfigManagerWithDoubleCheckedLocking getInstance() {
          if (instance == null) {
              // the synchronized block is only inside the this if because
              // only on this section multiple threads can try to initialize the instance
              synchronized (ConfigManagerWithDoubleCheckedLocking.class) {
                  // one more null check because the other threads that have acquired the lock would have initialized it
                  if (instance == null) {
                      instance = new ConfigManagerWithDoubleCheckedLocking();
                  }
              }
          }
          return instance;
      }
  }
```

