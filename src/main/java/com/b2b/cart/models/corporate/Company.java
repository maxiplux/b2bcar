package com.b2b.cart.models.corporate;

import com.b2b.cart.models.AuditModel;
import com.b2b.cart.models.generic.Address;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Document(collection = "companies")
public class Company extends AuditModel {


    @Id
    private String companyId;

    private long seq;


    @NotBlank
    private String name;

    @NotBlank
    private Holding holding;

    @Email
    private String email;


    @NotBlank
    private Address primaryAddress;

    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String primaryPhone;

    private Address secondaryAddress;

    private String extraData;

}
