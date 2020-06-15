package fyq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fengyongquan
 * @description
 * @date 2020/4/7
 */
@SpringBootApplication
@MapperScan("fyq.study.mapper")
public class AppSecurity {
    public static void main(String[] args) {
        SpringApplication.run(AppSecurity.class, args);
    }

}
