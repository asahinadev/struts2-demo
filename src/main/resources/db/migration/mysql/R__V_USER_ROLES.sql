CREATE
OR REPLACE VIEW
   `v_user_roles`
(
   username,
   rolename
) AS
SELECT
   users.username as username,
   roles.name as rolename
FROM
   users
JOIN user_roles ON users.id = user_roles.user_id
JOIN roles ON roles.id = user_roles.role_id;