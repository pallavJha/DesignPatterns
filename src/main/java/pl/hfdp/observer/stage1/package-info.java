/**
 * Here we begin the Chapter of Observer Pattern.
 * <p>
 * <br>
 * <u>Problem:</u>
 * <br>
 * There's a magazine company, ReadDigest, which has a complex algorithm of
 * creating the weekly article. It wants to send the newly generated articles
 * to it's subscribers but it doesn't know how to do it.
 * <br>
 * <b>This is the problem.</b>
 * <br>
 * It has provided us the api that is called whenever new contents are
 * generated. We've to just hook our subscription algorithm into it.
 * The solution is divided into multiple stages. In the first stage we'll start
 * with a very simple and straight forward approach and then we'll move on
 * to a better solution.
 */
package pl.hfdp.observer.stage1;