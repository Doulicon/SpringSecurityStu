package fyq.study.interceptor;


import fyq.study.constant.consist.GeneralConstant;
import fyq.study.pojo.User;
import fyq.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 用户登录过滤器
 * @author temp
 *
 */
public class AuthenticationInterceptor implements HandlerInterceptor{
	
	@Autowired
    UserService userService;

    /**
     * controller方法执行前拦截
     * @param httpServletRequest
     * @param httpServletResponse
     * @param object
     * @return
     */
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object object) {

        //如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod) object;
        Method method=handlerMethod.getMethod();

        //检查是否有需要CurrentUser的注解
        if(method.isAnnotationPresent(PreAuthorize.class)){
             Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
             String username = authentication.getName();
             User user = userService.isExistUser(username);
             httpServletRequest.setAttribute(GeneralConstant.CURRENT_USER,user);
        }
        return true;
	}

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    /**
     *     // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e)throws Exception{
    }
	

}
