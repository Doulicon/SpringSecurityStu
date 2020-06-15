package fyq.study.service;

import fyq.study.pojo.User;

/**
 * @author fengyongquan
 * @description
 * @date 2020/4/10
 */
public interface UserService {
    /**
     * 判断用户是否存在
     * @param username
     * @return 返回用户权限和用户名
     */
    User isExistUser(String username);

    /**
     * 根据用户名获取用户权限
     * @param username
     * @return
     */
    String findRoleByUserName(String username);



}
