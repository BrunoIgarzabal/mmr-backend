package com.brunoIgarzabal.mmr.domain;

import javax.persistence.*;

@MappedSuperclass
public abstract class Base<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
