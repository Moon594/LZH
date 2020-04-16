# 数据库如果存在就删除
drop database if exists `lzh`;

#创建数据库
CREATE database lzh;

#创建用户表
create table users
(
    user_id       int auto_increment primary key COMMENT '用户ID',
    user_name     varchar(50) not null COMMENT '昵称',
    user_tel      varchar(50) not null unique COMMENT '电话号码',
    user_password varchar(50) not null COMMENT '密码',
    user_sex      varchar(10) not null COMMENT '性别',
    user_age      int         not null COMMENT '年龄',
    user_photo    varchar(100) COMMENT '头像',
    user_sign     varchar(255) default '' COMMENT '个性签名'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户信息表';

#图片表
CREATE table photo
(
    photo_id    int not null primary key COMMENT '图片ID',
    user_id     int not null,
    photo_path  varchar(100) COMMENT '图片路径',
    photo_group varchar(10) COMMENT '图片组数'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='图片路径表';