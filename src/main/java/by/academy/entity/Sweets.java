package by.academy.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

import static by.academy.util.constants.Constants.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = SWEETS)
public class Sweets implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = SWEETS_ID)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private Double price;
    @Column
    private String type;
    @Column
    private Double weight;
    @ManyToOne
    @JoinColumn(name = BRAND_ID)
    private Brand brand;
    @Column
    private String composition;
    @ManyToOne
    @JoinColumn(name = STORE_ID)
    private Store store;
    @ManyToOne
    @JoinColumn(name = SUPPLIER_ID)
    private Supplier supplier;
}
