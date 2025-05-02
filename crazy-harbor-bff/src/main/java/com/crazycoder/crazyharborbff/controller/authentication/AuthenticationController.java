package com.crazycoder.crazyharborbff.controller.authentication;


import com.crazycoder.crazyharborbff.controller.authentication.model.JwtAuthenticationRequest;
import com.crazycoder.crazyharborbff.controller.authentication.model.JwtAuthenticationResponse;
import com.crazycoder.crazyharborbff.controller.authentication.model.JwtRegisterRequest;
import com.crazycoder.crazyharborbff.domain.service.authentication.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody JwtRegisterRequest request){

        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> authentication(@RequestBody JwtAuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }






















/*

    private final AuthenticationManager authenticationManager;
    private final HarborUserRepository harborUserRepository;
    private final HarborUserRoleRepository harborUserRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationManager authenticationManager, HarborUserRepository harborUserRepository, HarborUserRoleRepository harborUserRoleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.harborUserRepository = harborUserRepository;
        this.harborUserRoleRepository = harborUserRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        if (harborUserRepository.existsByUsername(request.getUsername())) {
            return new ResponseEntity<>("username is taken", HttpStatus.BAD_REQUEST);
        }

        HarborUserEntity user = new HarborUserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HarborUserRoleEntity roles = harborUserRoleRepository.findByName("ADMIN").get();
        user.setRoles(Collections.singletonList(roles));

        harborUserRepository.save(user);

        return new ResponseEntity<>("user registered success ! ", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("successfully logged in.");

    }

 */


}
