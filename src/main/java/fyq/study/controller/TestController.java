package fyq.study.controller;

import fyq.study.annotation.CurrentUser;
import fyq.study.constant.consist.AuthorityConstant;
import fyq.study.constant.enums.RespCode;
import fyq.study.entity.RespEntity;
import fyq.study.pojo.User;
import fyq.study.security.JwtUserDetails;
import fyq.study.security.UserDetailsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyongquan
 * @description 测试专用接口
 * @date 2020/6/12
 */
@Slf4j
@Api(tags = "TestController", description = "测试专用统一接口")
@RestController
@RequestMapping("test/controller")
public class TestController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    /**
     * 测试。管理员的权限。只有管理员才能访问
     * @return
     */
    @ApiOperation(value = "ADMIN测试权限接口" ,notes = "只有管理员才能访问")
    @PreAuthorize(AuthorityConstant.ADMIN_ONLY)
    @GetMapping(value="/adminTest")
    public RespEntity findAll() {
        return new RespEntity(RespCode.OK,"ADMIN测试权限接口测试成功");
    }

    /**
     * 测试。学生的权限。只有学生权限才能访问
     * @return
     */
    @ApiOperation(value = "STUDENT测试权限接口" ,notes = "只有学生权限才能访问")
    @PreAuthorize(AuthorityConstant.STUDENT_ONLY)
    @GetMapping(value="/studentTest")
    public RespEntity studentTest() {
        return new RespEntity(RespCode.OK,"STUDENT测试权限接口测试测试成功");
    }

    /**
     * 测试。只要登录了就能访问，面向所有用户
     * @return
     */
    @ApiOperation(value = "只要登录了就能访问" ,notes = "ALL_USER")
    @PreAuthorize(AuthorityConstant.ALL_USER)
    @GetMapping(value="/allUserTest")
    public RespEntity ALLTest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取对象，方法一：自定义验证类，实现UserDetailsService接口
        //自定义用户信息对象对象JwtUserDetails，实现UserDetails接口，添加需要添加的用户信息
        //UserDetailsServiceImpl 中的loadUserByUsername方法返回自定义的对象
        //对象通过authentication.getPrincipal()获得
        System.out.println(authentication.getPrincipal().toString());
        return new RespEntity(RespCode.OK,"ALLTest测试成功");
    }

    /**
     * 测试。只要登录了就能访问，面向所有用户
     * @return
     */
    @ApiOperation(value = "只要登录了就能访问并且获取用户所有的信息" ,notes = "ALL_USER")
    @PreAuthorize(AuthorityConstant.ALL_USER)
    @PostMapping(value="/allUserTest2")
    public RespEntity ALLTest2(@CurrentUser User user) {
        //获取对象信息，方法二（不建议使用）：
        //通过注解方式检测注解上的对象，然后注入
        //需要Post方法才能获得对象，代码不优雅
        System.out.println(user);
        return new RespEntity(RespCode.OK,"ALLTest2测试成功");
    }

    /**
     * 测试。教师的权限。只有教师权限才能访问
     * @return
     */
    @ApiOperation(value = "TEACHER测试权限接口" ,notes = "TEACHER")
    @PreAuthorize(AuthorityConstant.TEACHER_ONLY)
    @GetMapping(value="/teacherTest")
    public RespEntity teacherTest() {
        return new RespEntity(RespCode.OK,"TEACHER测试权限接口，测试成功");
    }

    /**
     * 游客访问既不需要登录，也不需要权限，只要url加上/guest/就可以实现
     * @return
     */
    @ApiOperation(value = "游客访问测试接口" ,notes = "guest")
    @GetMapping(value="/guest/test")
    public RespEntity guest() {
        return new RespEntity(RespCode.OK,"游客访问成功");
    }

}
