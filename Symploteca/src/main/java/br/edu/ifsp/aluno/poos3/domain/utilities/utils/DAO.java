package br.edu.ifsp.aluno.poos3.domain.utilities.utils;

import java.util.Map;
import java.util.Optional;

public interface DAO<T, K> {
    K insert(T entity);

    Optional<T> findOneByKey(K key);

    Map<K, T> findAll();

    boolean update(T entity);

    boolean deleteByKey(K key);

    boolean delete(T entity);
}
