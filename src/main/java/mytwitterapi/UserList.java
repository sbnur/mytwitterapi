package mytwitterapi;

import java.net.URI;
import java.util.Date;

/**
 * A data interface representing Basic list information element
 *
 * @author Dan Checkoway - dcheckoway at gmail.com
 */
public interface UserList extends Comparable<UserList>, TwitterResponse, java.io.Serializable {
    /**
     * Returns the id of the list
     *
     * @return the id of the list
     */
    long getId();

    /**
     * Returns the name of the list
     *
     * @return the name of the list
     */
    String getName();

    /**
     * Returns the full name of the list
     *
     * @return the full name of the list
     */
    String getFullName();

    /**
     * Returns the slug of the list
     *
     * @return the slug of the list
     */
    String getSlug();

    /**
     * Returns the description of the list
     *
     * @return the description of the list
     */
    String getDescription();

    /**
     * Returns the subscriber count of the list
     *
     * @return the subscriber count of the list
     */
    int getSubscriberCount();

    /**
     * Returns the member count of the list
     *
     * @return the member count of the list
     */
    int getMemberCount();

    /**
     * Returns the uri of the list
     *
     * @return the uri of the list
     */
    URI getURI();

    /**
     * tests if the list is public
     *
     * @return if the list is public
     */
    boolean isPublic();

    /**
     * Returns the user of the list
     *
     * @return the user of the list
     */
    User getUser();

    /**
     * Returns if the authenticated user is following the list
     *
     * @return if the authenticated user is following the list
     */
    boolean isFollowing();

    /**
     * @return the date created the list
     * @since Twitter4J 4.0.1
     */
    Date getCreatedAt();
}
