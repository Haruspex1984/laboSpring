package be.technifutur.technisandwich.JWT;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTProvider jwtProvider;

    public JWTAuthenticationFilter(JWTProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String suffix = "Bearer ";
        String token;
        if (authHeader != null && authHeader
                .startsWith(suffix) && jwtProvider
                .validateToken(token = authHeader
                        .replace(suffix, ""))) {


            Authentication auth = jwtProvider.generateAuth(token);
            SecurityContextHolder.getContext().setAuthentication(auth);

        }
//        else {
//            Authentication auth = jwtProvider.generateAuth("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjc1ODY5OTE3LCJpYXQiOjE2NzU3ODM1MTd9.M3_ID3e1HuAaEqBB7fiSoIsHOBhyYPe046ITizroHpJn2GLYbdQchyms5SSwLlHfLahvd72H_FNyXO4dWIHVXA");
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        }
        filterChain.doFilter(request, response);
    }
}
