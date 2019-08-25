package com.b2b.cart.models.corporate;

import com.b2b.cart.models.AuditModel;
import com.b2b.cart.models.generic.Address;
import com.b2b.cart.models.users.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class Company extends AuditModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long seq;


    @NotBlank
    private String name;


    private Holding holding;

    @Email
    private String email;


    //@NotBlank
    private Address primaryAddress;

    @NotBlank

    private String primaryPhone;

    private Address secondaryAddress;

    private String extraData;


    private User manager;

}
