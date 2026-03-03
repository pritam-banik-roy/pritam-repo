import javax.validation.constraints.*;

public class User {

    private int id;

    @NotEmpty(message="Email is required")
    @Email(message="Invalid email format")
    private String email;

    @NotEmpty(message="Password is required")
    private String password;

    @NotEmpty(message="Role is required")
    private String role;

    // getters & setters
}
