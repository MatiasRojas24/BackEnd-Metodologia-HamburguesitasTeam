package com.trabajofinal.controllers;


import com.trabajofinal.models.AuthResponse;
import com.trabajofinal.models.LoginRequest;
import com.trabajofinal.models.RegisterRequest;
import com.trabajofinal.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/validarToken")
    public ResponseEntity<Boolean> validateToken(@RequestParam("token") String token) {
        if (token == null || token.isEmpty()) {
            return ResponseEntity.ok(false);
        }

        boolean esValido = authService.validarToken(token);
        return ResponseEntity.ok(esValido);
    }

}
