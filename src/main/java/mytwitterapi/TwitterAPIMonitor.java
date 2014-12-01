package mytwitterapi;

import java.lang.management.ManagementFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import mytwitterapi.management.APIStatistics;
import mytwitterapi.management.APIStatisticsMBean;
import mytwitterapi.management.APIStatisticsOpenMBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton instance of all Twitter API monitoring. Handles URL parsing and "wire off" logic.
 * We could avoid using a singleton here if Twitter objects were instantiated
 * from a factory.
 *
 * @author Nick Dellamaggiore (nick.dellamaggiore <at> gmail.com)
 * @since Twitter4J 2.2.1
 */
public class TwitterAPIMonitor {
    private static final Logger logger = LoggerFactory.getLogger(TwitterAPIMonitor.class);
    // https?:\/\/[^\/]+\/[0-9.]*\/([a-zA-Z_\.]*).*
    // finds the "method" part a Twitter REST API url, ignoring member-specific resource names
    private static final Pattern pattern =
            Pattern.compile("https?://[^/]+/[0-9.]*/([a-zA-Z_\\.]*).*");

    private static final TwitterAPIMonitor SINGLETON = new TwitterAPIMonitor();

    private static final APIStatistics STATISTICS = new APIStatistics(100);


    static {
        try {

            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName oName = new ObjectName("twitter4j.mbean:type=APIStatisticsOpenMBean");
            APIStatisticsOpenMBean openMBean = new APIStatisticsOpenMBean(STATISTICS);
            mbs.registerMBean(openMBean, oName);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     * Constructor
     */
    private TwitterAPIMonitor() {
    }

    public static TwitterAPIMonitor getInstance() {
        return SINGLETON;
    }

    public APIStatisticsMBean getStatistics() {
        return STATISTICS;
    }

    void methodCalled(String twitterUrl, long elapsedTime, boolean success) {
        Matcher matcher = pattern.matcher(twitterUrl);
        if (matcher.matches() && matcher.groupCount() > 0) {
            String method = matcher.group(1);
            STATISTICS.methodCalled(method, elapsedTime, success);
        }
    }
}
