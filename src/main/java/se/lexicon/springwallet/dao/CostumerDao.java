package se.lexicon.springwallet.dao;

import se.lexicon.springwallet.model.Costumer;

import java.util.List;

public interface CostumerDao extends BaseDao<Costumer, Long> {

    List<Costumer> findByName(String firstName);

}
