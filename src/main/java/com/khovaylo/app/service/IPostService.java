package com.khovaylo.app.service;

import com.khovaylo.app.model.entities.PostEntity;
import com.khovaylo.app.model.entities.UserEntity;
import javassist.NotFoundException;

import java.util.List;

/**
 * @author Pavel Khovaylo
 */
public interface IPostService {
    PostEntity get(Long id) throws NotFoundException;
    List<PostEntity> getAll();
    PostEntity create(String content, UserEntity owner);
}
