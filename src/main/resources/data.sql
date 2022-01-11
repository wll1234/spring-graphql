CREATE TABLE member (
    id int primary key ,
    login_id varchar,
    password varchar,
    name varchar
);
CREATE TABLE role (
                        id int primary key ,
                        member_id varchar,
                        role varchar
);

INSERT INTO member (id, login_id, password, name) VALUES
                                                      (1, 'member', 'password', '멤버'),
                                                      (2, 'account', 'password', '계정'),
                                                      (3, 'user', 'password', '사용자');

INSERT INTO role (id, member_id, role) VALUES
                                           (1, 1, 'ROLE_ADMIN'),
                                           (2, 1, 'ROLE_MEMBER'),
                                           (3, 2, 'ROLE_MEMBER'),
                                           (4, 3, 'ROLE_MANAGER');
SELECT * from member;
select * from role;