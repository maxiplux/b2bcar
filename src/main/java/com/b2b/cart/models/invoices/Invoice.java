package com.b2b.cart.models.invoices;

import com.b2b.cart.models.AuditModel;
import com.b2b.cart.models.items.Item;
import com.b2b.cart.models.users.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class Invoice extends AuditModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String comments;
    @JsonIgnoreProperties(value = {"invoices", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private User customer;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<Item> items;

    public Double getTotal() {
        Double total = 0.00;
        for (Item item : items) {
            total += item.getPriceWithTaxes();
        }
        return total;
    }
}
