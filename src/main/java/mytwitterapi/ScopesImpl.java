package mytwitterapi;

/**
 * A data interface representing targeting scopes applied to a status.
 *
 * @author Aaron Rankin - aaron at sproutsocial.com
 * @since Twitter4J 3.0.6
 */
public class ScopesImpl implements Scopes {

    private final String[] placeIds;
    
    /* Only for serialization purposes. */
    /*package*/ ScopesImpl() {
        this.placeIds = new String[0];
    }

    public ScopesImpl(final String[] placeIds) {
        this.placeIds = placeIds;
    }

    @Override
    public String[] getPlaceIds() {
        return placeIds;
    }

}