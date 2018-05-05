package by.farm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.Nullable;

@SpringBootApplication
public class FarmApplication {

	public static void main(@Nullable String[] args) {
		//SpringApplication.run(FarmApplication.class, args);
		new SpringApplicationBuilder(FarmApplication.class).web(true).run(args);
	}

	/*@Bean
	@Nonnull
	public CommandLineRunner demo(@Nonnull CowService service) {
		return new CommandLineRunner() {
			// начиная со spring boot 1.5 ридонли над методом который вызывает репозиторий нужен обязательно
			// что бы не закрывалась сессия.
			@Override
			//@Transactional(readOnly = true)
			public void run(String... args) throws Exception {
				System.out.println(service.FindAll());

				service.GiveBirth(3,"Angel");

				System.out.println(service.FindAll());

				service.EndLifeSpan(2);

				System.out.println(service.FindAll());
			}
		};
	}*/
}
