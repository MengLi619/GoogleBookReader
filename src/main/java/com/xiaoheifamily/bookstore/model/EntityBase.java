package com.xiaoheifamily.bookstore.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isNew() {
        return id == 0;
    }
}