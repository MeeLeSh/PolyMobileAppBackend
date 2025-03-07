package meelesh.polyMobileAppBackend.controller;

import lombok.extern.slf4j.Slf4j;
import meelesh.polyMobileAppBackend.dto.AuthenticationDTO;
import meelesh.polyMobileAppBackend.dto.request.ExpressionDTO;
import meelesh.polyMobileAppBackend.entity.AuthUser;
import meelesh.polyMobileAppBackend.entity.History;
import meelesh.polyMobileAppBackend.service.CalculatorService;
import meelesh.polyMobileAppBackend.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final MainUserService mainUserService;
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(MainUserService mainUserService, CalculatorService calculatorService) {
        this.mainUserService = mainUserService;
        this.calculatorService = calculatorService;
    }

    @PostMapping("/save/history")
    public ResponseEntity<String> saveHistory(@RequestBody ExpressionDTO expression, Authentication authentication) {
        if (authentication == null)
            return new ResponseEntity<>(new AuthenticationDTO(null, null, "anonymous", "false")
                    .toJson(), HttpStatusCode.valueOf(401));

        AuthUser userDetails = (AuthUser) authentication.getPrincipal();
        Long id = userDetails.getId();
        String username = mainUserService.getUsernameById(id);
        calculatorService.saveHistory(username, expression);
        return new ResponseEntity<>("{\"description\" : \"expression saved\"}", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/history")
    public ResponseEntity<List<History>> getHistory(Authentication authentication) {
        if (authentication == null)
            return new ResponseEntity<>(Collections.emptyList(), HttpStatusCode.valueOf(401));

        AuthUser userDetails = (AuthUser) authentication.getPrincipal();
        Long id = userDetails.getId();
        String username = mainUserService.getUsernameById(id);
        return new ResponseEntity<>(calculatorService.getHistory(username), HttpStatusCode.valueOf(200));
    }

}
