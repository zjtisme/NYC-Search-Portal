package com.example.app.controllers;

import com.example.app.models.User;
import com.example.app.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Long userId) throws NotFoundException{
        User foundUser = userRepository.findOne(userId);

        if (foundUser == null) {
            throw new NotFoundException("User with ID of " + userId + " was not found!");
        }

        return foundUser;
    }

    @GetMapping("/username/{userName}")
    public List<User> findUserByUserName(@PathVariable String userName) {
        return userRepository.findUsersWithUsername(userName);
    }

    @PostMapping("/")
    public User createNewUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @DeleteMapping("/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId) throws EmptyResultDataAccessException {
        userRepository.delete(userId);
        return HttpStatus.OK;
    }

    @PatchMapping("/{userId}")
    public User updateUserById(@PathVariable Long userId, @RequestBody User userRequest) throws NotFoundException{

        User userFromDb = userRepository.findOne(userId);

        if (userFromDb == null) {
            throw new NotFoundException("User with ID of " + userId + " was not found!");
        }

        userFromDb.setUserName(userRequest.getUserName());
        userFromDb.setFirstName(userRequest.getFirstName());
        userFromDb.setLastName(userRequest.getLastName());
        userFromDb.setPassword(userRequest.getPassword());
        userFromDb.setGender(userRequest.getGender());
        userFromDb.setEmail(userRequest.getEmail());
        userFromDb.setBirthday(userRequest.getBirthday());
        userFromDb.setPhoneNumber(userRequest.getPhoneNumber());

        return userRepository.save(userFromDb);
    }

    @ExceptionHandler
    void handleUserNotFound(
            NotFoundException exception,
            HttpServletResponse response) throws IOException {

        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

    @ExceptionHandler
    void handleDeleteNotFoundException(
            EmptyResultDataAccessException exception,
            HttpServletResponse response) throws IOException {

        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
