package org.mytwitterapi;

import java.io.Serializable;

/**
 * A data interface representing one single user mention entity.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.9
 */
public interface UserMentionEntity extends TweetEntity, Serializable {
    /**
     * Returns the screen name mentioned in the status. This method implementation is to meet TweetEntity interface and the behavior is equivalent to {@link #getScreenName()}
     *
     * @return the screen name mentioned in the status
     */
    @Override
    String getText();

    /**
     * Returns the name mentioned in the status.
     *
     * @return the name mentioned in the status
     */
    String getName();

    /**
     * Returns the screen name mentioned in the status.
     *
     * @return the screen name mentioned in the status
     */
    String getScreenName();

    /**
     * Returns the user id mentioned in the status.
     *
     * @return the user id mentioned in the status
     */
    long getId();

    /**
     * Returns the index of the start character of the user mention.
     *
     * @return the index of the start character of the user mention
     */
    int getStart();

    /**
     * Returns the index of the end character of the user mention.
     *
     * @return the index of the end character of the user mention
     */
    int getEnd();
}
