package fyq.study.security;

import fyq.study.pojo.User;
import fyq.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/11
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.isExistUser(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("不存在该用户");
        }
        //用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，
        // 决定是否可以调用接口
        String role = userService.findRoleByUserName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return new JwtUserDetails(user,username, user.getPassword(), grantedAuthorities);
    }
}
