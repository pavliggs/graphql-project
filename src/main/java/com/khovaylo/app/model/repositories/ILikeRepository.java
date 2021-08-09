package com.khovaylo.app.model.repositories;

import com.khovaylo.app.model.entities.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Pavel Khovaylo
 */
public interface ILikeRepository extends JpaRepository<LikeEntity, Long> {

    List<LikeEntity> getAllByLikedPostId(Long postId);
}
