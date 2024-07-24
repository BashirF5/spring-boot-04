package az.edu.turing.az.springboot04jdbc_template.dao;

import az.edu.turing.az.springboot04jdbc_template.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class ProfileDaoImpl implements ProfileDao {

    private final JdbcTemplate jdbcTemplate;

    public ProfileDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Profile> profileRowMapper = (rs, rowNum) -> {
        Profile profile = new Profile();
        profile.setId((UUID) rs.getObject("id"));
        profile.setUsername(rs.getString("username"));
        profile.setAge(rs.getInt("age"));
        profile.setCreated(rs.getDate("created"));
        profile.setUpdated(rs.getDate("updated"));
        profile.setProfilePhoto(rs.getBytes("profile_photo"));
        return profile;
    };

    @Override
    public void createProfile(Profile profile) {
        String sql = "INSERT INTO profiles (id, username, age, created, updated, profile_photo) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, profile.getId(), profile.getUsername(), profile.getAge(),
                new java.sql.Date(profile.getCreated().getTime()),
                new java.sql.Date(profile.getUpdated().getTime()),
                profile.getProfilePhoto());
    }

    @Override
    public List<Profile> getProfiles() {
        String sql = "SELECT * FROM profiles";
        return jdbcTemplate.query(sql, profileRowMapper);
    }

    @Override
    public Profile getProfileById(UUID id) {
        String sql = "SELECT * FROM profiles WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, profileRowMapper);
    }

    @Override
    public void updateProfile(Profile profile) {
        String sql = "UPDATE profiles SET username = ?, age = ?, created = ?, updated = ?, profile_photo = ? WHERE id = ?";
        jdbcTemplate.update(sql, profile.getUsername(), profile.getAge(),
                new java.sql.Date(profile.getCreated().getTime()),
                new java.sql.Date(profile.getUpdated().getTime()),
                profile.getProfilePhoto(), profile.getId());
    }

    @Override
    public void deleteAllProfiles() {
        String sql = "DELETE FROM profiles";
        jdbcTemplate.update(sql);
    }

    @Override
    public int getProfileCount() {
        String sql = "SELECT COUNT(*) FROM profiles";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
