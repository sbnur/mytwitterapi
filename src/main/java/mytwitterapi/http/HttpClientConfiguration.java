package mytwitterapi.http;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface HttpClientConfiguration {

    String getHttpProxyHost();

    int getHttpProxyPort();

    String getHttpProxyUser();

    String getHttpProxyPassword();

    int getHttpConnectionTimeout();

    int getHttpReadTimeout();

    int getHttpRetryCount();

    int getHttpRetryIntervalSeconds();

    boolean isPrettyDebugEnabled();

    boolean isGZIPEnabled();
}