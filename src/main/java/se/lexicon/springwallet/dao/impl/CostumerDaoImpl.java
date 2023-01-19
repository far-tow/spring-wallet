package se.lexicon.springwallet.dao.impl;

import org.springframework.stereotype.Component;
import se.lexicon.springwallet.dao.CostumerDao;
import se.lexicon.springwallet.dao.impl.sequencers.CostumerIdSequencer;
import se.lexicon.springwallet.exeptions.DataNotFoundException;
import se.lexicon.springwallet.model.Costumer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CostumerDaoImpl implements CostumerDao {

    private final List<Costumer> storage = new ArrayList<>();

    @Override
    public Costumer create(Costumer costumer) {
        if (costumer == null) throw new IllegalArgumentException("Costumer was null");
        Long costumerId = CostumerIdSequencer.nextId();
        costumer.setId(costumerId);
        storage.add(costumer);
        return costumer;
    }

    @Override
    public Optional<Costumer>findById(Long id) {
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
    public void remove(Long costumerId) throws DataNotFoundException {
       Optional<Costumer> optionalCostumer= findById(costumerId);
        if(!optionalCostumer.isPresent()) throw new DataNotFoundException("Data not found exception");
        else storage.remove(optionalCostumer.get());
    }

    @Override
    public List<Costumer> findByName(String firstName) {
        List<Costumer> filteredList = new ArrayList<>();
    if (firstName == null) throw new IllegalArgumentException("Firstname was null");
    return storage.stream()
            .filter(element -> element.getFirstName().equals(firstName))
            .collect(Collectors.toList());
    }
}
