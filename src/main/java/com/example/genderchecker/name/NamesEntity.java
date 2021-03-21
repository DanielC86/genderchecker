package com.example.genderchecker.name;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Slf4j
@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name="names")
public class NamesEntity implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name="id")
    private Long id;

    @Column(name="name")
    private String name;
}
