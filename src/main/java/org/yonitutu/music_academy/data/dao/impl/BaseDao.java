package org.yonitutu.music_academy.data.dao.impl;

import org.yonitutu.music_academy.data.dao.api.Dao;
import org.yonitutu.music_academy.data.entities.Teacher;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.Type;

public abstract class BaseDao<TEntity, TId> implements Dao<TEntity, TId> {
    protected EntityManager entityManager;

    public BaseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public TEntity create(TEntity entity){
        this.entityManager.getTransaction().begin();

        this.entityManager.persist(entity);

        this.entityManager.flush();

        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public TEntity edit(TEntity editedEntity) {
        this.entityManager.getTransaction().begin();

        this.entityManager.merge(editedEntity);

        this.entityManager.flush();

        this.entityManager.getTransaction().commit();

        return editedEntity;
    }

    @Override
    public TEntity delete(TEntity entityToDelete) {
        this.entityManager.getTransaction().begin();

        this.entityManager.remove(entityToDelete);

        this.entityManager.flush();

        this.entityManager.getTransaction().commit();

        return entityToDelete;
    }
}
