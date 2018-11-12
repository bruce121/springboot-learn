package com.bruce121.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(
        prefix = "configs.com.bruce121.swagger-ui",
        name = {"enabled"},
        havingValue = "true"
)
public class SwaggerConfig {

    /**
     * api题头信息
     */
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("SpringBoot-SwaggerUI")
                .description("演示使用Swagger-UI生成Restful风格API")
                .contact(new Contact("bruce121", "www.bruce121.com", "caoxunan121@163.com"))
                .version("1.0")
                .build();

        return apiInfo;
    }

    /**
     * 这个Docket可以配置多个，根据项目需要进行多个配置
     * 利用模块区分 或者 利用接口版本区分
     */
    @Bean
    public Docket showControllerApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket//.groupName("USER-operation") // 对api进行分组显示,例如可以使用版本进行分组
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bruce121.controller"))// 指定的包可以扫描到Controller就可以
                .paths(PathSelectors.any())// 可以使用正则regex("/user/.*")
                .build();

        return docket;
    }

}