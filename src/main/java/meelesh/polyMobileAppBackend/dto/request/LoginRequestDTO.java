package meelesh.polyMobileAppBackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import meelesh.polyMobileAppBackend.dto.DTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LoginRequestDTO extends DTO {

    private String username;
    private String password;

}
