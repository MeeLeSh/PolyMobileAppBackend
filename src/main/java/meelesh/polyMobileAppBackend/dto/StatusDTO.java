package meelesh.polyMobileAppBackend.dto;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StatusDTO extends DTO {

    private int code;
    private String description;

}
