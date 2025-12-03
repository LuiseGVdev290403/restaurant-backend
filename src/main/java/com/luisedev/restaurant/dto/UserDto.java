package com.luisedev.restaurant.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String lastName;
    private String dni;
    private String direction;
    private String district;
}
