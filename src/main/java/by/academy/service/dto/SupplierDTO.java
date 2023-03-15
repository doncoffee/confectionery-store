package by.academy.service.dto;

import by.academy.entity.Chocolate;
import by.academy.entity.Cookie;
import by.academy.entity.Sweets;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SupplierDTO {
    private Integer id;
    private String name;
    private String contactPerson;
    private Integer addressId;
    private String addressName;
    private Integer phoneNumberId;
    private String phoneNumber;
    private Set<Chocolate> chocolates;
    private Set<Cookie> cookies;
    private Set<Sweets> sweets;
}
