package hr.dsokac.androidcommons.security.repositories

import io.reactivex.Completable

/**
 * Interface defining functionalities which subclasses need to implement in order to handle
 * oAuth2 authorization and other authorization information
 *
 * @author Danijel Sokač
 */
interface IRxOAuth2Repository {
    /**
     * Retrieve active access token assigned for active session
     *
     * @return access token which authorizes user
     */
    fun getAccessToken(): String?

    /**
     * Retrieve active refresh token assign for active session
     *
     * @return refresh token which is used to obtain new access token
     */
    fun getRefreshToken(): String?

    /**
     * Retrieve token type (e.g. Bearer) used for user authorization
     */
    fun getTokenType(): String?

    /**
     * Save tokens assign to newly created session
     *
     * @param accessToken access token assigned for this session
     * @param refreshToken refresh token assigned for this session
     * @param tokenType token type used for authorization
     */
    fun save(accessToken: String, refreshToken: String, tokenType: String)

    /**
     * Saves username of authorized user
     *
     * @param username authorized user username
     */
    fun saveUsername(username: String)

    /**
     * Clears all session data (such as access token, username, etc.) when user has been logged out
     */
    fun clearSession()

    /**
     * Retrieve username of authorized user
     *
     * @return username of current user
     */
    fun getUsername(): String?

    /**
     * Authorize user according to provided credentials
     *
     * @param username username of user trying to login
     * @param password password of user trying to login
     *
     * @return [Completable] which will indicate if login was successful or not
     */
    fun login(username: String, password: String): Completable

    /**
     * Refresh access token according to oAuth2 standard
     *
     * @return [Completable] which will indicate if refresh was successful or not
     */
    fun refreshToken(): Completable

    /**
     * Notify server that user wants to logout from system
     *
     * @return [Completable] which will indicate if logout was successful or not
     */
    fun logout(): Completable
}