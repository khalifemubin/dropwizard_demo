package com.synergym.resources;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;

public class SynergymEntityDAO extends AbstractDAO<SynergymEntity> {

    public SynergymEntityDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public SynergymEntity find(String id) {
        return get(id);
    }

    public SynergymEntity save(SynergymEntity entity) {
        if (StringUtils.isEmpty(entity.getId()))
            entity.setId(UUID.randomUUID().toString());
        return persist(entity);
    }

}
