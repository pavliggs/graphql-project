package com.khovaylo.app.model.entities;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Pavel Khovaylo
 */
@Data
@MappedSuperclass
public class BaseEntity {

    public final static String SEQUENCE_BASE_GENERATOR = "base_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_BASE_GENERATOR)
    private Long id;
}
