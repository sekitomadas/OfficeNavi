package com.example.officenavi.repository;

import com.example.officenavi.domain.user.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 従業員情報のデータアクセスを担当するリポジトリです。
 */
@Repository
public class UserRepository {

	private static final RowMapper<UserEntity> USER_ROW_MAPPER = (rs, rowNum) -> {
		UserEntity entity = new UserEntity(
				rs.getString("name"),
				rs.getString("email")
		);
		entity.setId(rs.getInt("id"));
		entity.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
		entity.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
		return entity;
	};

	private final NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * コンストラクタインジェクションで NamedParameterJdbcTemplate を受け取ります。
	 *
	 * @param jdbcTemplate JDBC操作を行うテンプレート
	 */
	public UserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * users テーブルから従業員一覧を取得します。
	 *
	 * @return 従業員エンティティ一覧
	 */
	public List<UserEntity> findAll() {
		String sql = """
				SELECT id, name, email, created_at, updated_at
				FROM users
				ORDER BY id ASC
				""";
		return jdbcTemplate.query(sql, USER_ROW_MAPPER);
	}

	/**
	 * users テーブルに従業員を登録します。
	 *
	 * @param user 登録する従業員エンティティ（passwordHash を含む）
	 * @return 登録後の従業員エンティティ
	 */
	public UserEntity registerUser(UserEntity user) {
		String sql = """
				INSERT INTO users (name, email, password_hash, created_at, updated_at)
				VALUES (:name, :email, :password, NOW(), NOW())
				RETURNING id, name, email, created_at, updated_at
				""";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", user.getName())
				.addValue("email", user.getEmail())
				.addValue("password", user.getPasswordHash());
		return jdbcTemplate.queryForObject(sql, param, USER_ROW_MAPPER);
	}
}
