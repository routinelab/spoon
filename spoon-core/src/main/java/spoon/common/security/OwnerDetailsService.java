package spoon.common.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spoon.domain.Owner;

public class OwnerDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Owner owner = new Owner("routine", "1111");
        if (owner == null)
            throw new UsernameNotFoundException("Owner Not Found!");
        return new OwnerDetails(owner);
    }
}
