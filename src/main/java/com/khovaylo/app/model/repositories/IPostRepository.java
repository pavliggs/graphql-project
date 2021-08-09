package com.khovaylo.app.model.repositories;

import com.khovaylo.app.model.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Pavel Khovaylo
 */
public interface IPostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> getAllByOwnerId(Long ownerId);
}
