package com.template.controller.user;

import com.template.controller.input.RegisterUserRequest;
import com.template.service.UserService;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

@WebMvcTest
@ExtendWith(RandomBeansExtension.class)
public final class UserControllerTestCase {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    //TODO: test can't config objectmapper
    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @MethodSource("fakeRequest")
    void testInvalidUserRegisterRequest(final RegisterUserRequest registerUserRequest) throws Exception {
        this.mockMvc.perform(
            post("/users")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .content(this.objectMapper.writeValueAsBytes(registerUserRequest))
        ).andExpect(status().isBadRequest());
    }

    private static Stream<RegisterUserRequest> fakeRequest() {
        return Stream.of(
            new RegisterUserRequest(
                RandomStringUtils.random(60),//too big username
                RandomStringUtils.random(5),//random invalid email
                RandomStringUtils.random(4),//random week password
                RandomStringUtils.random(60),//too big name
                RandomStringUtils.random(60)//too big surname
            )
        );
    }

}
