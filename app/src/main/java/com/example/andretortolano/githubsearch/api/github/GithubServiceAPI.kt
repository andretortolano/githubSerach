package com.example.andretortolano.githubsearch.api.github

import com.example.andretortolano.githubsearch.api.github.responses.Repository
import com.example.andretortolano.githubsearch.api.github.responses.RepositoryResult
import com.example.andretortolano.githubsearch.api.github.responses.User
import com.example.andretortolano.githubsearch.api.github.responses.UserResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface GithubServiceAPI {

    @GET("search/users") // https://developer.github.com/v3/search/#search-users
    fun searchUser(@Query("q") query: String): Observable<UserResult>

    @GET("search/users") // https://developer.github.com/v3/search/#search-users
    fun searchUserSorted(@Query("q") query: String, @Query("sort") sort: String, @Query("order") order: String): Observable<UserResult>

    @GET("users/{username}") // https://developer.github.com/v3/users/#get-a-single-user
    fun getUser(@Path("username") username: String): Observable<User>

    @GET("search/repositories") // https://developer.github.com/v3/search/#search-repositories
    fun searchRepository(@Query("q") query: String): Observable<RepositoryResult>

    @GET("search/repositories") // https://developer.github.com/v3/search/#search-repositories
    fun searchRepositorySorted(@Query("q") query: String, @Query("sort") sort: String, @Query("order") order: String): Observable<RepositoryResult>

    @GET("repos/{owner}/{repository}") // https://developer.github.com/v3/repos/#get
    fun getRepository(@Path("owner") owner: String, @Path("repository") repository: String): Observable<Repository>
}
