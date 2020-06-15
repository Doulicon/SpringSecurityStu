package fyq.study.config;

import fyq.study.annotation.CurrentUser;
import fyq.study.constant.consist.GeneralConstant;
import fyq.study.pojo.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 自定义参数解析器（解析user）
 * 增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 * @author temp
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
    public boolean supportsParameter(MethodParameter parameter){
        //判断是否能转换成User类型
        return parameter.getParameterType().isAssignableFrom(User.class)
                //是否有CurrentUser注解
                && parameter.hasParameterAnnotation(CurrentUser.class);
    }

	@Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        User user = (User) webRequest.getAttribute(GeneralConstant.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
        if (user != null) {
            return user;
        }
        throw new MissingServletRequestPartException(GeneralConstant.CURRENT_USER);
    }

}
