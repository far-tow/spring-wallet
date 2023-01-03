package se.lexicon.springwallet.dao;

import java.util.Collection;
import java.util.Optional;

public interface BaseDao <T, ID>{
    T create (T t);
    Optional findById(ID id);
    Collection<T> findAll();
    void remove (ID id);


}
