package com.gexingw.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class UserUpdateDTO {

    private Long id;

    private String username;

    private LocalDateTime createTime;

}
