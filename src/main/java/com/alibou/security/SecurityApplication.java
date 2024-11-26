package com.alibou.security;

// import com.alibou.security.module.user.entity.Role;
// import com.alibou.security.security.auth.AuthenticationService;
// import com.alibou.security.security.auth.RegisterRequest;

// import static com.alibou.security.module.user.entity.Role.ADMIN;
// import static com.alibou.security.module.user.entity.Role.MANAGER;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(
	// 		AuthenticationService service
	// ) {
	// 	return args -> {
	// 		var admin = RegisterRequest.builder()
	// 				.firstname("Admin")
	// 				.lastname("Admin")
	// 				.email("admin@mail.com")
	// 				.password("password")
	// 				.role(ADMIN)
	// 				.build();
	// 		service.register(admin);
	// 		// System.out.println("Admin token: " + service.register(admin).getAccessToken());

	// 		var manager = RegisterRequest.builder()
	// 				.firstname("Admin")
	// 				.lastname("Admin")
	// 				.email("manager@mail.com")
	// 				.password("password")
	// 				.role(MANAGER)
	// 				.build();
	// 		service.register(manager);
	// 		// System.out.println("Manager token: " + service.register(manager).getAccessToken());

	// 		var adminCustom = RegisterRequest.builder()
	// 				.firstname("Surapat")
	// 				.lastname("Kanama")
	// 				.email("surapat@mail.com")
	// 				.password("1234")
	// 				.role(ADMIN)
	// 				.build();
	// 		service.register(adminCustom);
	// 		// System.out.println("Admin Custom token: " + service.register(adminCustom).getAccessToken());

	// 	};
	// }
}
