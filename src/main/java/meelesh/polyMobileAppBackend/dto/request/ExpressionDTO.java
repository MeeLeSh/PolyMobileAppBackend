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
public class ExpressionDTO extends DTO {

    private String expression;

}
