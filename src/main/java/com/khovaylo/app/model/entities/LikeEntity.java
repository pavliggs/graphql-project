package com.khovaylo.app.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Pavel Khovaylo
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = BaseEntity.SEQUENCE_BASE_GENERATOR, sequenceName = "likes_seq", allocationSize = 1)
@Table(name = "likes")
public class LikeEntity extends BaseEntity {

    @Column(name = "created_date", nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name="liked_post_id", nullable = false)
    private PostEntity likedPost;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="like_owner_id", nullable = false)
    private UserEntity likeOwner;
}
