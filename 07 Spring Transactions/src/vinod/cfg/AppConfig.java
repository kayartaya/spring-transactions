package vinod.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import vinod.dao.AccountDao;
import vinod.dao.impl.HibernateTemplateAccountDao;
import vinod.service.AccountService;
import vinod.service.impl.DefaultAccountService;

@Configuration
@ImportResource("classpath:beans.xml")
public class AppConfig {

	@Bean
	public AccountService getAccountService(){
		return new DefaultAccountService();
	}
	
	@Bean
	public AccountDao getAccountDao(){
		return new HibernateTemplateAccountDao();
	}
	
//	@Bean
//	public HibernateTemplate getHibernateTemplate(){
//		HibernateTemplate template = new HibernateTemplate();
//		template.setSessionFactory(getSessionFactory());
//		return template;
//	}
//	
//	public SessionFactory getSessionFactory(){
//		LocalSessionFactoryBean lsfb = 
//			new LocalSessionFactoryBean();
//		String path = "classpath:hibernate.cfg.xml";
//		lsfb.setConfigLocation(new FileSystemResource(path));
//		return (SessionFactory) lsfb;
//	}
}












