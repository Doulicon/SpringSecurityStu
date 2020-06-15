package fyq.study.constant.consist;

/**
 * @author fengyongquan
 * @description 用来存放权限常量
 * @date 2020/3/23
 */
public class AuthorityConstant {

    /** 只有管理员才能访问 */
    public static final String ADMIN_ONLY = "hasAuthority('ADMIN')";
    /** 只有教师才能访问 */
    public static final String TEACHER_ONLY = "hasAuthority('TEACHER')";
    /** 只有学生才能访问 */
    public static final String STUDENT_ONLY = "hasAuthority('STUDENT')";
    /** 教师和学生能访问 */
    public static final String TECH_AND_STU = "hasAuthority('TEACHER') or hasAuthority('STUDENT')";
    /** 管理员和教师能访问 */
    public static final String ADMIN_AND_TECH = "hasAuthority('TEACHER') or hasAuthority('ADMIN')";
    /** 管理员和学生能访问 */
    public static final String ADMIN_AND_STU = "hasAuthority('STUDENT') or hasAuthority('ADMIN')";
    /** 只要登录了，就能访问 */
    public static final String ALL_USER = "hasAuthority('STUDENT') or hasAuthority('ADMIN') or hasAuthority('TEACHER')";

}
