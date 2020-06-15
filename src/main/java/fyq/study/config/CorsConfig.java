package fyq.study.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域问题配置
 * @author temp
 *
 */
@SuppressWarnings("deprecation")
public class CorsConfig extends WebMvcConfigurerAdapter{

	@Override  
    public void addCorsMappings(CorsRegistry registry) {  
		 registry.addMapping("/**")
         .allowedOrigins("*")
         .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
         .allowCredentials(true)
         .maxAge(3600)
         .allowedHeaders("*");
    }

}
