package com.example.demo.adapter.api.github

import com.example.demo.adapter.api.github.model.GitHubAPIResponse
import com.example.demo.domain.port.user.GetUserFromGitHubPort
import com.example.demo.domain.port.user.model.GetUserFromGitHubPortResponse
import com.example.demo.exception.ApiException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository
import java.util.logging.Logger

@Profile("dev")
@Repository
class MockGitHubUserApiAdapter(
) : GetUserFromGitHubPort {

    private val logger = Logger.getLogger(MockGitHubUserApiAdapter::class.java.name)

    override fun getUserFromGitHub(username: String): GetUserFromGitHubPortResponse {

        val json = "{\"login\":\"mock-user\",\"id\":11111111,\"node_id\":\"MDQ6VXNlcjE4MDIxNjg0\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/18021684?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/mock\",\"html_url\":\"https://github.com/mock\",\"followers_url\":\"https://api.github.com/users/mock/followers\",\"following_url\":\"https://api.github.com/users/mock/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/mock/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/mock/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/mock/subscriptions\",\"organizations_url\":\"https://api.github.com/users/mock/orgs\",\"repos_url\":\"https://api.github.com/users/mock/repos\",\"events_url\":\"https://api.github.com/users/mock/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/mock/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":\"Mockname Mocksurname\",\"company\":null,\"blog\":\"\",\"location\":null,\"email\":null,\"hireable\":null,\"bio\":null,\"twitter_username\":null,\"public_repos\":116,\"public_gists\":2,\"followers\":1,\"following\":6,\"created_at\":\"2016-03-23T04:14:30Z\",\"updated_at\":\"2022-12-28T18:47:54Z\"}"

        val mapper = jacksonObjectMapper()
        val result = mapper.readValue(json, GitHubAPIResponse::class.java)

        logger.info("api github user response: $logger")

        return GetUserFromGitHubPortResponse(
                name = result.name,
                id = result.id,
                pic = result.avatarUrl,
                url = result.htmlUrl
        )
    }
}