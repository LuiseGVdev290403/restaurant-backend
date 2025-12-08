package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.UserDto;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService{
    @Override
    public UserDto userCreate(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto userEdit(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public UserDto userDelete(Long id) {
        return null;
    }
}
