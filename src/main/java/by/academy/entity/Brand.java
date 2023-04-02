package by.academy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

import static by.academy.util.constants.Constants.BRAND;
import static by.academy.util.constants.Constants.BRAND_ID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = BRAND)
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = BRAND_ID)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private String name;
    @Column
    @OneToMany(mappedBy = BRAND)
    private Set<Chocolate> chocolates;
    @Column
    @OneToMany(mappedBy = BRAND)
    private Set<Cookie> cookies;
    @Column
    @OneToMany(mappedBy = BRAND)
    private Set<Sweets> sweets;
}
