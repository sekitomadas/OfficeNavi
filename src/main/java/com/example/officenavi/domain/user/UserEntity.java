package com.example.officenavi.domain.user;

import java.time.LocalDateTime;

/**
 * 従業員を表すドメインエンティティです。
 */
public class UserEntity {
    private Integer id;
    private String name;
    private String email;
    private String passwordHash;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /**
     * 一覧取得用途の従業員を生成します。
     *
     * @param name 従業員名
     * @param email メールアドレス
     */
    public UserEntity(String name, String email) {
        this(name, email, null);
    }

    /**
     * パスワードハッシュを含む従業員を生成します。
     *
     * @param name 従業員名
     * @param email メールアドレス
     * @param passwordHash パスワードハッシュ
     */
    public UserEntity(String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 従業員IDを取得します。
     *
     * @return 従業員ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 従業員IDを設定します。
     *
     * @param id 従業員ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 従業員名を取得します。
     *
     * @return 従業員名
     */
    public String getName() {
        return name;
    }

    /**
     * 従業員名を設定します。
     *
     * @param name 従業員名
     */
    public void setName(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * メールアドレスを取得します。
     *
     * @return メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * メールアドレスを設定します。
     *
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * パスワードハッシュを取得します。
     *
     * @return パスワードハッシュ
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * パスワードハッシュを設定します。
     *
     * @param passwordHash パスワードハッシュ
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * 作成日時を取得します。
     *
     * @return 作成日時
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * 作成日時を設定します。
     *
     * @param createdAt 作成日時
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 更新日時を設定します。
     *
     * @param updatedAt 更新日時
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
