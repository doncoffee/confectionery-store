package by.academy.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "chocolate")
public class Chocolate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chocolate_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @Column
    private Double price;
    @Column
    private String type;
    @Column
    private Double weight;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @Column
    private String composition;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
