package meelesh.polyMobileAppBackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import meelesh.polyMobileAppBackend.dto.DTO;
import meelesh.polyMobileAppBackend.dto.TokenDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LoginResponseDTO extends DTO {

    private String id;
    private String username;
    private TokenDTO token;

}
