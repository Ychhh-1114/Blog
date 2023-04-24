package blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ychhh
 * @ClassName WebMVCConfig.java
 * @Description TODO
 * @createTime 2022年04月19日 08:37:00
 */
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    /*
     *功能描述
     *  当前端访问的端口和后端启动的端口不是一个端口的时候，
     *  需要进行配置使得前端的的端口可以正常的访问后端的端口即跨域配置
     *
     * @author ychhh
     * @date 2022/4/19
     * @param null
     * @return
     */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域配置
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }
}
