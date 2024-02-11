package com.rami.toumi.sprinauthkit.security;

import com.rami.toumi.sprinauthkit.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserDetailsImpl implements UserDetails {

    private User user;
    public UserDetailsImpl(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        /*
            ADD FOR THE PERSMISSIONS
        */
        this.user.getPermissionsList().forEach( p -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p);
            authorities.add(grantedAuthority);

        });
        /*
         * Add the role for the list of autorities.
         * */
        this.user.getRolesList().forEach( p-> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + p);
            authorities.add(grantedAuthority);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
        return this.user.isEnabled();
    }
}
