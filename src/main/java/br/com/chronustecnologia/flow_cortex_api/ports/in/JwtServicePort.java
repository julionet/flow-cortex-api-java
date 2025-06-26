package br.com.chronustecnologia.flow_cortex_api.ports.in;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface JwtServicePort {
    String getUsernameFromToken(String token);
    String getClientIdFromToken(String token);
    Date getExpirationDateFromToken(String token);
    Boolean validateToken(String token, UserDetails userDetails);
    boolean validateClientToken(String token, String expectedClientId);
    String getScope(String token);
}
