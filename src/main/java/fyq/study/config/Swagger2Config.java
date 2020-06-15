package fyq.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * @author fengyongquan
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket creatResApi() {

		//添加请求参数，我们这里把token作为请求头部参数传入后端
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		List<Parameter> parameters = new ArrayList<>();
		parameterBuilder.name("Authorization").description("登录令牌").modelRef(new ModelRef("string"))
				.parameterType("header").required(false).build();
		parameters.add(parameterBuilder.build());

		 return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                //为当前包下controller生成API文档
	                .apis(RequestHandlerSelectors.basePackage("fyq.study.controller"))
	                //为有@Api注解的Controller生成API文档
//	                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
	                //为有@ApiOperation注解的方法生成API文档
//	                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
	                .paths(PathSelectors.any())
				 	.build().globalOperationParameters(parameters);
		
	}
	
	
	 private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("security配置")
	                .description("学习security")
	                .contact("FENGYONGQUAN")
	                .version("1.2")
	                .build();
	    }

}
