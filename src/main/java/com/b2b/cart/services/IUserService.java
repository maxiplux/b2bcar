package com.b2b.cart.services;


import com.b2b.cart.models.users.User;

public interface IUserService {

    User findByUsername(String username);

    boolean existsByEmail(String username);

    Boolean existsByUsername(String username);

    User save(User user);
}
