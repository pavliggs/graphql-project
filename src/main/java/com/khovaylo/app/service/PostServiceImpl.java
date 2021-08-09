package com.khovaylo.app.service;

import com.khovaylo.app.model.entities.PostEntity;
import com.khovaylo.app.model.entities.UserEntity;
import com.khovaylo.app.model.repositories.IModelContext;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Pavel Khovaylo
 */
@Service
public class PostServiceImpl implements IPostService {

    @Override
    public PostEntity get(Long id) throws NotFoundException {
        Optional<PostEntity> optionalPost = dbContext.getPostDataSource().findById(id);
        if (optionalPost.isEmpty()) {
            logger.error("post {} is not found", id);
            throw new NotFoundException(String.format("post %d is not found", id));
        }
        return optionalPost.get();
    }

    @Override
    public List<PostEntity> getAll() {
        return dbContext.getPostDataSource().findAll();
    }

    @Override
    public PostEntity create(String content, UserEntity owner) {
        final PostEntity post = new PostEntity();
        post.setCreatedDate(new Date());
        post.setContent(content);
        post.setOwner(owner);
        return dbContext.getPostDataSource().save(post);
    }

    @Autowired
    private IModelContext dbContext;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
}
