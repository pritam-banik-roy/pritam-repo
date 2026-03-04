// package com.flightreservation.model;

// import javax.validation.constraints.Email;
// import javax.validation.constraints.NotEmpty;

// public class User {

//     private int id;

//     @Email(message = "Invalid Email Format")
//     @NotEmpty(message = "Email is required")
//     private String email;

//     @NotEmpty(message = "Password is required")
//     private String password;

//     @NotEmpty(message = "Role is required")
//     private String role;

//     public int getId() { return id; }
//     public void setId(int id) { this.id = id; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
// }


===================================================================================================================



//     package com.flightreservation.model;

// public class User {

//     private Long userId;
//     private String email;
//     private String password;
//     private String role;

//     public Long getUserId() {
//         return userId;
//     }

//     public void setUserId(Long userId) {
//         this.userId = userId;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getRole() {
//         return role;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }
// }


=======================================================================================================================================


package com.flightreservation.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    private Long userId;

    @NotEmpty(message = "Email is required")
    @Email(message = "Enter valid email format")
    private String email;

    // @NotEmpty(message = "Password is required")
    // @Size(min = 6, message = "Password must be at least 6 characters")
    // @Pattern(
    //     regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).+$",
    //     message = "Password must contain uppercase, lowercase, number and special symbol"
    // )
    // private String password;

    @NotBlank(message = "Password is required")
    @Pattern(
    regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{6,}$",
    message = "Password must be 6+ characters with uppercase, lowercase, number and special character"
    )
    private String password;

    @NotEmpty(message = "Please select a role!")
    private String role;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
