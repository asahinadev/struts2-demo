CREATE TABLE `users` (
    `id`       INT NOT NULL AUTO_INCREMENT                                          COMMENT '識別番号' ,
    `username` VARCHAR(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL COMMENT 'アカウント' ,
    `password` VARCHAR(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL COMMENT 'パスワード' ,
    PRIMARY KEY (`id`),
    UNIQUE `users_username` (`username`)
) ENGINE = InnoDB;


INSERT INTO `users` (`id`, `username`, `password`) 
VALUES (NULL, 'system', 'password'), 
       (NULL, 'user'  , 'password');
