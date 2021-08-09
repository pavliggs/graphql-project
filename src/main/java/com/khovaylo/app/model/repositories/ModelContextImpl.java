package com.khovaylo.app.model.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Pavel Khovaylo
 */
@Repository
public class ModelContextImpl implements IModelContext {

    @Override
    public IUserRepository getUserDataSource() {
        return userRepo;
    }

    @Override
    public IPostRepository getPostDataSource() {
        return postRepo;
    }

    @Override
    public ILikeRepository getLikeDataSource() {
        return likeRepo;
    }

    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private IPostRepository postRepo;

    @Autowired
    private ILikeRepository likeRepo;
}
