Here we begin the Chapter of Observer Pattern.

**Problem**: There's a magazine company, ReadDigest, which has a complex algorithm of creating the weekly article. 
It wants to send the newly generated articles to it's subscribers but it doesn't know how to do it. 
This is the problem that we've to solve. 

It has provided us the api that is called whenever new contents are generated. 
We've to just hook our subscription algorithm into it. The solution is divided into multiple stages. 
In the first stage we'll start with a very simple and straight forward approach and 
then we'll move on to a better solution.

```java
package pl.hfdp.observer.stage1;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.stream.IntStream;

/**
 * ReadDigest is a magazine which generates its content
 * {@link #currentTitle} and {@link #moreInfo}.
 * <p>
 * The process of notifying the customers about the new info
 * is done by the method {@link #onNewContent()}. As this class
 * haven't got any info about it's customers and the subscription
 * process, the method {@link #onNewContent()} is left abstract.
 */
abstract class ReadDigest {
    /**
     * The title of the current edition
     */
    private String currentTitle;

    /**
     * Some information about the current edition
     */
    private String moreInfo;

    /**
     * This method is called whenever there is some new content available
     */
    abstract void onNewContent();

    /**
     * This method generates the new content for the magazine
     * and calls {@link #onNewContent()} for broadcasting the info.
     */
    void generateContent() {
        DataFactory df = new DataFactory();
        this.currentTitle = df.getRandomText(10);
        this.moreInfo = df.getRandomText(100);
        this.onNewContent();
    }

    /**
     * Getter for {@link #currentTitle}
     *
     * @return currentTitle
     */
    String getCurrentTitle() {
        return currentTitle;
    }

    /**
     * Getter for {@link #moreInfo}
     *
     * @return moreInfo
     */
    String getMoreInfo() {
        return moreInfo;
    }
}

/**
 * ReadDigestWithSubscription extends ReadDigest. It implements {@link #onNewContent()}
 * because it knows its customers and broadcasts new info to them.
 */
class ReadDigestWithSubscription extends ReadDigest {

    private RaceCarDriver raceCarDriver;
    private NewsPaperMan newsPaperMan;
    private MovieDirector movieDirector;

    /**
     * Constructor with all the customers.
     * <br>
     * This constructor is not implemented correctly because it is accepting all of the customers
     * one by one through the arguments. This might seem viable for 2-3 customers but there's no
     * way it can support thousands of them.
     *
     * @param raceCarDriver raceCarDriver
     * @param newsPaperMan  newsPaperMan
     * @param movieDirector movieDirector
     */
    ReadDigestWithSubscription(RaceCarDriver raceCarDriver, NewsPaperMan newsPaperMan, MovieDirector movieDirector) {
        this.movieDirector = movieDirector;
        this.raceCarDriver = raceCarDriver;
        this.newsPaperMan = newsPaperMan;
    }

    @Override
    void onNewContent() {
        raceCarDriver.receiveNewContent(this.getCurrentTitle(), this.getMoreInfo());
        newsPaperMan.receiveNewArticle(this.getCurrentTitle(), this.getMoreInfo());
        movieDirector.receiveNewMediaStory(this.getCurrentTitle(), this.getMoreInfo());
    }
}

/**
 * RaceCarDriver likes to read our magazine, ReadDigest.
 */
class RaceCarDriver {

    /**
     * This is how the RaceCarDriver receives the new content from the
     * ReadDigest magazine.
     *
     * @param title       currentTitle
     * @param moreContent moreContent
     */
    void receiveNewContent(String title, String moreContent) {
        System.out.println("RaceCarDriver Receives...");
        System.out.println(title);
        System.out.println(moreContent);
    }
}

/**
 * Like the {@link RaceCarDriver}, NewspaperMan likes to read our magazine, ReadDigest.
 */
class NewsPaperMan {

    /**
     * This is how the {@link NewsPaperMan} receives the new content from the
     * ReadDigest magazine.
     *
     * @param title       currentTitle
     * @param moreContent moreContent
     */
    void receiveNewArticle(String title, String moreContent) {
        System.out.println("NewsPaperMan Receives...");
        System.out.println(title);
        System.out.println(moreContent);
    }
}

/**
 * Likewise the {@link RaceCarDriver} and {@link NewsPaperMan}
 */
class MovieDirector {

    /**
     * This is how the MovieDirector receives the new content from the
     * ReadDigest magazine.
     *
     * @param title       currentTitle
     * @param moreContent moreContent
     */
    void receiveNewMediaStory(String title, String moreContent) {
        System.out.println("MovieDirector Receives...");
        System.out.println(title);
        System.out.println(moreContent);
    }
}


/**
 * Runs the stage1 of this package
 */
public class Stage1 {

    public static void main(String[] args) {
        RaceCarDriver raceCarDriver = new RaceCarDriver();
        NewsPaperMan newsPaperMan = new NewsPaperMan();
        MovieDirector movieDirector = new MovieDirector();

        ReadDigestWithSubscription magazine = new ReadDigestWithSubscription(raceCarDriver, newsPaperMan, movieDirector);
        IntStream.range(0, 10).forEach(i -> magazine.generateContent());
    }
}

```

While we're able to successfully notify all the customers of ReadDigest whenever there's some new info available 
but there are a few mistakes that we cannot ignore.
Let's look at them:

- As we directly used the objects of the subscribers inside the ReadDigest class, we didn't follow loose coupling.
- And due to it whenever a new subscriber is supposed to be added or deleted 
  **we'll have to update the code of ReadDigest**.
- The method names of the subscribers are different which means that we've not encapsulated the changes.

Now that we know the mistakes. Let's try to fix them by using Observer Design Pattern.

```java
package pl.hfdp.observer.stage2;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Observable;
import java.util.Observer;
import java.util.stream.IntStream;

/**
 * ReadDigest is a magazine which generates its content
 * {@link #currentTitle} and {@link #moreInfo}.
 * <p>
 * As this class extends {@link Observable} it can hold
 * a list of Observers{@link Observer}) that can be notified whenever
 * new content is published.
 * <p>
 * The notification process is done by the method {@link Observable#notifyObservers()}
 * which calls the method {@link Observer#update(Observable, Object)} method one by one
 * for each of its observers whenever any new change is available.
 * <p>
 * Before calling the observers one by one it check the value of {@link Observable#hasChanged()}.
 * If that's true then the observers are notified otherwise not.
 */
class ReadDigest extends Observable {
    /**
     * The title of the current edition
     */
    private String currentTitle;

    /**
     * Some information about the current edition
     */
    private String moreInfo;

    /**
     * This method generates the new content for the magazine
     * and calls {@link #notifyObservers()} ()} for broadcasting the info
     * after setting the changed status of the Observable by calling
     * {@link Observable#setChanged()}.
     */
    void generateContent() {
        DataFactory df = new DataFactory();
        this.currentTitle = df.getRandomText(10);
        this.moreInfo = df.getRandomText(100);
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Getter for {@link #currentTitle}
     *
     * @return currentTitle
     */
    String getCurrentTitle() {
        return currentTitle;
    }

    /**
     * Getter for {@link #moreInfo}
     *
     * @return moreInfo
     */
    String getMoreInfo() {
        return moreInfo;
    }
}


/**
 * RaceCarDriver likes to read our magazine, ReadDigest.
 * It now implements {@link Observer} and thus overrides
 * {@link Observer#update(Observable, Object)} through which
 * it becomes ready to receive the info from the {@link Observer}.
 */
class RaceCarDriver implements Observer {

    /**
     * This is called by the {@link #update(Observable, Object)} now.
     *
     * @param title       title
     * @param moreContent extra content
     */
    private void receiveNewContent(String title, String moreContent) {
        System.out.println("RaceCarDriver Receives...");
        System.out.println(title);
        System.out.println(moreContent);
    }

    /**
     * @param o   observable
     * @param arg extra arguments that the Observable wants to send.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ReadDigest) {
            ReadDigest readDigest = (ReadDigest) o;
            this.receiveNewContent(readDigest.getCurrentTitle(), readDigest.getMoreInfo());
        }
    }
}

/**
 * Like the {@link RaceCarDriver}, NewspaperMan likes to read our magazine, ReadDigest.
 */
class NewsPaperMan implements Observer {

    /**
     * Like {@link RaceCarDriver}, it'll now be called by {@link #update(Observable, Object)}.
     *
     * @param title       currentTitle
     * @param moreContent moreContent
     */
    private void receiveNewArticle(String title, String moreContent) {
        System.out.println("NewsPaperMan Receives...");
        System.out.println(title);
        System.out.println(moreContent);
    }

    /**
     * @param o   observable
     * @param arg extra arguments that the Observable wants to send.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ReadDigest) {
            ReadDigest readDigest = (ReadDigest) o;
            this.receiveNewArticle(readDigest.getCurrentTitle(), readDigest.getMoreInfo());
        }
    }
}

/**
 * Likewise the {@link RaceCarDriver} and {@link NewsPaperMan}
 */
class MovieDirector implements Observer {

    /**
     * Like {@link RaceCarDriver}, it'll now be called by {@link #update(Observable, Object)}.
     *
     * @param title       currentTitle
     * @param moreContent moreContent
     */
    private void receiveNewMediaStory(String title, String moreContent) {
        System.out.println("MovieDirector Receives...");
        System.out.println(title);
        System.out.println(moreContent);
    }

    /**
     * @param o   observable
     * @param arg extra arguments that the Observable wants to send.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ReadDigest) {
            ReadDigest readDigest = (ReadDigest) o;
            this.receiveNewMediaStory(readDigest.getCurrentTitle(), readDigest.getMoreInfo());
        }
    }
}
```
