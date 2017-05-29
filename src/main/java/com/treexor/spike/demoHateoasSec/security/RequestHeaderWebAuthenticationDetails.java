package com.treexor.spike.demoHateoasSec.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

public class RequestHeaderWebAuthenticationDetails extends WebAuthenticationDetails implements GrantedAuthoritiesContainer {
    private Collection<SimpleGrantedAuthority> grantedAuthorities;
    private static final String authorityHeader = "X-authority";

    public RequestHeaderWebAuthenticationDetails(HttpServletRequest context) {
        super(context);
        grantedAuthorities = new ArrayList<>();
        String header = context.getHeader(authorityHeader);
        if (header != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority(header));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RequestHeaderWebAuthenticationDetails that = (RequestHeaderWebAuthenticationDetails) o;

        return grantedAuthorities != null ? grantedAuthorities.equals(that.grantedAuthorities) : that.grantedAuthorities == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (grantedAuthorities != null ? grantedAuthorities.hashCode() : 0);
        return result;
    }
}
