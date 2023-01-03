package se.lexicon.springwallet.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.springwallet.dao.AccountDao;
import se.lexicon.springwallet.dao.impl.sequencers.AccountIdGenerator;
import se.lexicon.springwallet.model.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class AccountDaoImpl implements AccountDao {

    private List<Account> storage = new ArrayList<>();

    @Override
    public Account create(Account account) {
        // step1: validate the method parameters
        // step2: generate account number and set it to account id
        // step3: add account to storage
        // step4: return the result
        if (account == null) throw new IllegalArgumentException("Account was null");
        Long accountId = AccountIdGenerator.generateAccountNumber();
        account.setId(accountId);
        storage.add(account);
        return account;
    }

    @Override
    public Optional findById(Long id) {
        if (id == null) throw new IllegalArgumentException("Account id was null");
        return storage.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Account> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(Long id) {


    }
}
