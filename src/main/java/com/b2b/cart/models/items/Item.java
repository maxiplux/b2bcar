package com.b2b.cart.models.items;

import com.b2b.cart.models.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class Item extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;


    @JsonIgnoreProperties(value = {"categories", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @JsonIgnoreProperties(value = {"types", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Type type;

    @JsonIgnoreProperties(value = {"conditions", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Condition condition;

    @NotBlank
    @Min(value = 0)
    private BigDecimal quality;

    @Min(value = 1)
    private Double price;


    private String picture;

    public Double getPriceWithTaxes() {
        return this.price;
    }
}
