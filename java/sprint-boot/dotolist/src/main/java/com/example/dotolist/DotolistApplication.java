package com.example.dotolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContextInitializer;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

// import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class DotolistApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DotolistApplication.class);
		// SpringApplication.run(DotolistApplication.class, args);
		// application.addInitializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
		// 	@Override
		// 	public void initialize(ConfigurableApplicationContext applicationContext) {
        //         Dotenv dotenv = Dotenv.configure().load();
		// 		dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));

		// 		// PostgreSQL environment variables
		// 		String dbUrl = System.getProperty("DATABASE_URL");
        //         String dbUsername = System.getProperty("DATABASE_USERNAME");
        //         String dbPassword = System.getProperty("DATABASE_PASSWORD");

		// 		// Set PostgreSQL properties in DataSource
        //         DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //         dataSource.setDriverClassName("org.postgresql.Driver");
        //         dataSource.setUrl(dbUrl);
        //         dataSource.setUsername(dbUsername);
        //         dataSource.setPassword(dbPassword);

        //         applicationContext.getBeanFactory().registerSingleton("dataSource", dataSource);
		// 	}
		// });

		application.run(args);
	}

}
