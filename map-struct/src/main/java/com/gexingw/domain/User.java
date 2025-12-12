package com.gexingw.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 好友
     */
    private User bestFriend;

    /**
     * 部门Id
     */
    private Long deptId;

    public User(Long id, String username, LocalDateTime createTime) {
        this.id = id;
        this.username = username;
        this.createTime = createTime;
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
        this.createTime = LocalDateTime.now();
    }

}
