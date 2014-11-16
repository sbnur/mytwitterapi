package org.mytwitterapi;

/**
 * A data interface representing one single URL entity.
 *
 * @author Mocel - mocel at guma.jp
 * @since Twitter4J 2.1.9
 */
public interface URLEntity extends TweetEntity, java.io.Serializable {

    /**
     * Returns the URL mentioned in the tweet.<br>
     * This method implementation is to meet TweetEntity interface and the behavior is equivalent to {@link #getURL()}
     *
     * @return the mentioned URL
     */
    @Override
    String getText();

    /**
     * Returns the URL mentioned in the tweet.
     *
     * @return the mentioned URL
     */
    String getURL();

    /**
     * Returns the expanded URL if mentioned URL is shorten.
     *
     * @return the expanded URL if mentioned URL is shorten, or null if no shorten URL was mentioned.
     */
    String getExpandedURL();

    /**
     * Returns the display URL if mentioned URL is shorten.
     *
     * @return the display URL if mentioned URL is shorten, or null if no shorten URL was mentioned.
     */
    String getDisplayURL();

    /**
     * Returns the index of the start character of the URL mentioned in the tweet.
     *
     * @return the index of the start character of the URL mentioned in the tweet
     */
    int getStart();

    /**
     * Returns the index of the end character of the URL mentioned in the tweet.
     *
     * @return the index of the end character of the URL mentioned in the tweet
     */
    int getEnd();
}