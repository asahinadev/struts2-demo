CREATE TABLE `genders` (
    `id`   INT                                                         NOT NULL COMMENT '識別番号' ,
    `name` VARCHAR(255) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL COMMENT '性別' ,

    PRIMARY KEY (`id`),
    UNIQUE `gender_name` (`name`)
) ENGINE = InnoDB;

INSERT INTO `genders` (`id`, `name`) 
VALUES 
	(0, 'not known'     ), 
    (1, 'male'          ), 
    (2, 'female'        ), 
    (9, 'not applicable');

