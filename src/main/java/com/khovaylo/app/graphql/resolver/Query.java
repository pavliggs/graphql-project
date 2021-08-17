package com.khovaylo.app.graphql.resolver;

import com.khovaylo.app.dto.UserDto;
import com.khovaylo.app.dto.factories.UserFactory;
import com.khovaylo.app.service.IUserService;
import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLNonNull;
import graphql.kickstart.graphql.annotations.GraphQLQueryResolver;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Khovaylo
 */
@Component
@GraphQLQueryResolver
@GraphQLName("Query")
public class Query {

    @GraphQLNonNull
    @GraphQLName("users")
    @GraphQLField
    @GraphQLDescription(value = "get all users")
    public List<UserDto> getUsers() {
        return userService.getAll().stream().map(UserFactory::create).collect(Collectors.toList());
    }

    @GraphQLName("user")
    @GraphQLField
    @GraphQLDescription(value = "get user by id")
    public UserDto user(@GraphQLDescription(value = "user's ID")
                    Long id) throws NotFoundException {
        return UserFactory.create(userService.get(id));
    }

    @Autowired
    private IUserService userService;
}
