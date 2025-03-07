package meelesh.polyMobileAppBackend.entity;


import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public abstract class CustomUserDetails implements UserDetails {

    private Long id;

}
