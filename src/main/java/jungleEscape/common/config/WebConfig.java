package jungleEscape.common.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 경로 구분자가 OS에 맞게 자동으로 처리되도록 변경
        String fileUploadPath = "file:" + uploadDir;

        // 업로드된 파일에 접근할 수 있도록 설정
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(fileUploadPath); // 실제 파일 시스템 경로
    }
}
