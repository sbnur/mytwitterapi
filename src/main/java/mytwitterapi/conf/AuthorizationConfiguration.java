package mytwitterapi.conf;

/**
 * A static factory class for Authorization.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.1
 */
public interface AuthorizationConfiguration {

    String getUser();

    String getPassword();

    String getOAuthConsumerKey();

    String getOAuthConsumerSecret();

    String getOAuthAccessToken();

    String getOAuthAccessTokenSecret();

    String getOAuth2TokenType();

    String getOAuth2AccessToken();
}
