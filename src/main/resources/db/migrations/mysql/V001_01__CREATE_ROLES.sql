CREATE TABLE `roles` (
    `id`   INT NOT NULL AUTO_INCREMENT                                          COMMENT '識別番号' ,
    `name` VARCHAR(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL COMMENT 'ロール' ,

    PRIMARY KEY (`id`),
    UNIQUE `roles_name` (`name`)
) ENGINE = InnoDB;

INSERT INTO `roles` (`id`, `name`) 
VALUES (NULL, 'system'), 
       (NULL, 'user'  );

