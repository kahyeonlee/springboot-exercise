package com.springbooot.springboot_exercise.controller;


import com.springbooot.springboot_exercise.dao.UserDao;
import com.springbooot.springboot_exercise.domain.User;
import com.springbooot.springboot_exercise.domain.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
//    @GetMapping("/user")
//    public ResponseEntity<User> get(@PathVariable String id){
//        return this.userDao.deleteById(id);
//    }
    @PostMapping("/user")
    public ResponseEntity<Integer> add(@RequestBody UserRequestDto userRequestDto) {
        User user = new User(userRequestDto.getId(),userRequestDto.getName(),userRequestDto.getPassword());
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }
    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }

}

