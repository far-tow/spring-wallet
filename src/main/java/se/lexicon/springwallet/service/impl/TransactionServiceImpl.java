package se.lexicon.springwallet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.springwallet.dao.AccountDao;
import se.lexicon.springwallet.dao.CostumerDao;
import se.lexicon.springwallet.dao.TransactionDao;
import se.lexicon.springwallet.exeptions.DataNotFoundException;
import se.lexicon.springwallet.exeptions.InsufficientFoundsException;
import se.lexicon.springwallet.model.Account;
import se.lexicon.springwallet.model.Costumer;
import se.lexicon.springwallet.model.Transaction;
import se.lexicon.springwallet.model.TransactionType;
import se.lexicon.springwallet.service.TransactionService;

import java.util.Optional;

@Component
public class TransactionServiceImpl implements TransactionService {

    CostumerDao costumerDao;
    AccountDao accountDao;
    TransactionDao transactionDao;

    @Autowired
    public TransactionServiceImpl(CostumerDao costumerDao, AccountDao accountDao, TransactionDao transactionDao) {
        this.costumerDao = costumerDao;
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
    }

    @Override
    public Transaction moneyTransfer(Long costumerId, double amount, TransactionType type) throws Throwable {
        Costumer costumer = costumerDao.findById(costumerId)
                .orElseThrow(()-> new DataNotFoundException("costumer id was not valid"));

        Account account = costumer.getAccount();
        if (type.equals(TransactionType.DEPOSIT))account.deposit(amount);
        else account.withdraw(amount);

        accountDao.updateBalance(account);

        Transaction transactionData = new Transaction(costumer, type, amount);
        Transaction createdTransaction = transactionDao.create(transactionData);


        return createdTransaction;
    }
}
