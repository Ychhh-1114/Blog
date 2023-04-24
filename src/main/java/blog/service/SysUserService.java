package blog.service;

import blog.pojo.SysUser;

/**
 * @author ychhh
 * @ClassName SysUserService.java
 * @Description TODO
 * @createTime 2022年04月19日 14:09:00
 */
public interface SysUserService {

    SysUser getUserByID(long id);
}
