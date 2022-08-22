CREATE TABLE TB_USER_ROLE(
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES TB_USER(id),
    FOREIGN KEY(role_id) REFERENCES TB_ROLE(id)
);

INSERT INTO TB_USER_ROLE (id, user_id, role_id) VALUES (-1, -1, -1)