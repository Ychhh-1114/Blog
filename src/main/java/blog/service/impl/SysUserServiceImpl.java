package blog.service.impl;

import blog.mapper.SysUserMapper;
import blog.pojo.SysUser;
import blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ychhh
 * @ClassName SysUserServiceImpl.java
 * @Description TODO
 * @createTime 2022年04月19日 14:09:00
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserByID(long id) {
        SysUser user = sysUserMapper.selectById(id);
        if(user == null){
            user = new SysUser();
            user.setNickname("default name");
        }
        return null;
    }
}
