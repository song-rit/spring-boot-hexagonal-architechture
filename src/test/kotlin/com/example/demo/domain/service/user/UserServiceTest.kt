package com.example.demo.domain.service.user

import com.example.demo.domain.port.user.GetUserFromGitHubPort
import com.example.demo.domain.port.user.model.GetUserFromGitHubPortResponse
import com.example.demo.domain.service.user.usecase.GetUserCommand
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@Tags(
        Tag("user"),
        Tag("domain"),
        Tag("service"),
        Tag("fast")
)
@ExtendWith(MockitoExtension::class)
internal class UserServiceTest {

    @InjectMocks
    lateinit var userService: UserService

    @Mock
    lateinit var getUserFromGitHubPort: GetUserFromGitHubPort

    @Test
    fun `should success when call getUserFromGitHub()`() {
        whenever(getUserFromGitHubPort.getUserFromGitHub(Mockito.anyString())
        ).thenReturn(GetUserFromGitHubPortResponse(
                id = 1234,
                name = "song.cpe",
                pic = "https://avatars.githubusercontent.com/u/18021684?v=4",
                url = "https://github.com/song-rit"
        ))
        val command = GetUserCommand(
                username = "song-cpe"
        )
        val result = userService.getUser(command)

        verify(getUserFromGitHubPort, times(1)).getUserFromGitHub(Mockito.anyString())

        Assertions.assertEquals(1234, result.id)
        Assertions.assertEquals("song.cpe", result.name)
        Assertions.assertEquals("https://avatars.githubusercontent.com/u/18021684?v=4", result.pic)
        Assertions.assertEquals("https://github.com/song-rit", result.url)
    }
}