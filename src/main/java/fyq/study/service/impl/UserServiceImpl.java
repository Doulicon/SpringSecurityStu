package fyq.study.service.impl;


import fyq.study.mapper.UserCustomMapper;
import fyq.study.mapper.UserMapper;
import fyq.study.pojo.User;
import fyq.study.pojo.UserExample;
import fyq.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author fengyongquan
 * @description
 * @date 2020/4/10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserCustomMapper userCustomMapper;

    /**
     * 判断用户是否存在
     *
     * @param username
     * @return
     */
    @Override
    public User isExistUser(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();

        criteria.andUserNameEqualTo(username);
        criteria.andDelFlagEqualTo(0);
        List<User> list = userMapper.selectByExample(example);

        if(!CollectionUtils.isEmpty(list) && list.size()>0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据用户名获取用户权限
     *
     * @param username
     * @return
     */
    @Override
    public String findRoleByUserName(String username) {
        return userCustomMapper.findRoleByUserName(username);
    }

}
