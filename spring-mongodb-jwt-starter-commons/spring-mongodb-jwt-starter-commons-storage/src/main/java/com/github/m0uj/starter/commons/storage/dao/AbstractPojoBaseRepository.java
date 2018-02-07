package com.github.m0uj.starter.commons.storage.dao;

import com.github.m0uj.starter.commons.storage.pojo.AbstractPojo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by m0uj on 3/28/17.
 */
@NoRepositoryBean
public interface AbstractPojoBaseRepository<T extends AbstractPojo> extends MongoRepository<T, String> {
    public T findById(String id);
}
