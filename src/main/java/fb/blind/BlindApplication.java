package fb.blind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class}) // 적용 클래스를 자동 구성 하지 않도록 설정
public class BlindApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlindApplication.class, args);
	}
}
