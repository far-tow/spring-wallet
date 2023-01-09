package se.lexicon.springwallet.dao;

import se.lexicon.springwallet.exeptions.DataNotFoundException;
import se.lexicon.springwallet.model.Account;

public interface AccountDao extends BaseDao<Account, Long> {
    void updateBalance(Account account) throws DataNotFoundException;

}
