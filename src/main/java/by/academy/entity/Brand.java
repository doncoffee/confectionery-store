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
@Table(name = "brand")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private String name;
    @Column
    @OneToMany(mappedBy = "brand")
    private Set<Chocolate> chocolates;
    @Column
    @OneToMany(mappedBy = "brand")
    private Set<Cookie> cookies;
    @Column
    @OneToMany(mappedBy = "brand")
    private Set<Sweets> sweets;
}
