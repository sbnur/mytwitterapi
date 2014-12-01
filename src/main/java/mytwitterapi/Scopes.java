package mytwitterapi;

import java.io.Serializable;

/**
 * A data interface representing targeting scopes applied to a status.
 *
 * @author Aaron Rankin - aaron at sproutsocial.com
 * @since Twitter4J 3.0.6
 */
public interface Scopes extends Serializable {

	/**
     * Returns the place_ids that identify the scope of the status.
     *
     * @return the place_ids that identify the scope of the status.
     */
	String[] getPlaceIds();
}