package hr.tvz.versic.hardwareapp.security.service;

import hr.tvz.versic.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
