package se.lexicon.springwallet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.springwallet.config.AppConfig;
import se.lexicon.springwallet.model.Account;
import se.lexicon.springwallet.model.Costumer;
import se.lexicon.springwallet.service.CostumerService;

public class App {

    public static void main(String[] args) {
        //AccountDao accountDao = new AccountDaoImpl();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CostumerService costumerService = context.getBean(CostumerService.class);
        System.out.println(costumerService.registerCostumer(new Costumer("Farhad", "Towfighian", new Account(100.98))));


       /* AccountDao accountDao = context.getBean(AccountDao.class);
        CostumerDao costumerDao = context.getBean(CostumerDao.class);
        Account accountData = new Account(0);
        Account createdAccount = accountDao.create(accountData);
        //System.out.println("createdAccount = " + createdAccount);
        Account accountData2 = new Account(10);
        Account createdAccount2 = accountDao.create(accountData2);
        //System.out.println("createdAccount2 = " + createdAccount2);

        Costumer costumerData = new Costumer("Farhad", "Towfighian", createdAccount);
        Costumer createdCostumer = costumerDao.create(costumerData);
        System.out.println("createdCostumer = " + createdCostumer);
        Costumer costumerData2 = new Costumer("Mehrdad", "Javan", createdAccount2);
        Costumer createdCostumer2 = costumerDao.create(costumerData2);
        System.out.println("createdCostumer2 = " + createdCostumer2);*/

    }
}
