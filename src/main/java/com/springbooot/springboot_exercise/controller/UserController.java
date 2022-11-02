package com.springbooot.springboot_exercise.controller;


import com.springbooot.springboot_exercise.dao.UserDao;
import com.springbooot.springboot_exercise.domain.User;
import com.springbooot.springboot_exercise.domain.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        try {
            User user = this.userDao.findById(id);
            return ResponseEntity.ok()
                    .body(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("")
    public ResponseEntity<Integer> add(@RequestBody UserRequestDto userRequestDto) {
        User user = new User(userRequestDto.getId(), userRequestDto.getName(), userRequestDto.getPassword());
        return ResponseEntity
                .ok()
                .body(userDao.add(user));
    }

    @DeleteMapping("")
    public ResponseEntity<Integer> deleteAll() {

        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
}