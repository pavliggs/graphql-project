package com.khovaylo.app.service;

import com.khovaylo.app.model.entities.UserEntity;
import javassist.NotFoundException;

import java.util.List;

/**
 * @author Pavel Khovaylo
 */
public interface IUserService {
    UserEntity get(Long id) throws NotFoundException;
    List<UserEntity> getAll();
    UserEntity createByParameters(String firstName, String lastName, Integer age);
    UserEntity createByUser(UserEntity user);
}
