package com.example.demo.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserTableService {

    private final UserTableRepository userTableRepository;

    @Autowired
    public UserTableService(UserTableRepository userTableRepository) {
        this.userTableRepository = userTableRepository;
    }

    public List<UserTable> getUserTable() {
        return userTableRepository.findAll();
    }

    public void addNewUserTable(UserTable userTable) {
        Optional<UserTable> studentOptional = userTableRepository.findUserByUsername(userTable.getUsername());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("username taken");
        }
        userTableRepository.save(userTable);
    }

    public void deleteUser(Long usertableId) {
        boolean exists = userTableRepository.existsById(usertableId);
        if (!exists) {
            throw new IllegalStateException("user with id" + usertableId + " does not exists");
        }
        userTableRepository.deleteById(usertableId);
    }

    @Transactional
    public void updateStudent(Long UserTableId,
                              String Username,
                              String Password) {
        UserTable userTable = userTableRepository.findById(UserTableId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + UserTableId + "does not exist"));
        if (Username != null &&
                Username.length() > 0 &&
                !Objects.equals(userTable.getUsername(), Username)) {
            userTable.setUsername(Username);
        }
        if (Password != null &&
                Password.length() > 0 &&
                !Objects.equals(userTable.getPassword(), Password)) {
            Optional<UserTable> UserTableOptional = userTableRepository.findUserByPassword(Password);
            if (UserTableOptional.isPresent()) {
                throw new IllegalStateException("password taken");
            }
            userTable.setPassword(Password);
        }
    }


}


