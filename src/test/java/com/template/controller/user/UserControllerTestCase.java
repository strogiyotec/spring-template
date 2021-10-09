package com.template.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.template.controller.input.RegisterUserRequest;
import io.github.glytching.junit.extension.random.RandomBeansExtension;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

@WebMvcTest
@ExtendWith(RandomBeansExtension.class)
@Import(UserControllerConfig.class)
public final class UserControllerTestCase {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Test that invalid request was rejected.
     */
    @ParameterizedTest
    @MethodSource("invalidFakeRequest")
    void testInvalidUserRegisterRequest(final RegisterUserRequest invalidRequest) throws Exception {
        this.mockMvc.perform(
            post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsBytes(invalidRequest))
        ).andExpect(status().isBadRequest());
    }

    /**
     * Test that valid request was accepted.
     */
    @ParameterizedTest
    @MethodSource("validFakeRequest")
    void testValidaRegisterRequest(final RegisterUserRequest validRequest) throws Exception {
        this.mockMvc.perform(
            post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsBytes(validRequest))
        ).andExpect(status().isOk());
    }

    private static Stream<RegisterUserRequest> validFakeRequest() {
        return Stream.of(
            new RegisterUserRequest(
                "mr.lollipop",
                "almas337519@gmail.com",
                "STRONG_PASSWORD",
                "almas",
                "abdrazak"
            )
        );
    }

    private static Stream<RegisterUserRequest> invalidFakeRequest() {
        return Stream.of(
            new RegisterUserRequest(
                RandomStringUtils.randomAlphabetic(60),//too big username
                RandomStringUtils.randomAlphabetic(5),//random invalid email
                RandomStringUtils.randomAlphabetic(4),//random week password
                RandomStringUtils.randomAlphabetic(60),//too big name
                RandomStringUtils.randomAlphabetic(60)//too big surname
            )
        );
    }

}
