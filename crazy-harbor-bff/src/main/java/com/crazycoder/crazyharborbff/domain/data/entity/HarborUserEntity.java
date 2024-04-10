package com.crazycoder.crazyharborbff.domain.data.entity;

import com.crazycoder.crazyharborbff.domain.data.common.Auditable;
import com.crazycoder.crazyharborbff.domain.data.common.BaseEntity;
import com.crazycoder.crazyharborbff.domain.data.enumeration.UserRole;
import com.crazycoder.crazyharborbff.domain.data.enumeration.converter.UserRoleConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "HARBOR_USER")
@Getter
@Setter
public class HarborUserEntity extends Auditable implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = -92006394064421144L;
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_HARBOR_USER")
    @SequenceGenerator(name = "SEQUENCE_HARBOR_USER", sequenceName = "SEQUENCE_HARBOR_USER", allocationSize = 1)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PROFILE_ICON_ID")
    private Integer profileIconId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "BIRTH_DATE")
    private String birthDate;


    /**
     * Default fetch types
     * OneToMany: LAZY
     * ManyToOne: EAGER
     * ManyToMany: LAZY
     * OneToOne: EAGER
     *
     * @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     * @JoinTable(name = "harbor_user_roles",
     * joinColumns = @JoinColumn(name = "harbor_user_id", referencedColumnName = "id"),
     * inverseJoinColumns = @JoinColumn(name = "harbor_role_id",referencedColumnName = "id"))
     * private List<HarborUserRoleEntity> roles = new ArrayList<>();
     */
    // @Convert(converter = UserRoleConverter.class)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "RELATED_POSTS")
    private List<String> relatedPosts;


    @Column(name = "CREATE_DATE")
    @CreatedDate
    private LocalDateTime createDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getUserRole().getRole()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
