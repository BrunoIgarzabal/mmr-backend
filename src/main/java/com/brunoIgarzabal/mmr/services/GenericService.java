package com.brunoIgarzabal.mmr.services;

import com.brunoIgarzabal.mmr.repositories.GenericRepository;
import com.brunoIgarzabal.mmr.services.exceptions.DataIntegrityException;
import com.brunoIgarzabal.mmr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenericService<T> {

    @Autowired
    protected GenericRepository<T> repository;

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
        T newObj = find(id);
        updateData(newObj, entity);
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

    public List<T> findAll() {
        return repository.findAll();
    }

    public Page<T> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    protected void updateData(T newObj, T oldObj) {}

}
