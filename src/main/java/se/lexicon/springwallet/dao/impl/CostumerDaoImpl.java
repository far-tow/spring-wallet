package se.lexicon.springwallet.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.springwallet.dao.CostumerDao;
import se.lexicon.springwallet.dao.impl.sequencers.CostumerIdSequencer;
import se.lexicon.springwallet.model.Costumer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class CostumerDaoImpl implements CostumerDao {

    private List<Costumer> storage = new ArrayList<>();

    @Override
    public Costumer create(Costumer costumer) {
        if (costumer == null) throw new IllegalArgumentException("Costumer was null");
        Long costumerId = CostumerIdSequencer.nextId();
        costumer.setId(costumerId);
        storage.add(costumer);
        return costumer;
    }

    @Override
    public Optional findById(Long id) {
        if (id == null) throw new IllegalArgumentException("Costumer id was null");
        return storage.stream()
                .filter(costumer -> costumer.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Costumer> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(Long aLong) {
        /*ToDo: do it later
        @author: farhad - @Date: 2023-01-03 - @Time: 16:54
        */


    }
}
