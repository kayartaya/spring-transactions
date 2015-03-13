package vinod.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vinod.cfg.AppConfig;
import vinod.service.AccountService;

public class Program01 {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = null;
			ctx = new AnnotationConfigApplicationContext(
					AppConfig.class);
			
		AccountService service = ctx.getBean(AccountService.class);

		service.createAccount(1, "Scott", 2000.0);
		service.createAccount(2, "Miller", 7000.0);
		service.createAccount(3, "John", 6500.0);
		
		System.out.println("Accounts created.");

	}
}
