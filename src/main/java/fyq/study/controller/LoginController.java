package fyq.study.controller;

import fyq.study.constant.enums.RespCode;
import fyq.study.entity.LoginBean;
import fyq.study.entity.RespEntity;
import fyq.study.pojo.User;
import fyq.study.security.JwtAuthenticationToken;
import fyq.study.security.SecurityUtils;
import fyq.study.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author fengyongquan
 * @description 登录控制器
 * @date 2020/6/11
 */
@Api(tags = "LoginController", description = "用户登录统一接口")
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录接口，返回token" ,notes = "返回token")
    @PostMapping(value = "/login")
    public RespEntity login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        User user = userService.isExistUser(username);
        //账号不存在
        if(Objects.isNull(user)){
            return new RespEntity(RespCode.ERROR,"账号不存在");
        }
        if(!user.getPassword().equals(password)){
            return new RespEntity(RespCode.ERROR,"密码不正确");
        }
        //系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request,username,"******",authenticationManager);
        return new RespEntity(RespCode.OK, token);

    }



}
