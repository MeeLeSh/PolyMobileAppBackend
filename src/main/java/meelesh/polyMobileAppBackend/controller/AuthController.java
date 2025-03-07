package meelesh.polyMobileAppBackend.controller;

import lombok.extern.slf4j.Slf4j;
import meelesh.polyMobileAppBackend.dto.AuthenticationDTO;
import meelesh.polyMobileAppBackend.dto.TokenRefreshDTO;
import meelesh.polyMobileAppBackend.dto.request.LoginRequestDTO;
import meelesh.polyMobileAppBackend.dto.request.RegisterRequestDTO;
import meelesh.polyMobileAppBackend.entity.AuthUser;
import meelesh.polyMobileAppBackend.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class AuthController {

    MainUserService mainUserService;

    @Autowired
    public AuthController(MainUserService mainUserService) {
        this.mainUserService = mainUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        AuthUser authUser = new AuthUser(registerRequestDTO.getUsername(), registerRequestDTO.getPassword());
        return mainUserService.createUser(authUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return mainUserService.loginUser(loginRequestDTO);
    }

    @GetMapping("/delete/{password}")
    // задать jwt токен, чтобы получить User's Principal
    public ResponseEntity<String> delete(@AuthenticationPrincipal AuthUser user, @PathVariable String password) {
        return mainUserService.deleteUser(user, password);
    }

    @PostMapping("/token/refresh")
    public ResponseEntity<String> token(@RequestBody TokenRefreshDTO tokenDTO) {
        return mainUserService.refreshToken(tokenDTO);
    }

    @GetMapping("/token/validate")
    public ResponseEntity<AuthenticationDTO> validateToken(Authentication authentication) {

        if (authentication == null) return new ResponseEntity<>(new AuthenticationDTO(null, null, "anonymous", "false"), HttpStatusCode.valueOf(401));

        AuthUser userDetails = (AuthUser) authentication.getPrincipal();
        Long id = userDetails.getId();
        String username = mainUserService.getUsernameById(id);
        return ResponseEntity.ok(new AuthenticationDTO(id, username, "USER", "true"));
    }

}
