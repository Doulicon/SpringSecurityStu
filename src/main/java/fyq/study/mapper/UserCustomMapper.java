package fyq.study.mapper;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/11
 */
public interface UserCustomMapper {

    /**
     * 根据用户名获取用户权限
     * @param username
     * @return
     */
    String findRoleByUserName(String username);

}
