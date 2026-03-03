@Repository
public class FlightDAOImpl implements FlightDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Flight> searchFlights(String source, String destination) {

        String sql = "SELECT * FROM flights WHERE source=? AND destination=?";

        return jdbcTemplate.query(sql,
                new Object[]{source, destination},
                new BeanPropertyRowMapper<>(Flight.class));
    }
}
