package script.db

databaseChangeLog(logicalFilePath: 'study_user.groovy') {
    changeSet(id: '2019-08-03-study_user', author: 'relaxingchu@qq.com') {
        createTable(tableName: "STUDY_USER") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', autoIncrement: true, remarks: '表ID，主键，供其他表做外键，unsigned bigint、单表时自增、步长为 1') {
                constraints(primaryKey: true, primaryKeyName: 'PK_IAM_USER')
            }
            column(name: 'LOGIN_NAME', type: 'VARCHAR(128)', remarks: '用户名') {
                constraints(nullable: false)
                constraints(unique: true, uniqueConstraintName: 'UK_IAM_USER_U1')
            }
            column(name: 'EMAIL', type: 'VARCHAR(128)', remarks: '电子邮箱地址') {
                constraints(nullable: false)
                constraints(unique: true, uniqueConstraintName: 'UK_IAM_USER_U2')
            }

            column(name: 'ORGANIZATION_ID', type: 'BIGINT UNSIGNED', remarks: '组织ID') {
                constraints(nullable: false)
            }
            column(name: 'HASH_PASSWORD', defaultValue: "12345678", type: 'VARCHAR(128)', remarks: 'Hash后的用户密码') {
                constraints(nullable: true)
            }
            column(name: 'REAL_NAME', type: 'VARCHAR(32)', remarks: '用户真实姓名')

            column(name: 'INTERNATIONAL_TEL_CODE', type: 'VARCHAR(16)', defaultValue: "+86", remarks: '国际电话区号。')

            column(name: 'PHONE', type: 'VARCHAR(32)', remarks: '手机号')

            column(name: 'IMAGE_URL', type: 'VARCHAR(255)', remarks: '用户头像地址')

            column(name: 'PROFILE_PHOTO', type: 'MEDIUMTEXT', remarks: '用户二进制头像')

            column(name: 'IS_ENABLED', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '用户是否启用。1启用，0未启用') {
                constraints(nullable: false)
            }

            column(name: 'IS_LDAP', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '是否是LDAP来源。1是，0不是')

            column(name: 'LANGUAGE', type: 'VARCHAR(16)', defaultValue: "zh_CN", remarks: '语言') {
                constraints(nullable: false)
            }

            column(name: 'TIME_ZONE', type: 'VARCHAR(16)', defaultValue: "CTT", remarks: '时区') {
                constraints(nullable: false)
            }

            column(name: 'LAST_PASSWORD_UPDATED_AT', type: 'DATETIME', defaultValueComputed: "CURRENT_TIMESTAMP", remarks: '上一次密码更新时间') {
                constraints(nullable: false)
            }

            column(name: 'LAST_LOGIN_AT', type: 'DATETIME', remarks: '上一次登陆时间')

            column(name: 'IS_LOCKED', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '是否锁定账户') {
                constraints(nullable: false)
            }

            column(name: 'LOCKED_UNTIL_AT', type: 'DATETIME', remarks: '锁定账户截止时间')

            column(name: 'PASSWORD_ATTEMPT', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '密码输错累积次数')

            column(name: 'IS_ADMIN', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '是否为管理员用户。1表示是，0表示不是')

            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT UNSIGNED", defaultValue: "1") {
                constraints(nullable: true)
            }
            column(name: "CREATED_BY", type: "BIGINT UNSIGNED", defaultValue: "0") {
                constraints(nullable: true)
            }
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")

            column(name: "LAST_UPDATED_BY", type: "BIGINT UNSIGNED", defaultValue: "0") {
                constraints(nullable: true)
            }

            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }

    changeSet(author: 'relaxingchu@qq.com', id: '2019-08-03-study_user-remark') {
        setTableRemarks(tableName:"STUDY_USER",remarks: "用户表")
    }
}