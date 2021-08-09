package com.khovaylo.app.graphql;

import com.khovaylo.app.model.entities.PostEntity;
import com.khovaylo.app.model.entities.UserEntity;
import com.khovaylo.app.model.repositories.IModelContext;
import com.khovaylo.app.service.IUserService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Pavel Khovaylo
 */
@Slf4j
@Component
@GraphQLApi
public class UserGraph {

    @GraphQLQuery(name = "user")
    public UserEntity user(@GraphQLArgument(name = "id") Long id) throws NotFoundException {
        log.info("fetching user with id={}", id);
        return userService.get(id);
    }

    @GraphQLQuery(name = "users")
    public List<UserEntity> users() {
        log.info("fetching all of users");
        return userService.getAll();
    }

    @GraphQLQuery(name = "posts")
    public List<PostEntity> posts(@GraphQLContext UserEntity user) {
        log.info("fetching all of posts by user");
        return dbContext.getPostDataSource().getAllByOwnerId(user.getId());
    }

    @Autowired
    private IUserService userService;

    @Autowired
    private IModelContext dbContext;
}
