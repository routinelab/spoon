package spoon.common.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spoon.domain.Owner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OwnerDetails implements UserDetails {

    private static final long serialVersionUID = -6967645121954946663L;
    private Owner owner;
    private List<GrantedAuthority> authorities;

    public OwnerDetails(Owner owner) {
        this.owner = owner;
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(owner.getRole().toString()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return owner.getPassword();
    }

    @Override
    public String getUsername() {
        return owner.getUsername();
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
