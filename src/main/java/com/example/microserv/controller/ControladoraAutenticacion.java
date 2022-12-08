package com.example.microserv.controller;

import com.example.microserv.config.JwtUtils;
import com.example.microserv.entity.EntidadUsuario;
import com.example.microserv.entity.JwtRequest;
import com.example.microserv.entity.JwtResponse;
import com.example.microserv.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.security.Principal;

@RestController
@RequestMapping("/autenticacion")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControladoraAutenticacion {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl servicio;

    @PostMapping("/generartoken")
    public ResponseEntity<JwtResponse> generarToken(@RequestBody JwtRequest pJwtRequest)throws Exception{

        try{
            this.autenticar(pJwtRequest.getUsername(), pJwtRequest.getPassword());
            UserDetails userDetails = servicio.loadUserByUsername(pJwtRequest.getUsername());
            String token = jwtUtils.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));

        }catch(Exception e){
            throw new Exception("El usuario y/o contraseña son erroneas" + e.getMessage());
        }
    }



    public void autenticar (String username,String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("Usuario Desabilitado" + e.getMessage());
        }catch (BadCredentialsException be){
            throw new Exception("Credencial Erronea" + be.getMessage());
        }
    }

    @GetMapping("/usuariologueado")
    public EntidadUsuario obtenerUsuario(Principal pPrincipal){
        return (EntidadUsuario) servicio.loadUserByUsername(pPrincipal.getName());
    }
}
