package kr.co.cofile.fruitshop.backend.fruit_shop_backend.dto;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

// Data is like having implicit @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations on the class (except that no constructor will be generated if any explicitly written constructors already exist).
@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private boolean enabled;
    private LocalDate created_at;
    private LocalDate updated_at;
    //	private String role;
    private List<RoleDTO> roles;
}
