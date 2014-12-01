package mytwitterapi;

/**
 * A data interface representing Twitter REST API's rate limit status
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @see <a href="https://dev.twitter.com/docs/rate-limiting">Rate Limiting | Twitter Developers</a>
 */
public final class RateLimitStatusEvent extends java.util.EventObject {

    private static final long serialVersionUID = 3749366911109722414L;
    private final RateLimitStatus rateLimitStatus;

    private final boolean isAccountRateLimitStatus;

    RateLimitStatusEvent(Object source, RateLimitStatus rateLimitStatus, boolean isAccountRateLimitStatus) {
        super(source);
        this.rateLimitStatus = rateLimitStatus;
        this.isAccountRateLimitStatus = isAccountRateLimitStatus;
    }

    public RateLimitStatus getRateLimitStatus() {
        return rateLimitStatus;
    }

    public boolean isAccountRateLimitStatus() {
        return isAccountRateLimitStatus;
    }

    public boolean isIPRateLimitStatus() {
        return !isAccountRateLimitStatus;
    }

}