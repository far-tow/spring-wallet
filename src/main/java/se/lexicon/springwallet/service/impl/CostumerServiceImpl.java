package se.lexicon.springwallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.springwallet.dao.AccountDao;
import se.lexicon.springwallet.dao.CostumerDao;
import se.lexicon.springwallet.model.Costumer;

public class CostumerServiceImpl implements CostumerService{

    AccountDao accountDao;
    CostumerDao costumerDao;

    @Autowired
    public CostumerServiceImpl(AccountDao accountDao, CostumerDao costumerDao) {
        this.accountDao = accountDao;
        this.costumerDao = costumerDao;
    }

    @Override
    public Costumer registerCostumer(Costumer costumerData) {
        if (costumerData == null)throw new IllegalArgumentException("Costumer Data was null");
        if (costumerData.getAccount() == null) throw new IllegalArgumentException("Account data was null");

        return null;
    }
}
