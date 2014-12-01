package mytwitterapi;

/**
 * A data interface representing array of numeric IDs.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface IDs extends TwitterResponse, CursorSupport, java.io.Serializable {
    long[] getIDs();

    boolean hasPrevious();

    long getPreviousCursor();

    boolean hasNext();

    long getNextCursor();
}
