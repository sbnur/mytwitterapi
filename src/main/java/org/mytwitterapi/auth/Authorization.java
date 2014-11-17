package org.mytwitterapi.auth;

import org.mytwitterapi.http.HttpRequest;

/**
 * An interface represents credentials.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface Authorization extends java.io.Serializable {
    String getAuthorizationHeader(HttpRequest req);

    /**
     * Returns true if authorization credentials are set.
     *
     * @return true if authorization credentials are set
     */
    boolean isEnabled();
}
