package by.bsuir.userhibernate.dao;

import java.util.List;
import java.util.Optional;

/**
 * Date: 09.04.2019
 *
 * @author Kavzovich Anastasia
 * @version 1.0
 */
public interface UserdataDao<T> {
    List<T> findAll();

    Optional<T> findById(int id);

    void create(T entity);

    void delete(T entity);

    void update(T entity);

}
