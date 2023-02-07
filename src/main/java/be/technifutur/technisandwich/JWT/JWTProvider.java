package be.technifutur.technisandwich.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class JWTProvider {

    private final UserDetailsService service;

    public JWTProvider(UserDetailsService service) {
        this.service = service;
    }


    public String createToken(Authentication auth) {


        Date issuedAt = new Date();
        Date expiresAt = new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000));

        try {
            return JWT.create()
                    .withSubject(auth.getName())
                    .withExpiresAt(expiresAt)
                    .withIssuedAt(issuedAt)
                    .sign(Algorithm.HMAC512("m4st3cl4$$"));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Internal error", ex);

        }
    }

    public boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512("m4st3cl4$$")).acceptExpiresAt(24 * 60 * 60 * 1000)
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return true;
        } catch (JWTVerificationException ex) {
            return false;
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Internal error", ex);
        }

    }

    public Authentication generateAuth(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getSubject();
        UserDetails userDetails = service.loadUserByUsername(username);
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
        return auth;
    }
}
