package script.db

databaseChangeLog(logicalFilePath: 'study_organization.groovy') {
    changeSet(id: '2019-08-03-study-project', author: 'relaxingchu@qq.com') {
        createTable(tableName: "STUDY_PROJECT") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', autoIncrement: true, remarks: '表ID，主键，供其他表做外键，unsigned bigint、单表时自增、步长为 1') {
                constraints(primaryKey: true, primaryKeyName: 'PK_FD_PROJECT')
            }
            column(name: 'NAME', type: 'VARCHAR(32)', remarks: '项目名') {
                constraints(nullable: false)
            }
            column(name: 'CODE', type: 'VARCHAR(14)', remarks: '项目code') {
                constraints(nullable: false)
            }
            column(name: 'ORGANIZATION_ID', type: 'BIGINT UNSIGNED', remarks: '组织ID')

            column(name: 'IMAGE_URL', type: 'VARCHAR(255)', remarks: '项目图标url')

            column(name: 'IS_ENABLED', type: 'TINYINT UNSIGNED', defaultValue: "1", remarks: '是否启用。1启用，0未启用') {
                constraints(nullable: false)
            }

            column(name: 'TYPE', type: 'VARCHAR(64)', remarks: '项目类型')

            column(name: 'CATEGORY', type: 'VARCHAR(64)', remarks: '项目类别：AGILE(敏捷项目),PROGRAM(普通项目组),ANALYTICAL(分析型项目群)', defaultValue: 'AGILE')

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
        addUniqueConstraint(tableName: 'STUDY_PROJECT', columnNames: 'CODE, ORGANIZATION_ID', constraintName: 'UK_FD_PROJECT_U22')
    }

    changeSet(author: 'relaxingchu@qq.com', id: '2019-08-03-study-project-02') {
        setTableRemarks(tableName:"STUDY_PROJECT",remarks: "项目表")
    }

}