package meelesh.polyMobileAppBackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@ToString
@NoArgsConstructor(force = true)
public class History {

    public History(@NonNull String username, @NonNull String expression) {
        this.username = username;
        this.expression = expression;
    }

    @Id
    @SequenceGenerator(name = "history_id_sequence", sequenceName = "history_id_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "history_id_sequence")
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String expression;

}
