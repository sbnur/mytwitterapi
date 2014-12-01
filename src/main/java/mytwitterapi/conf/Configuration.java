package mytwitterapi.conf;

import java.util.Properties;

import mytwitterapi.http.HttpClientConfiguration;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface Configuration extends AuthorizationConfiguration, java.io.Serializable {

    boolean isDebugEnabled();

    boolean isApplicationOnlyAuthEnabled();

    String getUser();

    String getPassword();

    // methods for HttpClientConfiguration
    HttpClientConfiguration getHttpClientConfiguration();

    int getHttpStreamingReadTimeout();

    // oauth related setter/getters

    String getOAuthConsumerKey();

    String getOAuthConsumerSecret();

    String getOAuthAccessToken();

    String getOAuthAccessTokenSecret();

    String getOAuth2TokenType();

    String getOAuth2AccessToken();

    String getOAuth2Scope();

    String getRestBaseURL();

    String getUploadBaseURL();

    String getStreamBaseURL();

    String getOAuthRequestTokenURL();

    String getOAuthAuthorizationURL();

    String getOAuthAccessTokenURL();

    String getOAuthAuthenticationURL();

    String getOAuth2TokenURL();

    String getOAuth2InvalidateTokenURL();

    String getUserStreamBaseURL();

    String getSiteStreamBaseURL();

    boolean isIncludeMyRetweetEnabled();

    boolean isJSONStoreEnabled();

    boolean isMBeanEnabled();

    boolean isUserStreamRepliesAllEnabled();

    boolean isUserStreamWithFollowingsEnabled();

    boolean isStallWarningsEnabled();

    String getMediaProvider();

    String getMediaProviderAPIKey();

    Properties getMediaProviderParameters();

    int getAsyncNumThreads();

    long getContributingTo();

    String getDispatcherImpl();

    String getLoggerFactory();

    boolean isIncludeEntitiesEnabled();

    boolean isTrimUserEnabled();

    boolean isDaemonEnabled();
}
