package md.utm.fcim.parking_monolith.business.impl;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by veladii on 8/30/17.
 */
@Component
public class TokenHandler {

    private SecretKey secretKey;

    private String bearer = "Bearer ";

    public TokenHandler() {
        String jwtKey = "jwt123456789";
        byte[] decode = BaseEncoding.base64().decode(jwtKey);
        this.secretKey = new SecretKeySpec(decode, 0, decode.length, "AES");
    }

    Optional<String> extractUserName(String token) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token.replaceAll(bearer, ""));
        Claims body = claimsJws.getBody();
        return Optional
                .ofNullable(body.get("username", String.class))
                .map(String::new);

    }

    Optional<String> generateAccessToken(String username, LocalDateTime localDateTime) {
        return Optional.ofNullable(Jwts.builder()
                .setClaims(generateMapFromString(username))
                .setExpiration(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact());
    }

    private Map<String, Object> generateMapFromString(String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        return map;
    }
}
