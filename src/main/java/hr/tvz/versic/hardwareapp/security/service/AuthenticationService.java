package hr.tvz.versic.hardwareapp.security.service;

import hr.tvz.versic.hardwareapp.security.command.LoginCommand;
import hr.tvz.versic.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
