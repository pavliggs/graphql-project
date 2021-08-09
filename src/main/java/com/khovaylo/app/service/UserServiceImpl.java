package com.khovaylo.app.service;

import com.khovaylo.app.model.entities.UserEntity;
import com.khovaylo.app.model.repositories.IModelContext;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Pavel Khovaylo
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public UserEntity get(Long id) throws NotFoundException {
        Optional<UserEntity> optionalUser = dbContext.getUserDataSource().findById(id);
        if (optionalUser.isEmpty()) {
            logger.error("user with id={} is not found", id);
            throw new NotFoundException(String.format("user with id=%d is not found", id));
        }
        return optionalUser.get();
    }

    @Override
    public List<UserEntity> getAll() {
        return dbContext.getUserDataSource().findAll();
    }

    @Override
    public UserEntity createByParameters(String firstName, String lastName, Integer age) {
        return dbContext.getUserDataSource().save(new UserEntity(firstName, lastName, age));
    }

    @Override
    public UserEntity createByUser(UserEntity user) {
        return dbContext.getUserDataSource().save(user);
    }

    @Autowired
    private IModelContext dbContext;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
}
