package chap03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import chap03.MemberDao;
import chap03.spring.MemberPrinter;

@Configuration

public class AppConf1 {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean 
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
