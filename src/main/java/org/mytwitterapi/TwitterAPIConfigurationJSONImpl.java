package org.mytwitterapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mytwitterapi.conf.Configuration;
import org.mytwitterapi.http.HttpResponse;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.2.3
 */
class TwitterAPIConfigurationJSONImpl extends TwitterResponseImpl implements TwitterAPIConfiguration {
    private static final long serialVersionUID = -3588904550808591686L;
    private int photoSizeLimit;
    private int shortURLLength;
    private int shortURLLengthHttps;

    private int charactersReservedPerMedia;
    private Map<Integer, MediaEntity.Size> photoSizes;
    private String[] nonUsernamePaths;
    private int maxMediaPerUpload;

    TwitterAPIConfigurationJSONImpl(HttpResponse res, Configuration conf)
            throws TwitterException {
        super(res);
        try {
            JSONObject json = res.asJSONObject();
            photoSizeLimit = ParseUtil.getInt("photo_size_limit", json);
            shortURLLength = ParseUtil.getInt("short_url_length", json);
            shortURLLengthHttps = ParseUtil.getInt("short_url_length_https", json);
            charactersReservedPerMedia = ParseUtil.getInt("characters_reserved_per_media", json);

            JSONObject sizes = json.getJSONObject("photo_sizes");
            photoSizes = new HashMap<Integer, MediaEntity.Size>(4);
            photoSizes.put(MediaEntity.Size.LARGE, new MediaEntityJSONImpl.Size(sizes.getJSONObject("large")));
            JSONObject medium;
            // http://code.google.com/p/twitter-api/issues/detail?id=2230
            if (sizes.isNull("med")) {
                medium = sizes.getJSONObject("medium");
            } else {
                medium = sizes.getJSONObject("med");
            }
            photoSizes.put(MediaEntity.Size.MEDIUM, new MediaEntityJSONImpl.Size(medium));
            photoSizes.put(MediaEntity.Size.SMALL, new MediaEntityJSONImpl.Size(sizes.getJSONObject("small")));
            photoSizes.put(MediaEntity.Size.THUMB, new MediaEntityJSONImpl.Size(sizes.getJSONObject("thumb")));
            if (conf.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
                TwitterObjectFactory.registerJSONObject(this, res.asJSONObject());
            }
            JSONArray nonUsernamePathsJSONArray = json.getJSONArray("non_username_paths");
            nonUsernamePaths = new String[nonUsernamePathsJSONArray.length()];
            for (int i = 0; i < nonUsernamePathsJSONArray.length(); i++) {
                nonUsernamePaths[i] = nonUsernamePathsJSONArray.getString(i);
            }
            maxMediaPerUpload = ParseUtil.getInt("max_media_per_upload", json);
        } catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }

    @Override
    public int getPhotoSizeLimit() {
        return photoSizeLimit;
    }

    @Override
    public int getShortURLLength() {
        return shortURLLength;
    }

    @Override
    public int getShortURLLengthHttps() {
        return shortURLLengthHttps;
    }

    @Override
    public int getCharactersReservedPerMedia() {
        return charactersReservedPerMedia;
    }

    @Override
    public Map<Integer, MediaEntity.Size> getPhotoSizes() {
        return photoSizes;
    }

    @Override
    public String[] getNonUsernamePaths() {
        return nonUsernamePaths;
    }

    @Override
    public int getMaxMediaPerUpload() {
        return maxMediaPerUpload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TwitterAPIConfigurationJSONImpl)) return false;

        TwitterAPIConfigurationJSONImpl that = (TwitterAPIConfigurationJSONImpl) o;

        if (charactersReservedPerMedia != that.charactersReservedPerMedia)
            return false;
        if (maxMediaPerUpload != that.maxMediaPerUpload) return false;
        if (photoSizeLimit != that.photoSizeLimit) return false;
        if (shortURLLength != that.shortURLLength) return false;
        if (shortURLLengthHttps != that.shortURLLengthHttps) return false;
        if (!Arrays.equals(nonUsernamePaths, that.nonUsernamePaths))
            return false;
        if (photoSizes != null ? !photoSizes.equals(that.photoSizes) : that.photoSizes != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = photoSizeLimit;
        result = 31 * result + shortURLLength;
        result = 31 * result + shortURLLengthHttps;
        result = 31 * result + charactersReservedPerMedia;
        result = 31 * result + (photoSizes != null ? photoSizes.hashCode() : 0);
        result = 31 * result + (nonUsernamePaths != null ? Arrays.hashCode(nonUsernamePaths) : 0);
        result = 31 * result + maxMediaPerUpload;
        return result;
    }

    @Override
    public String toString() {
        return "TwitterAPIConfigurationJSONImpl{" +
                "photoSizeLimit=" + photoSizeLimit +
                ", shortURLLength=" + shortURLLength +
                ", shortURLLengthHttps=" + shortURLLengthHttps +
                ", charactersReservedPerMedia=" + charactersReservedPerMedia +
                ", photoSizes=" + photoSizes +
                ", nonUsernamePaths=" + (nonUsernamePaths == null ? null : Arrays.asList(nonUsernamePaths)) +
                ", maxMediaPerUpload=" + maxMediaPerUpload +
                '}';
    }
}