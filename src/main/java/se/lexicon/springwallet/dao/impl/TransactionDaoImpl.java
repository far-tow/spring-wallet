package se.lexicon.springwallet.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.springwallet.dao.TransactionDao;
import se.lexicon.springwallet.exeptions.DataNotFoundException;
import se.lexicon.springwallet.model.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class TransactionDaoImpl implements TransactionDao {

    List<Transaction> storage = new ArrayList<>();

    @Override
    public Transaction create(Transaction transaction) {
        if (transaction == null) throw new IllegalArgumentException("transaction was null");
        if (transaction.getCostumer() == null) throw new IllegalArgumentException("Costumer was null");
        if (storage.stream().anyMatch(t -> t.getId().equals(transaction.getId()))) {
            throw new IllegalArgumentException("transaction is duplicated");
        }
        storage.add(transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(String id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        return storage.stream()
                .filter(transaction -> transaction.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Transaction> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(String id) throws DataNotFoundException {
        findById(id).ifPresent(transaction -> storage.remove(transaction));
        throw new DataNotFoundException("id not found");
    }
}
