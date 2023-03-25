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
@Table(name = STORE)
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = STORE_ID)
    @EqualsAndHashCode.Include
    private Integer id;
    @ManyToOne
    @JoinColumn(name = ADDRESS_ID)
    private Address address;
    @ManyToOne
    @JoinColumn(name = PHONE_NUMBER_ID)
    private PhoneNumber phoneNumber;
    @Column
    @OneToMany(mappedBy = STORE)
    private Set<Chocolate> chocolates;
    @Column
    @OneToMany(mappedBy = STORE)
    private Set<Cookie> cookies;
    @Column
    @OneToMany(mappedBy = STORE)
    private Set<Sweets> sweets;
}
