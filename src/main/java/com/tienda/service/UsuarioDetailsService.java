package com.tienda.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/*UsuarioDetailsService: pueda enviarle al project config toda la INFO del usuario a ver si esa cuenta existe o no y poder acceder*/
public interface UsuarioDetailsService {

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException;

}
