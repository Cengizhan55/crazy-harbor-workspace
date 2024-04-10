package com.crazycoder.crazyharborbff.config.security.authentication;

import org.springframework.stereotype.Service;


@Service
public class HarborUserDetailService {

    /*
    private final HarborUserRepository repository;

    public HarborUserDetailService(HarborUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        HarborUserEntity harborUser = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found."));

        return new User(harborUser.getUsername(),harborUser.getPassword(),mapRolesToAuthorities(harborUser.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<HarborUserRoleEntity> roles){

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }

     */
}
