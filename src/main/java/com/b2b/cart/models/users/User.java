package com.b2b.cart.models.users;

import com.b2b.cart.models.AuditModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")// with progress user is keywordof
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends AuditModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    private Boolean enabled;
    private String firstName;
    private String lastName;

    @Column(name = "reset_token")
    private String resetToken;



    @Column(unique = true)
    private String email;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            , uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})}
    )
    private List<Role> roles;


}
