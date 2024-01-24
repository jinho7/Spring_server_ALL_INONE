package com.group.libraryapp.service.user;

/*
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserJdbcService {

    private final UserJdbcRepository UserJdbcRepository;

    public UserJdbcService(UserJdbcRepository UserJdbcRepository) {
        this.UserJdbcRepository = UserJdbcRepository;
    }

    // POST API
    public void saveUser(UserCreateRequest request) {
        UserJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    // GET API
    public List<UserResponse> getUsers() {
        return UserJdbcRepository.getUsers();
    }

    // PUT API
    public void updateUser(UserUpdateRequest request) {

        if (UserJdbcRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        UserJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    // DELETE API
    public void deleteUser(String name) {

        if (UserJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        UserJdbcRepository.deleteUser(name);
    }
}
 */
