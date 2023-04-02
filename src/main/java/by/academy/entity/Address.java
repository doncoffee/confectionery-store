package by.academy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

import static by.academy.util.constants.Constants.ADDRESS;
import static by.academy.util.constants.Constants.ADDRESS_ID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = ADDRESS)
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ADDRESS_ID)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private String name;
    @Column
    @OneToMany(mappedBy = ADDRESS)
    private Set<Store> stores;
    @Column
    @OneToMany(mappedBy = ADDRESS)
    private Set<Supplier> suppliers;
}
