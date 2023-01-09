package se.lexicon.springwallet.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.springwallet.dao.AccountDao;
import se.lexicon.springwallet.dao.impl.sequencers.AccountIdGenerator;
import se.lexicon.springwallet.exeptions.DataNotFoundException;
import se.lexicon.springwallet.model.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class AccountDaoImpl implements AccountDao {

    private final List<Account> storage = new ArrayList<>();

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
    public void remove(Long accountId) throws DataNotFoundException {
        Optional<Account> optionalAccount = findById(accountId);
        if (!optionalAccount.isPresent()) throw new DataNotFoundException("Data not found exception");
        else storage.remove(optionalAccount.get());
    }

    @Override
    public void updateBalance(Account account) throws DataNotFoundException {
        // step1: validate the method parameter
        // step2: check account id
        // step3: update account
        if (account == null) throw new IllegalArgumentException("account data was null");
        Optional<Account> optionalAccount = findById(account.getId());
        if (!optionalAccount.isPresent()) throw new DataNotFoundException("data not found");
        else storage.forEach(element -> {
            if (element.getId().equals(account.getId())) {
                element.setBalance(account.getBalance());
            }
        });
    }
}
