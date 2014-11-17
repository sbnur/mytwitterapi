package org.mytwitterapi.auth;

import org.mytwitterapi.BASE64Encoder;
import org.mytwitterapi.http.HttpRequest;

/**
 * An authentication implementation implements Basic authentication
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class BasicAuthorization implements Authorization, java.io.Serializable {

    private static final long serialVersionUID = 7420629998989177351L;
    private final String userId;

    private final String password;
    private final String basic;

    public BasicAuthorization(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.basic = encodeBasicAuthenticationString();
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    private String encodeBasicAuthenticationString() {
        if (userId != null && password != null) {
            return "Basic " + BASE64Encoder.encode((userId + ":" + password).getBytes());
        }
        return null;
    }

    public String getAuthorizationHeader(HttpRequest req) {
        return basic;
    }

    /**
     * #{inheritDoc}
     */
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicAuthorization)) return false;

        BasicAuthorization that = (BasicAuthorization) o;

        return basic.equals(that.basic);

    }

    @Override
    public int hashCode() {
        return basic.hashCode();
    }

    @Override
    public String toString() {
        return "BasicAuthorization{" +
                "userId='" + userId + '\'' +
                ", password='**********'\'" +
                '}';
    }

}
