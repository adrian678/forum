package ca.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ForumApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(applicationContext.getDisplayName());
		System.out.println(applicationContext.getId());

//		MyBean myBean = applicationContext.getBean(MyBean.class);
//		System.out.println(myBean.getApplicationId());
	}

}
