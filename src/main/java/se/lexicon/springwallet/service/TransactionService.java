package se.lexicon.springwallet.service;

import se.lexicon.springwallet.exeptions.DataNotFoundException;
import se.lexicon.springwallet.exeptions.InsufficientFoundsException;
import se.lexicon.springwallet.model.Transaction;
import se.lexicon.springwallet.model.TransactionType;

public interface TransactionService {
    Transaction moneyTransfer(Long costumerId, double amount, TransactionType type) throws Throwable;


}
