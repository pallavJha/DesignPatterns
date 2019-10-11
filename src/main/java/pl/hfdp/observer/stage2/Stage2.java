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


/**
 * Runs the stage2 of this package
 */
public class Stage2 {

    public static void main(String[] args) {
        RaceCarDriver raceCarDriver = new RaceCarDriver();
        NewsPaperMan newsPaperMan = new NewsPaperMan();
        MovieDirector movieDirector = new MovieDirector();

        // creating the observable
        ReadDigest readDigest = new ReadDigest();

        // adding as an observer
        readDigest.addObserver(raceCarDriver);
        readDigest.addObserver(newsPaperMan);
        readDigest.addObserver(movieDirector);

        IntStream.range(0, 10).forEach(i -> readDigest.generateContent());
    }
}
