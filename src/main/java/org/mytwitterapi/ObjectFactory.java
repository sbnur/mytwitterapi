package org.mytwitterapi;

import java.util.Map;

import org.json.JSONObject;
import org.mytwitterapi.http.HttpResponse;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.2.4
 */
interface ObjectFactory extends java.io.Serializable {
    Status createStatus(JSONObject json) throws TwitterException;

    User createUser(JSONObject json) throws TwitterException;

    //UserList createAUserList(JSONObject json) throws TwitterException;

    Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse res) throws TwitterException;

    Status createStatus(HttpResponse res) throws TwitterException;

    ResponseList<Status> createStatusList(HttpResponse res) throws TwitterException;

    //Trends createTrends(HttpResponse res) throws TwitterException;

    User createUser(HttpResponse res) throws TwitterException;

    ResponseList<User> createUserList(HttpResponse res) throws TwitterException;

    //ResponseList<User> createUserListFromJSONArray(HttpResponse res) throws TwitterException;

    //ResponseList<User> createUserListFromJSONArray_Users(HttpResponse res) throws TwitterException;

    QueryResult createQueryResult(HttpResponse res, Query query) throws TwitterException;

    IDs createIDs(HttpResponse res) throws TwitterException;

    PagableResponseList<User> createPagableUserList(HttpResponse res) throws TwitterException;

    UserList createAUserList(HttpResponse res) throws TwitterException;

    PagableResponseList<UserList> createPagableUserListList(HttpResponse res) throws TwitterException;

    //ResponseList<UserList> createUserListList(HttpResponse res) throws TwitterException;

    //ResponseList<Category> createCategoryList(HttpResponse res) throws TwitterException;

    //DirectMessage createDirectMessage(HttpResponse res) throws TwitterException;

    //ResponseList<DirectMessage> createDirectMessageList(HttpResponse res) throws TwitterException;

    //Relationship createRelationship(HttpResponse res) throws TwitterException;

    //ResponseList<Friendship> createFriendshipList(HttpResponse res) throws TwitterException;

    AccountTotals createAccountTotals(HttpResponse res) throws TwitterException;

    AccountSettings createAccountSettings(HttpResponse res) throws TwitterException;

    //SavedSearch createSavedSearch(HttpResponse res) throws TwitterException;

    //ResponseList<SavedSearch> createSavedSearchList(HttpResponse res) throws TwitterException;

    //ResponseList<Location> createLocationList(HttpResponse res) throws TwitterException;

    //Place createPlace(HttpResponse res) throws TwitterException;

    //ResponseList<Place> createPlaceList(HttpResponse res) throws TwitterException;

    TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse res) throws TwitterException;

    //ResponseList<HelpResources.Language> createLanguageList(HttpResponse res) throws TwitterException;

    //<T> ResponseList<T> createEmptyResponseList();

    //OEmbed createOEmbed(HttpResponse res) throws TwitterException;
}