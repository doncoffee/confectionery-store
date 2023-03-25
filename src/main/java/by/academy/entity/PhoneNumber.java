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
@Table(name = PHONE_NUMBER_TABLE_NAME)
public class PhoneNumber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PHONE_NUMBER_ID)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private String number;
    @Column
    @OneToMany(mappedBy = PHONE_NUMBER)
    private Set<Store> stores;
    @Column
    @OneToMany(mappedBy = PHONE_NUMBER)
    private Set<Supplier> suppliers;
}
