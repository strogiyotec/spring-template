package com.template.controller.user;

import com.template.controller.BaseController;
import com.template.controller.input.RegisterUserRequest;
import com.template.controller.output.RegisterUserResponse;
import com.template.page.UserProfilePage;
import com.template.service.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Validated
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserProfilePage> getProfilePage(@PathVariable final Integer id) {
        return ResponseEntity.ok(this.userService.userPageById(id));
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody @Valid final RegisterUserRequest request) {
        return ResponseEntity.ok(this.userService.registerUser(request));
    }
}
