package pack;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // ✅ CORS 설정
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 모든 클라이언트 요청 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용 HTTP 메소드
                .allowCredentials(true); // 쿠키 인증 요청 허용
    }

    // ✅ 기본 경로("/") 접근 시 자동으로 router/main.html로 이동하도록 설정
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/") // 루트 경로로 들어오면
                .setViewName("forward:/router/main.html"); // router 폴더 안에 있는 main.html로 포워딩
    }
}
