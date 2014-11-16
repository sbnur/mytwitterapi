package org.mytwitterapi;

/**
 * ResponseList with cursor support.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface PagableResponseList<T extends TwitterResponse> extends ResponseList<T>, CursorSupport {
    boolean hasPrevious();

    long getPreviousCursor();

    boolean hasNext();

    long getNextCursor();

}