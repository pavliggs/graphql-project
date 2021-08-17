package com.khovaylo.app.dto;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLNonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pavel Khovaylo
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@GraphQLName("User")
public class UserDto {
    @GraphQLField
    @GraphQLNonNull
    private Long id;
    @GraphQLField
    @GraphQLNonNull
    private String firstName;
    @GraphQLField
    @GraphQLNonNull
    private String lastName;
    @GraphQLField
    @GraphQLNonNull
    private Integer age;
}
