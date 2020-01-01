/**
 * Now we've only one method that is initializing the object and as the constructor is private, this instance cannot be
 * initialized outside the class.
 * <p>
 * You might notice that we've made the method synchronized because we don't want multiple initialization of the object.
 * However, after the first time(after the object is initialized) synchronization is becoming an unnecessary evil.
 * If that is a cause of concern for you then there are two possible solutions for that:
 * <ol>
 *     <li>
 *         Eager Initialization: Here the instance will be statically initialized <b>even when it is not accessed<b/>.
 *         This might not be a good solution if object creation is costly as it'll be initialized even when not being
 *         accessed.
 *     </li>
 *     <li>
 *         Using Double Checked Locking: Here we first check to see if an instance is created, and if not,
 *         THEN we synchronize.
 *     </li>
 * </ol>
 */
package pl.hfdp.singleton.stage3;