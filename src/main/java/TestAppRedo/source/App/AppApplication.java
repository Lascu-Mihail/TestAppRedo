package TestAppRedo.source.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

	}



	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner run(UserService userService){
//		return args -> {
//            userService.saveRole(new Role(null,"ROLE_USER"));
//			userService.saveRole(new Role(null,"ROLE_MANAGER"));
//			userService.saveRole(new Role(null,"ROLE_ADMIN"));
//
//			userService.saveUser(new User(null,"Mihai","Jansky","1234",new ArrayList<>()));
//			userService.saveUser(new User(null,"Gabi","Gaby","1234",new ArrayList<>()));
//			userService.saveUser(new User(null,"Mircea","Mircea","12345",new ArrayList<>()));
//
//
//			userService.addRole("Jansky","ROLE_USER");
//			userService.addRole("Gaby","ROLE_MANAGER");
//			userService.addRole("Mircea","ROLE_ADMIN");
//		};
//	}

}
