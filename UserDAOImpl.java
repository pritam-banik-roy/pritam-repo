@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(User user) {

        String sql = "INSERT INTO users(email,password,role) VALUES(?,?,?)";

        jdbcTemplate.update(sql,
                user.getEmail(),
                user.getPassword(),
                user.getRole());
    }

    @Override
    public User login(String email, String password) {

        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        List<User> users = jdbcTemplate.query(sql,
                new Object[]{email, password},
                new BeanPropertyRowMapper<>(User.class));

        return users.isEmpty() ? null : users.get(0);
    }
}
