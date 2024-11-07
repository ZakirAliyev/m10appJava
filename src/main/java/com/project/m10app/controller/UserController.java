package com.project.m10app.controller;

import com.project.m10app.model.ApiResponse;
import com.project.m10app.model.User;
import com.project.m10app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<ApiResponse> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();

            ApiResponse response = new ApiResponse(
                    HttpStatus.OK.value(),
                    new ApiResponse.DataWrapper("Users retrieved successfully", users)
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            ApiResponse response = new ApiResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    new ApiResponse.DataWrapper(e.getMessage(), null)
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }




    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
