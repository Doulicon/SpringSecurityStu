package fyq.study.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fengyongquan
 * @description Security相关操作
 * @date 2020/6/10
 */
public class SecurityUtils {

    /**
     * 系统登录认证
     * @param request
     * @param username
     * @param password
     * @param authenticationManager
     * @return
     */
    public static JwtAuthenticationToken login(HttpServletRequest request, String username, String password,
                                               AuthenticationManager authenticationManager){
        JwtAuthenticationToken token = new JwtAuthenticationToken(username,password);

        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        token.setToken(JwtTokenUtils.generateToken(authentication));
        return token;
    }

    /**
     * 获取当前登录信息
     * @return
     */
    public static Authentication getAuthentication(){
        if(SecurityContextHolder.getContext()==null){
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  authentication;
    }


    /**
     * 获取令牌并根据令牌获取登录认证信息
     * @param request
     */
    public static void checkAuthentication(HttpServletRequest request){
        Authentication authentication = JwtTokenUtils.getAuthenticationFromToken(request);
        //设置登录认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * 获取当前用户名
     * @return
     */
    public static String getUserName(){
        String username = null;
        Authentication authentication = getAuthentication();
        if(authentication != null){
            Object principal = authentication.getPrincipal();
            if(principal!=null&&principal instanceof UserDetails){
                username = ((UserDetails)principal).getUsername();
            }
        }
        return username;
    }

    /**
     * 获取用户名
     * @param authentication
     * @return
     */
    public static String getUsername(Authentication authentication){
        String username = null;
        if(authentication != null){
            Object principal = authentication.getPrincipal();
            if(principal !=null && principal instanceof UserDetails){
                username = ((UserDetails)principal).getUsername();
            }
        }
        return username;
    }



}
