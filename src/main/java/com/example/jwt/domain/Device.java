package com.example.jwt.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Device
 *
 * @author lijiehua
 * @date 2018-06-11
 */
@Data
@Entity
public class Device extends AbstractAuditingEntity {
    @Id
    private String id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
