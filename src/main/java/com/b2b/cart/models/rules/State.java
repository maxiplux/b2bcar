package com.b2b.cart.models.rules;

import com.b2b.cart.models.AuditModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class State extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;


    private Integer order;

    @JoinTable(name = "states_rules", joinColumns = {
            @JoinColumn(name = "current", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "next", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Set<State> nextStates;

    private Boolean sendEmilToAdmin;
    private Boolean sendEmilToClient;
    private Boolean sendEmilToClientUser;
    private Boolean sendEmilToStaff;


}

