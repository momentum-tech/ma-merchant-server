

/*==============================================================*/
/* Table:t_plat_para    平台参数表  */
/*==============================================================*/
CREATE TABLE t_plat_para(
        plat_no         varchar(20) NOT NULL,
        plat_name           varchar(64) NULL,
        plat_stat           char(1) NULL,
        plat_date           char(8) NULL,
        pre_date            char(8) NULL,
        PRIMARY KEY ( plat_no )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

/*==============================================================*/
/* Table:t_svc_user    后台业务管理用户表  */
/*==============================================================*/
CREATE TABLE t_svc_user(
        user_id         varchar(32) NOT NULL,
        inst_id         varchar(32) NOT NULL,
        user_tel            varchar(20) NULL,
        user_pwd            varchar(32) NOT NULL,
        user_name           varchar(64) NULL,
        user_card_id            varchar(20) NULL,
        user_addr           varchar(200) NULL,
        email           varchar(64) NULL,
        role_info           varchar(1024) NOT NULL DEFAULT '2',
        status          char(1) NOT NULL DEFAULT '1',
        create_date         datetime NULL,
        PRIMARY KEY ( user_id ) ,
        FOREIGN KEY( inst_id ) REFERENCES YES
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_svc_user_uidx1 ON t_svc_user
(
        user_tel
);

/*==============================================================*/
/* Table:t_menu_group    菜单组管理  */
/*==============================================================*/
CREATE TABLE t_menu_group(
        rec_id          varchar(32) NOT NULL,
        name            varchar(128) NOT NULL,
        comments            varchar(128) NULL,
        image           varchar(1024) NULL,
        create_date         datetime NOT NULL,
        sequence            int NOT NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

/*==============================================================*/
/* Table:t_menu    菜单管理  */
/*==============================================================*/
CREATE TABLE t_menu(
        rec_id          varchar(32) NOT NULL,
        name            varchar(128) NOT NULL,
        identity            varchar(1024) NOT NULL,
        html            varchar(128) NOT NULL,
        menu_group_id           varchar(32) NOT NULL,
        create_date         datetime NOT NULL,
        sequence            int NOT NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

/*==============================================================*/
/* Table:t_role    角色管理  */
/*==============================================================*/
CREATE TABLE t_role(
        rec_id          varchar(32) NOT NULL,
        name            varchar(128) NOT NULL,
        platform            varchar(64) NOT NULL,
        create_date         datetime NOT NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

/*==============================================================*/
/* Table:t_role_menu_group    角色菜单组关系管理  */
/*==============================================================*/
CREATE TABLE t_role_menu_group(
        rec_id          varchar(32) NOT NULL,
        role_id         varchar(32) NOT NULL,
        menu_group_id           varchar(32) NOT NULL,
        create_date         datetime NOT NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

/*==============================================================*/
/* Table:t_attach    附件表  */
/*==============================================================*/
CREATE TABLE t_attach(
        rec_id          varchar(32) NOT NULL,
        master_id           varchar(32) NULL,
        seri_no         integer() NULL,
        type            char(2) NULL,
        name            varchar(256) NULL,
        attach_url          varchar(256) NULL,
        com_memo            varchar(1024) NULL,
        create_date         datetime NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_attach_uidx1 ON t_attach
(
        master_id,
        seri_no
);

/*==============================================================*/
/* Table:t_industry_code    行业编码表  */
/*==============================================================*/
CREATE TABLE t_industry_code(
        rec_id          varchar(32) NOT NULL,
        industry_code           varchar(6) NULL,
        industry            varchar(128) NULL,
        com_memo            varchar(1024) NULL,
        create_date         datetime NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_industry_code_uidx1 ON t_industry_code
(
        industry_code
);

/*==============================================================*/
/* Table:t_industry_code    行业编码表  */
/*==============================================================*/
CREATE TABLE t_industry_code(
        rec_id          varchar(32) NOT NULL,
        industry_code           varchar(6) NULL,
        industry            varchar(128) NULL,
        com_memo            varchar(1024) NULL,
        create_date         datetime NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_industry_code_uidx1 ON t_industry_code
(
        industry_code
);

/*==============================================================*/
/* Table:t_area_code    区域编码表  */
/*==============================================================*/
CREATE TABLE t_area_code(
        rec_id          varchar(32) NOT NULL,
        area_code           varchar(6) NOT NULL,
        industry            varchar(128) NOT NULL,
        level           varchar(2) NOT NULL,
        com_memo            varchar(1024) NULL,
        create_date         datetime NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_area_code_uidx1 ON t_area_code
(
        area_code
);

/*==============================================================*/
/* Table:t_area_code    区域编码表  */
/*==============================================================*/
CREATE TABLE t_area_code(
        rec_id          varchar(32) NOT NULL,
        area_code           varchar(6) NOT NULL,
        industry            varchar(128) NOT NULL,
        level           varchar(2) NOT NULL,
        com_memo            varchar(1024) NULL,
        create_date         datetime NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_area_code_uidx1 ON t_area_code
(
        area_code
);

/*==============================================================*/
/* Table:t_industry_code    行业编码表  */
/*==============================================================*/
CREATE TABLE t_industry_code(
        rec_id          varchar(32) NOT NULL,
        industry_code           varchar(6) NULL,
        industry            varchar(128) NULL,
        com_memo            varchar(1024) NULL,
        create_date         datetime NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_industry_code_uidx1 ON t_industry_code
(
        industry_code
);

/*==============================================================*/
/* Table:t_industry_code    行业编码表  */
/*==============================================================*/
CREATE TABLE t_industry_code(
        rec_id          varchar(32) NOT NULL,
        industry_code           varchar(6) NULL,
        industry            varchar(128) NULL,
        com_memo            varchar(1024) NULL,
        create_date         datetime NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_industry_code_uidx1 ON t_industry_code
(
        industry_code
);

/*==============================================================*/
/* Table:t_merchant    商户表  */
/*==============================================================*/
CREATE TABLE t_merchant(
        rec_id          varchar(32) NOT NULL,
        cpy_name            varchar(128) NULL,
        industry_code           varchar(6) NULL,
        area_code           varchar(6) NULL,
        category_code           varchar(6) NULL,
        cpy_legal_name          varchar(32) NULL,
        cpy_address         varchar(256) NULL,
        address_coor_x          decimal(16,4) NULL,
        address_coor_y          decimal(16,4) NULL,
        introduction            varchar(2048) NULL,
        special         varchar(2048) NULL,
        linkman         varchar(64) NULL,
        svr_tel         varchar(128) NULL,
        auth_step           varchar(2) NOT NULL DEFAULT '1',
        com_stat            varchar(2) NOT NULL DEFAULT '0',
        auth_reason         varchar(256) NULL,
        stat            cha(1) NULL,
        clr_act         varchar(64) NULL,
        com_memo            varchar(1024) NULL,
        create_date         datetime NULL,
        PRIMARY KEY ( rec_id )
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

/*==============================================================*/
/* Table:t_merchant_user    商户用户表  */
/*==============================================================*/
CREATE TABLE t_merchant_user(
        user_id         varchar(32) NOT NULL,
        merchant_id         varchar(32) NOT NULL,
        user_tel            varchar(20) NULL,
        user_pwd            varchar(32) NOT NULL,
        user_name           varchar(64) NULL,
        user_addr           varchar(200) NULL,
        email           varchar(64) NULL,
        role_info           varchar(1024) NOT NULL DEFAULT '2',
        status          char(1) NOT NULL DEFAULT '1',
        create_date         datetime NULL,
        PRIMARY KEY ( user_id ) ,
        FOREIGN KEY( merchant_id ) REFERENCES YES
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;

CREATE UNIQUE INDEX t_merchant_user_uidx1 ON t_merchant_user
(
        user_tel
);