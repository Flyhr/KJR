-- 创建医生表（已存在则删除重建）
DROP TABLE IF EXISTS doc_info;
CREATE TABLE doc_info (
                          user_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户 id（主键）',
                          user_name VARCHAR(30) NOT NULL COMMENT '医生真实姓名',
                          nick_name VARCHAR(30) NOT NULL COMMENT '医生昵称',
                          phone_number VARCHAR(30) NOT NULL COMMENT '电话号码',
                          password VARCHAR(100) NOT NULL COMMENT '登录密码',
                          role_id VARCHAR(30) NOT NULL COMMENT '所属角色id',
                          dept_id BIGINT(20) DEFAULT NULL COMMENT '部门ID',
                          data_scope CHAR(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
                          sex CHAR(1) COMMENT '医生性别（0 男，1 女，2 未知）',
                          email VARCHAR(30) COMMENT '用户邮箱',
                          speciality VARCHAR(200) NOT NULL COMMENT '医生擅长领域',
                          update_time DATETIME COMMENT '更新时间',
                          create_time DATETIME NOT NULL COMMENT '创建时间',
                          del_flag CHAR(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                          avatar VARCHAR(100) COMMENT '用户头像地址',
                          remark VARCHAR(30) COMMENT '备注',
                          login_date DATETIME COMMENT '最近一次登录时间',
                          status CHAR(1) COMMENT '账号状态（0 正常 ，1 停用）',
                          PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='医生信息表';

-- 创建患者表（已存在则删除重建）
DROP TABLE IF EXISTS patient_info;
CREATE TABLE patient_info (
                              pat_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户 id（主键）',
                              user_name VARCHAR(30) NOT NULL COMMENT '用户姓名',
                              nick_name VARCHAR(30) NOT NULL COMMENT '用户昵称',
                              phone_number VARCHAR(30) NOT NULL COMMENT '电话号码',
                              password VARCHAR(100) NOT NULL COMMENT '登录密码',
                              sex CHAR(1) COMMENT '用户性别（0 男，1 女，2 未知）',
                              email VARCHAR(30) COMMENT '用户邮箱',
                              update_time DATETIME COMMENT '更新时间',
                              create_time DATETIME NOT NULL COMMENT '创建时间',
                              del_flag CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标志，0为未删除，1为删除',
                              avatar VARCHAR(100) COMMENT '用户头像地址',
                              remark VARCHAR(30) COMMENT '备注',
                              login_date DATETIME COMMENT '最近一次登录时间',
                              status CHAR(1) NOT NULL COMMENT '账号状态（0 正常，1 停用）',
                              PRIMARY KEY (pat_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='患者信息表';

-- 添加医生患者关系表
CREATE TABLE doctor_patient_relation (
                                         id BIGINT NOT NULL AUTO_INCREMENT COMMENT '关系ID（主键）',
                                         doc_id BIGINT NOT NULL COMMENT '医生ID（外键）',
                                         pat_id BIGINT NOT NULL COMMENT '患者ID（外键）',
                                         create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '关系建立时间',
                                         PRIMARY KEY (id),
                                         UNIQUE KEY unique_patient (pat_id),  -- 确保每个患者只能有一个主治医生
                                         FOREIGN KEY (doc_id) REFERENCES doc_info(user_id),
                                         FOREIGN KEY (pat_id) REFERENCES patient_info(pat_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医生患者关系表';
