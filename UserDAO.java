public interface UserDAO {
    void saveUser(User user);
    User login(String email, String password);
}
