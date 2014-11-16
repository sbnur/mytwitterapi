package org.mytwitterapi;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents result of "/1.1/media/upload.json"
 * 
 * @author Hiroaki TAKEUCHI - takke30 at gmail.com
 * @since Twitter4J 4.0.2
 */
public final class UploadedMedia implements java.io.Serializable {

    private static final long serialVersionUID = 5393092535610604718L;
    
    private int imageWidth;
    private int imageHeight;
    private String imageType;
    private long mediaId;
    private long size;

    /*package*/ UploadedMedia(JSONObject json) throws TwitterException {
        init(json);
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public String getImageType() {
        return imageType;
    }

    public long getMediaId() {
        return mediaId;
    }

    public long getSize() {
        return size;
    }

    private void init(JSONObject json) throws TwitterException {
        mediaId = ParseUtil.getLong("media_id", json);
        size = ParseUtil.getLong("size", json);
        try {
            if (!json.isNull("image")) {
                JSONObject image = json.getJSONObject("image");
                imageWidth = ParseUtil.getInt("w", image);
                imageHeight = ParseUtil.getInt("h", image);
                imageType = ParseUtil.getUnescapedString("image_type", image);
            }
        } catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UploadedMedia that = (UploadedMedia) o;

        if (imageWidth != that.imageWidth) return false;
        if (imageHeight != that.imageHeight) return false;
        if (imageType != that.imageType) return false;
        if (mediaId != that.mediaId) return false;
        if (size != that.size) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (mediaId ^ (mediaId >>> 32));
        result = 31 * result + imageWidth;
        result = 31 * result + imageHeight;
        result = 31 * result + (imageType != null ? imageType.hashCode() : 0);
        result = 31 * result + (int)(size ^ (size >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "UploadedMedia{" +
                "mediaId=" + mediaId +
                ", imageWidth=" + imageWidth + 
                ", imageHeight=" + imageHeight +
                ", imageType='" + imageType + '\'' +
                ", size=" + size +
                '}';
    }
}
