package by.academy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private String name;
    @Column
    @OneToMany(mappedBy = "address")
    private Set<Store> stores;
    @Column
    @OneToMany(mappedBy = "address")
    private Set<Supplier> suppliers;
}
