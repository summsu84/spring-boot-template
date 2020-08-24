package com.teamjw.template.security.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamjw.template.security.domain.base.CommonDateEntity;
import com.teamjw.template.security.domain.base.EntityBase;
import com.teamjw.template.security.domain.imports.AccountAccessRepository;
import com.teamjw.template.security.domain.imports.AccountRepository;
import lombok.*;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
@Configurable
public class User extends EntityBase<User> implements UserDetails {

    private String uid;
    private String username;
    private String password;
    private String provider;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();


    @Column(unique = true, nullable = false)
    public String getUsername() {
        return this.username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return this.password;
    }

    // Repository Autowiring
    @Autowired
    private transient AccountAccessRepository accountAccessRepository;
    @Autowired
    private transient AccountRepository accountRepository;

    // command
    public AccountAccess createAccount(final String accountName) {
        // Account 생성
        final Account account = null;
        final AccountAccess accountAccess = new AccountAccess(this, true, account);
        return accountAccessRepository.save(accountAccess);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
