package com.example.jwt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Product
 *
 * @author lijiehua
 * @date 2018-06-11
 */
@Data
@Entity
public class Product extends AbstractAuditingEntity {
    @Id
    private String id;

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Device> devices;
}
