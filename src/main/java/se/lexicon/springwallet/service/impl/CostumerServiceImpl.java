package se.lexicon.springwallet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.springwallet.dao.AccountDao;
import se.lexicon.springwallet.dao.CostumerDao;
import se.lexicon.springwallet.model.Account;
import se.lexicon.springwallet.model.Costumer;
import se.lexicon.springwallet.service.CostumerService;

@Component
public class CostumerServiceImpl implements CostumerService {

    AccountDao accountDao;
    CostumerDao costumerDao;

    @Autowired
    public CostumerServiceImpl(AccountDao accountDao, CostumerDao costumerDao) {
        this.accountDao = accountDao;
        this.costumerDao = costumerDao;
    }

    @Override
    public Costumer registerCostumer(Costumer costumerData) {
        if (costumerData == null) throw new IllegalArgumentException("Costumer Data was null");
        if (costumerData.getAccount() == null) throw new IllegalArgumentException("Account data was null");
        Account accountData = costumerData.getAccount();
        Account createdAccount = accountDao.create(accountData);
        costumerData.setAccount(createdAccount);
        Costumer createdCostumer = costumerDao.create(costumerData);
        return createdCostumer;
    }
}
