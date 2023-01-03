package se.lexicon.springwallet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.springwallet.dao.AccountDao;
import se.lexicon.springwallet.dao.impl.AccountDaoImpl;

@Configuration
@ComponentScan(basePackages = "se.lexicon.springwallet")
public class AppConfig {

    /*@Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl();
    }*/
}


