/**
 * While we're able to successfully notify all the customers of
 * ReadDigest whenever there's some new info available but there
 * are a few mistakes that we cannot ignore.
 * <p>
 * Let's look at them:
 * <ol>
 *     <li>
 *         As we directly used the objects of the subscribers inside the ReadDigest class, we didn't follow <b>loose coupling</b>.
 *     </li>
 *     <li>
 *         And due to it whenever a new subscriber is supposed to be added or deleted
 *         <b>we'll have to update the code</b> of ReadDigest.
 *     </li>
 *     <li>
 *         The method names of the subscribers are different which means that <b>we've not encapsulated the changes</b>.
 *     </li>
 * </ol>
 * <p>
 * Now we know the mistakes. Let's try to fix them by using Observer Design Pattern.
 */
package pl.hfdp.observer.stage2;