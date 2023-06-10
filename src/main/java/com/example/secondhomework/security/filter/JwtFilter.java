package com.example.secondhomework.security.filter;

import com.example.secondhomework.security.enums.UserRole;
import com.example.secondhomework.security.model.UserAccount;
import com.example.secondhomework.security.service.JwtProvider;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    private static final String AUTHORIZATION = "Authorization";

    private final JwtProvider jwtProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
            throws IOException, ServletException {
        final String token = getTokenFromRequest((HttpServletRequest) request);

        if (token != null && jwtProvider.validateAccessToken(token)) {
            final Claims claims = jwtProvider.getAccessClaims(token);
            final UserAccount jwtInfoToken = generate(claims);
            jwtInfoToken.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(jwtInfoToken);
        }
        fc.doFilter(request, response);

    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String bearer = request.getHeader(AUTHORIZATION);
        if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }

    private static UserAccount generate(Claims claims) {
        final UserAccount jwtInfoToken = new UserAccount();
        jwtInfoToken.setAuthorities(getRoles(claims));
        jwtInfoToken.setUsername(claims.getSubject());
        jwtInfoToken.setId(UUID.fromString(claims.get("id", String.class)));
        return jwtInfoToken;
    }

    private static Set<UserRole> getRoles(Claims claims) {
        final String role = claims.get("roles", String.class);
        return Set.of(UserRole.valueOf(role));
    }

}