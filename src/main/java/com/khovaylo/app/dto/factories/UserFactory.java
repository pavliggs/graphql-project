package com.khovaylo.app.dto.factories;

import com.khovaylo.app.dto.UserDto;
import com.khovaylo.app.model.entities.UserEntity;

/**
 * @author Pavel Khovaylo
 */
public class UserFactory {
    public static UserDto create(UserEntity entity) {
        return new UserDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getAge());
    }
}
