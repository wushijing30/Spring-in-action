package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wusj on 2017/12/10.
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcOperations jbdc;

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jbdc){
        this.jbdc = jbdc;
    }
    public Spitter save(Spitter spitter) {
        jbdc.update(
                "INSERT  INTO Spitter (username, password, first_name, last_name, email)" +
                  "VALUES (?, ?, ?, ?, ?)" ,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail()
        );
        return spitter; //TODO: Determine value for id
    }

    public Spitter findByUsername(String username) {
        return jbdc.queryForObject("select id, username, null, first_name, last_name, email from Spitter where username=?",
                new SpitterRowMapper(),
                username);
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    null,
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"));
        }
    }
}
