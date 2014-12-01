package mytwitterapi;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class Version {
    private static final String VERSION = "4.0.2";
    private static final String TITLE = "Twitter4J";

    private Version() {
        throw new AssertionError();
    }

    public static String getVersion() {
        return VERSION;
    }

    /**
     * prints the version string
     *
     * @param args will be just ignored.
     */
    public static void main(String[] args) {
        System.out.println(TITLE + " " + VERSION);
    }
}
