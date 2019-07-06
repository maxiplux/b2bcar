package com.b2b.cart.models.workflow;

import com.b2b.cart.models.AuditModel;
import com.b2b.cart.models.corporate.Company;
import com.b2b.cart.models.users.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Set;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Document
public class WorkFlow extends AuditModel {

    @Id
    private String workFlowId;

    @NotBlank
    private String name;


    private Long seq;

    @NotBlank
    private Company company;

    @Size(min = 1, max = 5, message = "The max number of steps is between 1 and 5")
    private Integer steps;


    private HashMap<Integer, Set<User>> approvers; // each step implies a new User

}
