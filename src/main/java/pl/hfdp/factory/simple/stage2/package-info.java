/**
 * <h3>
 * Stage 2
 * </h3>
 * <p>
 * Well, our MilkShake Shop is a hit now. It has been making customers happy. And to keep them happy we'll be adding
 * more variety by adding Almond Shake and Cauliflower Shake.
 * </p>
 * <pre>
 *         if (StrawBerryMilkShake.name().equals(type)) {
 *             milkShake = new StrawBerryMilkShake();
 *         } else if (ChocolateMilkShake.name().equals(type)) {
 *             milkShake = new ChocolateMilkShake();
 *         } else if (BananaMilkShake.name().equals(type)) {
 *             milkShake = new BananaMilkShake();
 *         } else if (AlmondShake.name().equals(type)) {
 *             milkShake = new AlmondShake();
 *         } else if (CauliflowerShake.name().equals(type)) {
 *             milkShake = new CauliflowerShake();
 *         } else {
 *             throw new RuntimeException("the passed milk shake type is not available with us.");
 *         }
 *     </pre>
 * Won't this mess up the code?
 * Also, accommodating this change related to concrete classes is keeping it open for modification and this what we
 * don't want to achieve.
 * <br/>
 * This solution is breaking the following principles:
 *     <ol>
 *         <li>
 *             Identify the aspects of your application that vary and separate them from what stays the same.
 *         </li>
 *         <li>
 *             Strive for loosely coupled designs between objects that interact.
 *         </li>
 *     </ol>
 * <p>
 *     What we can do, right now, is to delegate the task of concrete object creation to a new Class. As the sole
 *     purpose of this class is to create objects, we'll call it a <b>Factory</b>, {@link pl.hfdp.factory.simple.stage2.MilkShakeFactory}.
 * </p>
 * <p>
 *     This way we've made the {@link pl.hfdp.factory.simple.stage2.MilkShakeShop#orderShake(java.lang.String)} closed for modification.
 * </p>
 * <p>
 *     And we've learnt Simple Factory Idiom(yes, this is not a Design Pattern).
 * </p>
 */

package pl.hfdp.factory.simple.stage2;