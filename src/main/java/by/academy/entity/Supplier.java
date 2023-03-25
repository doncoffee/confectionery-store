package by.academy.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static by.academy.util.constants.Constants.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = SUPPLIER)
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = STORE_ID)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private String name;
    @Column
    private String contactPerson;
    @ManyToOne
    @JoinColumn(name = ADDRESS_ID)
    private Address address;
    @ManyToOne
    @JoinColumn(name = PHONE_NUMBER_ID)
    private PhoneNumber phoneNumber;
    @Column
    @OneToMany(mappedBy = SUPPLIER)
    private Set<Chocolate> chocolates;
    @Column
    @OneToMany(mappedBy = SUPPLIER)
    private Set<Cookie> cookies;
    @Column
    @OneToMany(mappedBy = SUPPLIER)
    private Set<Sweets> sweets;
}
