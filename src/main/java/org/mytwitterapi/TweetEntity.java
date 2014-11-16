package org.mytwitterapi;

/**
 * super interface of UserMentionEntity, URLEntity and HashtagEntity
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 3.0.4
 */
public interface TweetEntity {
    /**
     * Returns the text of the entity
     *
     * @return the text of the entity
     */
    String getText();

    /**
     * Returns the index of the start character of the entity in the tweet.
     *
     * @return the index of the start character of the entity in the tweet
     */
    int getStart();

    /**
     * Returns the index of the end character of the entity in the tweet.
     *
     * @return the index of the end character of the entity in the tweet
     */
    int getEnd();
}

