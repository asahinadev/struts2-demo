CREATE TABLE `user_roles` ( 
    `user_id` INT NOT NULL COMMENT '識別番号(users)' ,
    `role_id` INT NOT NULL COMMENT '識別番号(roles)' ,
    
    PRIMARY KEY (`user_id`, `role_id`),
    
     CONSTRAINT `fk_user_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
     CONSTRAINT `fk_user_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE = InnoDB;


INSERT INTO `user_roles` (`user_id`, `role_id`) 
VALUES (1, 1), 
       (1, 2), 
       (2, 2);

CREATE VIEW `v_user_roles` (username, rolename) 
AS SELECT users.username as username, 
          roles.name     as rolename 
     FROM users 
     JOIN user_roles ON users.id = user_roles.user_id 
     JOIN roles      ON roles.id = user_roles.role_id;