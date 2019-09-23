package com.biz.bbs.mapper;

import org.apache.ibatis.jdbc.SQL;

public class FileSQL {
	
	public String file_insert_sql() {
		
		SQL sql = new SQL() {{
			INSERT_INTO("tbl_bbs_file");
			INTO_COLUMNS("file_seq")
				.INTO_VALUES("SEQ_BBS_FILE.NEXTVAL");
			INTO_COLUMNS("file_bbs_seq")
				.INTO_VALUES("#{file_bbs_seq}");
			INTO_COLUMNS("file_origin_name")
				.INTO_VALUES("#{file_origin_name}");
			INTO_COLUMNS("file_name")
				.INTO_VALUES("#{file_name}");
		}};
		
		return sql.toString();
	}
}
