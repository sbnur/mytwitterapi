package org.mytwitterapi;

import org.mytwitterapi.http.HttpResponse;

/*package*/ abstract class TwitterResponseImpl implements TwitterResponse, java.io.Serializable {

    private static final long serialVersionUID = 7422171124869859808L;
    private transient RateLimitStatus rateLimitStatus = null;
    private final transient int accessLevel;

    public TwitterResponseImpl() {
        accessLevel = NONE;
    }

    public TwitterResponseImpl(HttpResponse res) {
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(res);
        accessLevel = ParseUtil.toAccessLevel(res);
    }

    @Override
    public RateLimitStatus getRateLimitStatus() {
        return rateLimitStatus;
    }

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }
}
