package mytwitterapi;

/**
 * A data interface representing one single Hashtag entity.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.9
 */
public interface HashtagEntity extends TweetEntity, java.io.Serializable {
    /**
     * Returns the text of the hashtag without #.
     *
     * @return the text of the hashtag
     */
    String getText();

    /**
     * Returns the index of the start character of the hashtag.
     *
     * @return the index of the start character of the hashtag
     */
    int getStart();

    /**
     * Returns the index of the end character of the hashtag.
     *
     * @return the index of the end character of the hashtag
     */
    int getEnd();
}