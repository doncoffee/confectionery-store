package by.academy.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private String name;
    @Column
    private String contactPerson;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "phone_number_id")
    private PhoneNumber phoneNumber;
    @Column
    @OneToMany(mappedBy = "supplier")
    private Set<Chocolate> chocolates;
    @Column
    @OneToMany(mappedBy = "supplier")
    private Set<Cookie> cookies;
    @Column
    @OneToMany(mappedBy = "supplier")
    private Set<Sweets> sweets;
}
