#
# -- 创建设备表
# DROP TABLE IF EXISTS device_info;
# CREATE TABLE device_info (
#                              id BIGINT NOT NULL AUTO_INCREMENT COMMENT '设备 id（主键）',
#                              device_name VARCHAR(100) NOT NULL COMMENT '设备名称',
#                              device_mac VARCHAR(100) NOT NULL COMMENT '设备唯一 mac 地址',
#                              pat_id BIGINT NOT NULL COMMENT '设备所属患者 id（外键）',
#                              create_time DATETIME NOT NULL COMMENT '入网时间',
#                              update_time DATETIME COMMENT '更新时间',
#                              remark VARCHAR(30) COMMENT '备注',
#                              PRIMARY KEY (id),
#     -- 添加外键约束，关联患者信息表的 pat_id
#                              FOREIGN KEY (pat_id) REFERENCES patient_info(pat_id)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='设备信息表';

#
# DROP TABLE IF EXISTS basic_operation_info;
# -- 创建基础数据表
# CREATE TABLE basic_operation_info (
#                                       user_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '患者 id（主键）',
#                                       operation_time DATETIME NOT NULL COMMENT '手术时间',
#                                       ethnic_groups VARCHAR(30) NOT NULL COMMENT '民族',
#                                       height BIGINT COMMENT '身高',
#                                       weight BIGINT COMMENT '体重',
#                                       operation VARCHAR(30) NOT NULL COMMENT '手术类型',
#                                       age INT NOT NULL COMMENT '患者年龄',
#                                       smoking CHAR(1) NOT NULL COMMENT '是否抽烟（1 是，0 否）',
#                                       address VARCHAR(30) COMMENT '家庭住址',
#                                       pulse INT NOT NULL COMMENT '脉搏',
#                                       pain INT NOT NULL COMMENT '疼痛度',
#                                       sbp BIGINT NOT NULL COMMENT '收缩压',
#                                       dbp BIGINT NOT NULL COMMENT '舒张压',
#                                       swelling CHAR(1) NOT NULL COMMENT '是否肿胀(1 为是，0 为否)',
#                                       create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
#                                       update_time DATETIME COMMENT '更新时间',
#                                       remark VARCHAR(30) COMMENT '备注',
#                                       PRIMARY KEY (user_id)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='患者手术基础信息表';
# -- 屈膝度表
# DROP TABLE IF EXISTS knee_flexion;
# CREATE TABLE knee_flexion (
#                               id BIGINT NOT NULL AUTO_INCREMENT COMMENT '屈膝度 id（主键）',
#                               knee DECIMAL(4, 1) NOT NULL COMMENT '屈膝度',
#                               device_id BIGINT NOT NULL COMMENT '设备 id（外键）',
#                               user_id BIGINT NOT NULL COMMENT '设备所属患者 id（外键）',
#                               create_time DATETIME NOT NULL COMMENT '采集时间',
#                               remark VARCHAR(30) COMMENT '备注',
#                               PRIMARY KEY (id),
#                               FOREIGN KEY (device_id) REFERENCES device_info(id),
#                               FOREIGN KEY (user_id) REFERENCES patient_info(pat_id)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='患者康复训练屈膝度数据表';
#
# -- 温度表
# DROP TABLE IF EXISTS temperature;
# CREATE TABLE temperature (
#                              id BIGINT NOT NULL AUTO_INCREMENT COMMENT '温度 id（主键）',
#                              temperature DECIMAL(3, 1) NOT NULL COMMENT '温度',
#                              device_id BIGINT NOT NULL COMMENT '设备 id（外键）',
#                              user_id BIGINT NOT NULL COMMENT '设备所属患者 id（外键）',
#                              create_time DATETIME NOT NULL COMMENT '采集时间',
#                              remark VARCHAR(30) COMMENT '备注',
#                              PRIMARY KEY (id),
#                              FOREIGN KEY (device_id) REFERENCES device_info(id),
#                              FOREIGN KEY (user_id) REFERENCES patient_info(pat_id)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='患者康复训练创口温度数据表';
#
# -- 行走步数表
# DROP TABLE IF EXISTS walking_steps;
# CREATE TABLE walking_steps (
#                                walk_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '步数 id（主键）',
#                                walk INT NOT NULL COMMENT '步数',
#                                speed DECIMAL(4, 2) NOT NULL COMMENT '行走速度（m/s）',
#                                distance DECIMAL(4, 2) NOT NULL COMMENT '距离（m）',
#                                device_id BIGINT NOT NULL COMMENT '设备 id（外键）',
#                                user_id BIGINT NOT NULL COMMENT '设备所属患者 id（外键）',
#                                create_time DATETIME NOT NULL COMMENT '采集时间',
#                                remark VARCHAR(30) COMMENT '备注',
#                                PRIMARY KEY (walk_id),
#                                FOREIGN KEY (device_id) REFERENCES device_info(id),
#                                FOREIGN KEY (user_id) REFERENCES patient_info(pat_id)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='患者康复训练行走步数数据表';

# -- 症状描述表
# DROP TABLE IF EXISTS symptom_description;
# CREATE TABLE symptom_description (
#                                      symptom_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '症状 id（主键）',
#                                      symptom_content VARCHAR(300) NOT NULL COMMENT '症状描述',
#                                      user_id BIGINT NOT NULL COMMENT '患者 id（外键）',
#                                      create_time DATETIME NOT NULL COMMENT '上传时间',
#                                      PRIMARY KEY (symptom_id),
#                                      FOREIGN KEY (user_id) REFERENCES patient_info(pat_id)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='患者症状描述数据表';

# -- 整合数据表
# DROP TABLE IF EXISTS integrated_data;
# CREATE TABLE integrated_data (
#                                  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户 id（主键）',
#                                  `index` BIGINT NOT NULL COMMENT '编号',
#                                  name VARCHAR(300) COMMENT '患者姓名',
#                                  ethnic_groups VARCHAR(300) COMMENT '民族',
#                                  weight DECIMAL(5, 2) NOT NULL COMMENT '体重',
#                                  height DECIMAL(5, 2) NOT NULL COMMENT '身高',
#                                  gender VARCHAR(2) NOT NULL COMMENT '性别',
#                                  age BIGINT NOT NULL COMMENT '年龄',
#                                  opera_type VARCHAR(300) COMMENT '手术类型',
#                                  opera_time BIGINT COMMENT '手术天数',
#                                  smoking VARCHAR(2) NOT NULL COMMENT '是否抽烟',
#                                  temp DECIMAL(5, 2) NOT NULL COMMENT '体温',
#                                  temp_cut DECIMAL(5, 2) NOT NULL COMMENT '膝盖温度',
#                                  pulse BIGINT NOT NULL COMMENT '脉搏',
#                                  sbp BIGINT NOT NULL COMMENT '收缩压',
#                                  dbp BIGINT NOT NULL COMMENT '舒张压',
#                                  swelling VARCHAR(5) NOT NULL COMMENT '是否肿胀',
#                                  knee BIGINT NOT NULL COMMENT '屈膝度',
#                                  step BIGINT NOT NULL COMMENT '行走步数',
#                                  pain BIGINT NOT NULL COMMENT '疼痛度',
#                                  decri VARCHAR(300) NOT NULL COMMENT '症状描述',
#                                  predict_result BIGINT COMMENT '预测等级结果',
#                                  doctor_result BIGINT COMMENT '医生反馈等级结果',
#                                  create_time DATETIME NOT NULL COMMENT '创建时间',
#                                  update_time DATETIME COMMENT '更新时间',
#                                  PRIMARY KEY (id)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='整合数据表，用于模型训练数据提取';

# DROP TABLE IF EXISTS pat_doc_message;
# -- 创建留言表
# CREATE TABLE pat_doc_message (
#                                  user_id BIGINT NOT NULL COMMENT '患者 id（外键）',
#                                  doctor_id BIGINT NOT NULL COMMENT '医生 id（外键）',
#                                  content VARCHAR(200) NOT NULL COMMENT '留言内容',
#                                  content_type CHAR(1) NOT NULL COMMENT '留言类型',
#                                  status CHAR(1) NOT NULL DEFAULT '0' COMMENT '是否已读（1 已读，0 未读）',
#                                  FOREIGN KEY (user_id) REFERENCES patient_info(pat_id),
#                                  FOREIGN KEY (doctor_id) REFERENCES doc_info(user_id)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='患者和医生的留言信息表';
