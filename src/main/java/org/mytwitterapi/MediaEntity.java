package org.mytwitterapi;

import java.util.Map;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.2.3
 */
public interface MediaEntity extends URLEntity {
    /**
     * Returns the id of the media.
     *
     * @return the id of the media
     */
    long getId();

    /**
     * Returns the media URL.
     *
     * @return the media URL
     */
    String getMediaURL();

    /**
     * Returns the media secure URL.
     *
     * @return the media secure URL
     */
    String getMediaURLHttps();

    /**
     * Returns size variations of the media.
     *
     * @return size variations of the media
     */
    Map<Integer, Size> getSizes();

    interface Size extends java.io.Serializable {
        Integer THUMB = 0;
        Integer SMALL = 1;
        Integer MEDIUM = 2;
        Integer LARGE = 3;
        int FIT = 100;
        int CROP = 101;

        int getWidth();

        int getHeight();

        int getResize();
    }

    /**
     * Returns the media type ("photo").
     *
     * @return the media type ("photo").
     */
    String getType();

}
