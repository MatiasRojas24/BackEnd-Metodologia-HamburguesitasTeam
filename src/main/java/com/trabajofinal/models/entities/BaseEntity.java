package com.trabajofinal.models.entities;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public abstract class BaseEntity implements Serializable {
    @Id
    protected String id;

    @PrePersist
    public void generateId() {
        if (id == null) id = UUID.randomUUID().toString();

    }
}
