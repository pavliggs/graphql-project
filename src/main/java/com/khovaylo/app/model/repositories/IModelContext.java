package com.khovaylo.app.model.repositories;

/**
 * @author Pavel Khovaylo
 */
public interface IModelContext {
    IUserRepository getUserDataSource();
    IPostRepository getPostDataSource();
    ILikeRepository getLikeDataSource();
}
