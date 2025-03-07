package meelesh.polyMobileAppBackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import meelesh.polyMobileAppBackend.dto.DTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RegisterRequestDTO extends DTO {

    private String username;
    private String password;

}
