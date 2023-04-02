package by.academy.service.dto;

import by.academy.entity.Store;
import by.academy.entity.Supplier;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressDTO {
    private Integer id;
    private String name;
    private Set<Store> stores;
    private Set<Supplier> suppliers;
}
