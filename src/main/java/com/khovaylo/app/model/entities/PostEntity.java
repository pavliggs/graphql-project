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
@SequenceGenerator(name = BaseEntity.SEQUENCE_BASE_GENERATOR, sequenceName = "posts_seq", allocationSize = 1)
@Table(name = "posts")
public class PostEntity extends BaseEntity {

    @Column(name = "created_date", nullable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="owner_id", nullable = false)
    private UserEntity owner;
}
