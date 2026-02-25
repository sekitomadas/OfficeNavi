package com.example.officenavi.repository;

import com.example.officenavi.domain.user.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

	private static final RowMapper<UserEntity> USER_ROW_MAPPER = (rs, rowNum) -> {
		UserEntity entity = new UserEntity(
				rs.getString("name"),
				rs.getString("email"),
				rs.getString("password_hash")
		);
		entity.setId(rs.getInt("id"));
		entity.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
		entity.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
		return entity;
	};

	private final JdbcTemplate jdbcTemplate;

	public UserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<UserEntity> findAll() {
		String sql = """
				SELECT id, name, email, password_hash, created_at, updated_at
				FROM users
				ORDER BY id ASC
				""";
		return jdbcTemplate.query(sql, USER_ROW_MAPPER);
	}
}
