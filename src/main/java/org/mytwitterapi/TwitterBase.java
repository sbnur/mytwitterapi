package org.mytwitterapi;

import org.mytwitterapi.auth.Authorization;
import org.mytwitterapi.conf.Configuration;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.2.0
 */
public interface TwitterBase {

    /**
     * Returns authenticating user's screen name.<br>
     * This method may internally call verifyCredentials() on the first invocation if<br>
     * - this instance is authenticated by Basic and email address is supplied instead of screen name, or
     * - this instance is authenticated by OAuth.<br>
     * Note that this method returns a transiently cached (will be lost upon serialization) screen name while it is possible to change a user's screen name.<br>
     *
     * @return the authenticating screen name
     * @throws TwitterException      when verifyCredentials threw an exception.
     * @throws IllegalStateException if no credentials are supplied. i.e.) this is an anonymous Twitter instance
     * @since Twitter4J 2.1.1
     */
    String getScreenName() throws TwitterException, IllegalStateException;

    /**
     * Returns authenticating user's user id.<br>
     * This method may internally call verifyCredentials() on the first invocation if<br>
     * - this instance is authenticated by Basic and email address is supplied instead of screen name, or
     * - this instance is authenticated by OAuth.<br>
     *
     * @return the authenticating user's id
     * @throws TwitterException      when verifyCredentials threw an exception.
     * @throws IllegalStateException if no credentials are supplied. i.e.) this is an anonymous Twitter instance
     * @since Twitter4J 2.1.1
     */
    long getId() throws TwitterException, IllegalStateException;

    /**
     * Registers a RateLimitStatusListener for account associated rate limits
     *
     * @param listener the listener to be added
     * @see <a href="https://dev.twitter.com/docs/rate-limiting">Rate Limiting | Twitter Developers</a>
     * @since Twitter4J 2.1.12
     */
    void addRateLimitStatusListener(RateLimitStatusListener listener);

    /**
     * Returns the authorization scheme for this instance.<br>
     * The returned type will be either of BasicAuthorization, OAuthAuthorization, or NullAuthorization
     *
     * @return the authorization scheme for this instance
     */
    Authorization getAuthorization();

    /**
     * Returns the configuration associated with this instance
     *
     * @return configuration associated with this instance
     * @since Twitter4J 2.1.8
     */
    Configuration getConfiguration();
}
