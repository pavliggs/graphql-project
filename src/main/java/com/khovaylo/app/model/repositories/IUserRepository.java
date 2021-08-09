package com.khovaylo.app.model.repositories;

import com.khovaylo.app.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavel Khovaylo
 */
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
}
