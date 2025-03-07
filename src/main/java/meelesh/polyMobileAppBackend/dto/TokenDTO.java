package meelesh.polyMobileAppBackend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class TokenDTO extends DTO {

    private String userId;
    private String accessToken;
    private String refreshToken;

}
