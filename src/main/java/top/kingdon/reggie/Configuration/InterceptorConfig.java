package top.kingdon.reggie.Configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.kingdon.reggie.intercaptor.AdminLoginInterceptor;
import top.kingdon.reggie.intercaptor.LoginInterceptor;

@Configuration      //配置注解，表示这是一个配置类
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())     //添加拦截器
                .addPathPatterns("/front/page/**","/shoppingCart/*","/*","/front/index.html").   //要拦截的目录
                excludePathPatterns("/front/page/login.html");     //不被拦截的目录

        registry.addInterceptor(new AdminLoginInterceptor())
                .addPathPatterns("/*","/backend/page/**","/backend/index.html","/dish/**")
                .excludePathPatterns("/backend/page/login/login.html","/employee/login");

    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
