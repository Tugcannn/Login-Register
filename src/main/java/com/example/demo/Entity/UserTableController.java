package com.example.demo.Entity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")

public class UserTableController {

    private final UserTableService userTableService;

    public UserTableController(UserTableService userTableService) {
        this.userTableService = userTableService;
    }

    @GetMapping()
    public List<UserTable> getUsers() {
        return this.userTableService.getUserTable();
    }

    @RequestMapping(value = "/signup",method = {RequestMethod.POST})
    public void registerNewUserTable(@RequestBody UserTable userTable) {

        userTableService.addNewUserTable(userTable);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteUser(@PathVariable("userID") Long userId) {

        userTableService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUserTable(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String Username,
            @RequestParam(required = false) String Password) {
        userTableService.updateStudent(userId, Username, Password);
    }

}
