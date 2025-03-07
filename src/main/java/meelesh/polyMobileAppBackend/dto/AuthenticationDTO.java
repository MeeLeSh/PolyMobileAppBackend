package meelesh.polyMobileAppBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationDTO extends DTO {

    private Long id;
    private String username;
    private String role;
    private String success;

}