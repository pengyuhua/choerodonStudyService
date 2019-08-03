package script.db

databaseChangeLog(logicalFilePath: 'study_organization.groovy') {
    changeSet(id: '2019-08-03-study_organization', author: 'relaxingchu@qq.com') {
        createTable(tableName: "STUDY_ORGANIZATION") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', autoIncrement: true, remarks: '表ID，主键，供其他表做外键，unsigned bigint、单表时自增、步长为 1') {
                constraints(primaryKey: true, primaryKeyName: 'PK_FD_ORGANIZATION')
            }
            column(name: 'NAME', type: 'VARCHAR(32)', remarks: '组织名') {
                constraints(nullable: false)
            }
            column(name: 'CODE', type: 'VARCHAR(15)', remarks: '组织code') {
                constraints(nullable: false, unique: true, uniqueConstraintName: 'UK_FD_ORGANIZATION_U1')
            }

            column(name: 'USER_ID', type: "BIGINT UNSIGNED", remarks: '创建用户的id', defaultValue: '1') {
                constraints(nullable: true)
            }

            column(name: 'ADDRESS', type: "VARCHAR(128)", remarks: '组织的地址')

            column(name: 'SCALE', type: 'TINYINT UNSIGNED', remarks: '组织规模。0：0-30,1：30-100,2：100')

            column(name: 'IMAGE_URL', type: 'VARCHAR(255)', remarks: '组织图标url')

            column(name: 'IS_ENABLED', type: 'TINYINT UNSIGNED', defaultValue: "1", remarks: '是否启用。1启用，0未启用') {
                constraints(nullable: false)
            }

            column(name: 'HOME_PAGE', type: 'VARCHAR(255)', remarks: '组织官网地址')

            column(name: 'CATEGORY', type: 'VARCHAR(255)', remarks: '组织类型code', defaultValue: 'DEFAULT')

            column(name: 'BUSINESS_TYPE', type: 'VARCHAR(50)', remarks: '组织所在行业')

            column(name: 'EMAIL_SUFFIX', type: 'VARCHAR(50)', remarks: '组织邮箱后缀') {
                constraints(unique: true, uniqueConstraintName: 'UK_FD_ORGANIZATION_U26')
            }

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

    changeSet(author: 'relaxingchu@qq.com', id: '2019-08-03-study_organization-o2') {
        setTableRemarks(tableName:"STUDY_ORGANIZATION",remarks: "组织表")
    }
}