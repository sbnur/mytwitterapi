package mytwitterapi.conf;

/**
 * Static factory of Configuration. This class wraps ConfigurationFactory implementations.<br>
 * By default, twitter4j.conf.PropertyConfigurationFactory will be used and can be changed with -Dtwitter4j.configurationFactory system property.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class ConfigurationContext {
    private static final String DEFAULT_CONFIGURATION_FACTORY = "mytwitterapi.conf.PropertyConfigurationFactory";
    private static final String CONFIGURATION_IMPL = "mytwitterapi.configurationFactory";
    private static final ConfigurationFactory factory;

    static {
        String CONFIG_IMPL;
        try {
            CONFIG_IMPL = System.getProperty(CONFIGURATION_IMPL, DEFAULT_CONFIGURATION_FACTORY);
        } catch (SecurityException ignore) {
            // Unsigned applets are not allowed to access System properties
            CONFIG_IMPL = DEFAULT_CONFIGURATION_FACTORY;
        }

        try {
            factory = (ConfigurationFactory) Class.forName(CONFIG_IMPL).newInstance();
        } catch (ClassNotFoundException cnfe) {
            throw new AssertionError(cnfe);
        } catch (InstantiationException ie) {
            throw new AssertionError(ie);
        } catch (IllegalAccessException iae) {
            throw new AssertionError(iae);
        }
    }


    public static Configuration getInstance() {
        return factory.getInstance();
    }

    public static Configuration getInstance(String configTreePath) {
        return factory.getInstance(configTreePath);
    }
}