package com.luisedev.restaurant.services;

import com.luisedev.restaurant.dto.UserDto;

public interface IUserService {
    UserDto userCreate (UserDto userDto);
    UserDto userEdit (Long id, UserDto userDto);
    UserDto userDelete (Long id);
}
