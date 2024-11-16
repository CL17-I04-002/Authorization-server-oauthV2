package com.cursos.api.authorization_server.persistence.entity.security;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.Module;

@Entity
@Data
@NoArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String path;

    private String httpMethod;

    private boolean permitAll;

    /*@ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;*/
    @Column(name = "module_id")
    private Long moduleId;
}
