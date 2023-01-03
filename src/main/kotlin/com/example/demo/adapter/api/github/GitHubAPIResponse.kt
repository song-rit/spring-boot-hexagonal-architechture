package com.example.demo.adapter.api.github

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class GitHubAPIResponse(
        @JsonProperty("avatar_url")
        val avatarUrl: String,
        @JsonProperty("created_at")
        val createdAt: String,
        @JsonProperty("events_url")
        val eventsUrl: String,
        @JsonProperty("followers")
        val followers: Int,
        @JsonProperty("followers_url")
        val followersUrl: String,
        @JsonProperty("following")
        val following: Int,
        @JsonProperty("following_url")
        val followingUrl: String,
        @JsonProperty("gists_url")
        val gistsUrl: String,
        @JsonProperty("gravatar_id")
        val gravatarId: String,
        @JsonProperty("html_url")
        val htmlUrl: String,
        @JsonProperty("id")
        val id: Int,
        @JsonProperty("login")
        val login: String,
        @JsonProperty("name")
        val name: String,
        @JsonProperty("node_id")
        val nodeId: String,
        @JsonProperty("organizations_url")
        val organizationsUrl: String,
        @JsonProperty("public_gists")
        val publicGists: Int,
        @JsonProperty("public_repos")
        val publicRepos: Int,
        @JsonProperty("received_events_url")
        val receivedEventsUrl: String,
        @JsonProperty("repos_url")
        val reposUrl: String,
        @JsonProperty("starred_url")
        val starredUrl: String,
        @JsonProperty("subscriptions_url")
        val subscriptionsUrl: String,
        @JsonProperty("type")
        val type: String,
        @JsonProperty("updated_at")
        val updatedAt: String,
        @JsonProperty("url")
        val url: String
)