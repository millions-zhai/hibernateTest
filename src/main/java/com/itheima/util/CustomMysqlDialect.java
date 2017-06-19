package com.itheima.util;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class CustomMysqlDialect extends MySQL5InnoDBDialect {

//	@Override
//	public String getTableTypeString() {
//		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
//	}

	@Override
	public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable,
			String[] primaryKey, boolean referencesPrimaryKey) {
		// TODO Auto-generated method stub
		return " alter "+ foreignKey[0] +" set default null ";
	}
	
	
	
}
