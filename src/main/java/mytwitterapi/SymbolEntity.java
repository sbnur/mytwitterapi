package mytwitterapi;

import java.io.Serializable;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 3.0.4
 */
public interface SymbolEntity extends TweetEntity, Serializable {
    /**
     * Returns the index of the start character of the symbol.
     *
     * @return the index of the start character of the symbol
     */
    int getStart();

    /**
     * Returns the index of the end character of the symbol.
     *
     * @return the index of the end character of the symbol
     */
    int getEnd();
}
