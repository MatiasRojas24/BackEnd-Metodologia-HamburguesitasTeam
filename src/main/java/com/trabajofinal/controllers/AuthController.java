package com.trabajofinal.controllers;


import com.trabajofinal.models.AuthResponse;
import com.trabajofinal.models.LoginRequest;
import com.trabajofinal.models.RegisterRequest;
import com.trabajofinal.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "registerCliente")
    public ResponseEntity<AuthResponse> registerCliente(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerCliente(request));
    }
    @PostMapping(value = "registerAdmin")
    public ResponseEntity<AuthResponse> registerAdmin(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerAdmin(request));
    }

}
