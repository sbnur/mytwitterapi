package org.mytwitterapi.conf;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public interface ConfigurationFactory {
    /**
     * returns the root configuration
     *
     * @return root configuration
     */
    Configuration getInstance();

    /**
     * returns the configuration specified by the path
     *
     * @param configTreePath the path
     * @return the configuratoin
     */
    Configuration getInstance(String configTreePath);

    /**
     * clean up resources acquired by this factory.
     */
    void dispose();
}