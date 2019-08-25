package com.b2b.cart.models.corporate;

import com.b2b.cart.models.AuditModel;
import com.b2b.cart.models.users.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class Department extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long seq;

    @NotBlank
    private String name;

    @NotBlank
    private Company company;


    private User mananger;

}
