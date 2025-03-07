package meelesh.polyMobileAppBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TokenRefreshDTO extends DTO {

    private String userId;
    private String refreshToken;

}
