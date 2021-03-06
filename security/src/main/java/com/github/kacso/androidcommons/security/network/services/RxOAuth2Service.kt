package com.github.kacso.androidcommons.security.network.services

import com.github.kacso.androidcommons.network.exceptions.NetworkException
import com.github.kacso.androidcommons.security.AUTHORIZATION_HEADER
import com.github.kacso.androidcommons.security.network.models.OAuth2LoginResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Network service which handles user authorization requests
 *
 * @author Danijel Sokač
 */
interface RxOAuth2Service {
    /**
     * Perform user login request. If successful, [OAuth2LoginResponse] will be returned through
     * [Single]. In case of an error appropriate [NetworkException] will be thrown.
     *
     * @param username username of user trying to login
     * @param password password of user trying to login
     * @param grantType for this type of login, default is password
     * @param authorizationKey key issued by server which authorizes access for this app
     *
     * @return emits [OAuth2LoginResponse] or [NetworkException] in case of an error through [Single]
     */
    @FormUrlEncoded
    @POST("oauth/token")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("grant_type") grantType: String = "password",
        @Header(AUTHORIZATION_HEADER) authorizationKey: String
    ): Single<OAuth2LoginResponse>

    /**
     * Performs access token refresh. If successful, it will return new tokens, otherwise
     * [NetworkException] will be thrown.
     *
     * @param refreshToken refresh token return by server during access token retrieval
     * @param grantType for this type of request, default is refresh_token
     * @param authorizationKey key issued by server which authorizes access for this app
     *
     * @return emits [OAuth2LoginResponse] or [NetworkException] in case of an error through [Single]
     */
    @FormUrlEncoded
    @POST("oauth/token")
    fun refreshToken(
        @Field("refresh_token") refreshToken: String,
        @Field("grant_type") grantType: String = "refresh_token",
        @Header(AUTHORIZATION_HEADER) authorizationKey: String
    ): Single<OAuth2LoginResponse>

    /**
     * Performs logout of authorized user.
     *
     * @param token active access token
     *
     * @return emits [ResponseBody] or [NetworkException] in cas of an error through [Single]
     */
    @POST("logout")
    fun logout(@Header(AUTHORIZATION_HEADER) token: String): Single<ResponseBody>
}