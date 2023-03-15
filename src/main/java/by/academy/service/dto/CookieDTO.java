package by.academy.service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CookieDTO {
    private Integer id;
    private Double price;
    private String type;
    private Double weight;
    private Integer brandId;
    private String brandName;
    private String composition;
    private Integer storeId;
    private String storeName;
    private Integer supplierId;
    private String supplierName;
}
