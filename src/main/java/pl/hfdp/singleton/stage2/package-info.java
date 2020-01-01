/**
 * So what could be the problems in our implementation?
 * <p>
 * Well, there can be multiple objects of <code>ConfigManager</code> class and due to that there can be multiple values
 * for the same key among the multiple objects. For example,
 * <pre>
 *  ConfigManager configManager1 = new ConfigManager();
 *  ConfigManager configManager2 = new ConfigManager();
 *
 *  configManager1.update("password", "NĒwAndImPr0vĒD")
 *
 *  // this password is not equal to "NĒwAndImPr0vĒD"
 *  String password = configManager2.get("password")
 * </pre>
 * <p>
 * The behaviour of this class requires it's object to be used in Singleton mode. That is, only one object throughout
 * the process lifetime.
 * <p>
 * Let's re-implement our Config Manager so that only one instance of this class can be created.
 */
package pl.hfdp.singleton.stage2;