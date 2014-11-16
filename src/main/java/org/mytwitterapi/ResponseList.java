package org.mytwitterapi;

import java.util.List;

/**
 * List of TwitterResponse.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface ResponseList<T> extends TwitterResponse, List<T> {

    public RateLimitStatus getRateLimitStatus();
}
