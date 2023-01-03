package se.lexicon.springwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.springwallet.dao.AccountDao;
import se.lexicon.springwallet.dao.impl.AccountDaoImpl;
import se.lexicon.springwallet.model.Account;

@SpringBootApplication
public class SpringWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWalletApplication.class, args);
    }

}
