package com.b2b.cart.models.corporate;

import com.b2b.cart.models.AuditModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Document
public class Department extends AuditModel {

    @Id
    private String deparmentId;

    private long seq;

    @NotBlank
    private String name;

    @NotBlank
    private Company company;

}
