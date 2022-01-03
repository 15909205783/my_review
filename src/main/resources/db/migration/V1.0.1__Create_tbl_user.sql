CREATE TABLE `user` (
                        `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
                        `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
                        `pass_word` varchar(32) NOT NULL DEFAULT '' COMMENT '更新用户名',
                        `is_del` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0否 1是',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户表'