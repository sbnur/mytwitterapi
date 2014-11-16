package org.mytwitterapi;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface Location extends java.io.Serializable {
    int getWoeid();

    String getCountryName();

    String getCountryCode();

    String getPlaceName();

    int getPlaceCode();

    String getName();

    String getURL();
}
