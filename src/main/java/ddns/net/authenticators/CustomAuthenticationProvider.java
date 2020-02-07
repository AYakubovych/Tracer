package ddns.net.authenticators;

import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

            return new UsernamePasswordAuthenticationToken(
                    authentication.getName(),
                    authentication.getCredentials().toString(),
                    Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

    }


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
