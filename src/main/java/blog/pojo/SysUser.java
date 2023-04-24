package blog.pojo;

import lombok.Data;

/**
 * @author ychhh
 * @ClassName SysUser.java
 * @Description TODO
 * @createTime 2022年04月19日 08:57:00
 */
@Data
public class SysUser {
    private Long id;

    private String account;

    private Integer admin;

    private String avatar;

    private Long createDate;

    private Integer deleted;

    private String email;

    private Long lastLogin;

    private String mobilePhoneNumber;

    private String nickname;

    private String password;

    private String salt;

    private String status;
}
