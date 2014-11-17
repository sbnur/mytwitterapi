package org.mytwitterapi.auth;

import java.io.ObjectStreamException;

import org.mytwitterapi.http.HttpRequest;

/**
 * An interface represents credentials.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public class NullAuthorization implements Authorization, java.io.Serializable {
    private static final long serialVersionUID = -7704668493278727510L;
    private static final NullAuthorization SINGLETON = new NullAuthorization();

    private NullAuthorization() {

    }

    public static NullAuthorization getInstance() {
        return SINGLETON;
    }

    public String getAuthorizationHeader(HttpRequest req) {
        return null;
    }

    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        return SINGLETON == o;
    }

    @Override
    public String toString() {
        return "NullAuthentication{SINGLETON}";
    }

    private Object readResolve() throws ObjectStreamException {
        return SINGLETON;
    }

}
