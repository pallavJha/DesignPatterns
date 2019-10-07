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
     * <br/>
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
