package mytwitterapi;

import mytwitterapi.conf.Configuration;
import mytwitterapi.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.9
 */
class AccountSettingsJSONImpl extends TwitterResponseImpl implements AccountSettings, java.io.Serializable {
    private static final long serialVersionUID = 603189815663175766L;
    private final boolean SLEEP_TIME_ENABLED;
    private final String SLEEP_START_TIME;
    private final String SLEEP_END_TIME;
    private final Location[] TREND_LOCATION;
    private final boolean GEO_ENABLED;
    private final String LANGUAGE;
    private final TimeZone TIMEZONE;
    private final boolean ALWAYS_USE_HTTPS;
    private final boolean DISCOVERABLE_BY_EMAIL;
    private final String SCREEN_NAME;

    private AccountSettingsJSONImpl(HttpResponse res, JSONObject json) throws TwitterException {
        super(res);
        try {
            JSONObject sleepTime = json.getJSONObject("sleep_time");
            SLEEP_TIME_ENABLED = ParseUtil.getBoolean("enabled", sleepTime);
            SLEEP_START_TIME = sleepTime.getString("start_time");
            SLEEP_END_TIME = sleepTime.getString("end_time");
            if (json.isNull("trend_location")) {
                TREND_LOCATION = new Location[0];
            } else {
                JSONArray locations = json.getJSONArray("trend_location");
                TREND_LOCATION = new Location[locations.length()];
                for (int i = 0; i < locations.length(); i++) {
                    TREND_LOCATION[i] = new LocationJSONImpl(locations.getJSONObject(i));
                }
            }
            GEO_ENABLED = ParseUtil.getBoolean("geo_enabled", json);
            LANGUAGE = json.getString("language");
            ALWAYS_USE_HTTPS = ParseUtil.getBoolean("always_use_https", json);
            DISCOVERABLE_BY_EMAIL = ParseUtil.getBoolean("discoverable_by_email", json);
            // https://groups.google.com/forum/?fromgroups=#!topic/twitter4j/zPaAXP9gkU4
            if (json.isNull("time_zone")) {
                TIMEZONE = null;
            } else {
                TIMEZONE = new TimeZoneJSONImpl(json.getJSONObject("time_zone"));
            }
            SCREEN_NAME = json.getString("screen_name");
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    /*package*/ AccountSettingsJSONImpl(HttpResponse res, Configuration conf) throws TwitterException {
        this(res, res.asJSONObject());
        if (conf.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, res.asJSONObject());
        }
    }

    /*package*/ AccountSettingsJSONImpl(JSONObject json) throws TwitterException {
        this(null, json);
    }
    
    /*
    @Override
    public boolean isSleepTimeEnabled() {
        return SLEEP_TIME_ENABLED;
    }
    */
    
    /*
    @Override
    public String getSleepStartTime() {
        return SLEEP_START_TIME;
    }
    */
    
    /*
    @Override
    public String getSleepEndTime() {
        return SLEEP_END_TIME;
    }
    */

    /*
    @Override
    public Location[] getTrendLocations() {
        return TREND_LOCATION;
    }
    */

    /*
    @Override
    public boolean isGeoEnabled() {
        return GEO_ENABLED;
    }
    */

    /*
    @Override
    public boolean isDiscoverableByEmail() {
        return DISCOVERABLE_BY_EMAIL;
    }
    */

    /*
    @Override
    public boolean isAlwaysUseHttps() {
        return ALWAYS_USE_HTTPS;
    }
    */

    @Override
    public String getScreenName() {
        return SCREEN_NAME;
    }

    /*
    @Override
    public String getLanguage() {
        return LANGUAGE;
    }
    */

    /*
    @Override
    public TimeZone getTimeZone() {
        return TIMEZONE;
    }
    */
}