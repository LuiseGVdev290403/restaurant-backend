package com.luisedev.restaurant.dto;


import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersDto {
    private Long id;
    private Date dateOrder;
    private Time timeAprox;
    private StateDto stateDto;
    private double total;
}
