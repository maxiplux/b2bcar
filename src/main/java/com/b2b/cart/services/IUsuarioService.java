package com.b2b.cart.services;


import com.b2b.cart.models.users.Usuario;

public interface IUsuarioService {

    Usuario findByUsername(String username);
}
