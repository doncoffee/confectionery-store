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
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_number_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private String number;
    @Column
    @OneToMany(mappedBy = "phoneNumber")
    private Set<Store> stores;
    @Column
    @OneToMany(mappedBy = "phoneNumber")
    private Set<Supplier> suppliers;
}
