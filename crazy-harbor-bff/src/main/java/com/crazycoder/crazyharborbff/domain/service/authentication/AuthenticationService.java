package com.crazycoder.crazyharborbff.domain.service.authentication;


import com.crazycoder.crazyharborbff.config.security.jwt.JwtService;
import com.crazycoder.crazyharborbff.controller.authentication.model.JwtAuthenticationRequest;
import com.crazycoder.crazyharborbff.controller.authentication.model.JwtAuthenticationResponse;
import com.crazycoder.crazyharborbff.controller.authentication.model.JwtRegisterRequest;
import com.crazycoder.crazyharborbff.domain.data.entity.HarborUserEntity;
import com.crazycoder.crazyharborbff.domain.data.enumeration.UserRole;
import com.crazycoder.crazyharborbff.domain.repository.HarborUserRepository;

import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional(value = Transactional.TxType.REQUIRED)
public class AuthenticationService {


    private final HarborUserRepository harborUserRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(HarborUserRepository harborUserRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.harborUserRepository = harborUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public JwtAuthenticationResponse register(JwtRegisterRequest request) {

        HarborUserEntity harborUser = new HarborUserEntity();
        harborUser.setFirstName(request.getFirstname());
        harborUser.setLastName(request.getLastname());
        harborUser.setUsername(request.getUsername());
        harborUser.setPassword(passwordEncoder.encode(request.getPassword()));
        harborUser.setUserRole(UserRole.USER);

        harborUserRepository.save(harborUser);

        var jwtToken = jwtService.generateToken(harborUser);

        return JwtAuthenticationResponse.builder().token(jwtToken).build();

    }

    public JwtAuthenticationResponse authenticate(JwtAuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = harborUserRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return JwtAuthenticationResponse.builder().token(jwtToken).build();
    }


}
