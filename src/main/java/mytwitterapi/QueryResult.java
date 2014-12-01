package mytwitterapi;

import java.util.List;

/**
 * A data interface representing search API response
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface QueryResult extends TwitterResponse, java.io.Serializable {
    long getSinceId();

    long getMaxId();

    String getRefreshURL();

    int getCount();

    double getCompletedIn();

    String getQuery();

    List<Status> getTweets();

    /**
     * Returns a Query instance to fetch next page or null if there is no next page.
     *
     * @return Query instance to fetch next page
     * @since Twitter4J 3.0.0
     */
    Query nextQuery();

    /**
     * test if there is next page
     *
     * @return if there is next page
     * @since Twitter4J 3.0.0
     */
    boolean hasNext();
}
