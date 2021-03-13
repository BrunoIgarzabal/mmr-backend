package com.brunoIgarzabal.mmr.services;

import com.brunoIgarzabal.mmr.repositories.GenericRepository;
import com.brunoIgarzabal.mmr.services.exceptions.DataIntegrityException;
import com.brunoIgarzabal.mmr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenericService<T> {

    @Autowired
    private GenericRepository<T> repository;

    public T find(Integer id) {
        Optional<T> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id
        ));
    }

    public T insert(T entity) {
        return repository.save(entity);
    }

    public T update(T entity, Integer id) {
        find(id);
        return repository.save(entity);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Este objeto possui dependências de outras entidades e não pode ser removido.");
        }
    }

}
