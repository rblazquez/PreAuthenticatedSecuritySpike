package com.treexor.spike.demoHateoasSec.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class RequestHeaderAuthenticationDetailsSource extends WebAuthenticationDetailsSource {
    private static final String authorityHeader = "X-authority";

    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        String header = context.getHeader(authorityHeader);
        if (header != null) {
            authorities.add(new SimpleGrantedAuthority(header));
        }

        return new PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails(context, authorities);
    }
}
