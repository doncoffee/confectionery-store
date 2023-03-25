package by.academy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static by.academy.util.constants.Constants.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = CHOCOLATE)
public class Chocolate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CHOCOLATE_ID)
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
