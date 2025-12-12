package com.gexingw.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class UserPO {

    private Long id;

    private String username;

    private LocalDateTime createTime;

    public UserPO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

}
