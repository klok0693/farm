package by.farm;

import by.farm.data_structure.CowTreeMap;
import by.farm.service.CowService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SpringBootApplication
public class FarmApplication {

	public static void main(@Nullable String[] args) {
		new SpringApplicationBuilder(FarmApplication.class).web(false).run(args);
	}


	//console output
	@Bean
	@Nonnull
	public CommandLineRunner demo(@Nonnull CowService service) {
		return args -> {

            CowTreeMap tree = new CowTreeMap();

            tree.GiveBirth(null, 1, "Brown");  //first cow
            tree.GiveBirth(1,2,"White");       //child cow
            tree.PrintFarmData();

            tree.EndLifeSpan(1);
            tree.PrintFarmData();
        };
	}
}
