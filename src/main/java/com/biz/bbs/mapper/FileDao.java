package com.biz.bbs.mapper;

import java.io.File;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.model.FileVO;

public interface FileDao {
	
	@Select(" SELECT * FROM tbl_bbs_file ")
	public List<FileVO> selectAll();
	
	@Select(" SELECT * FROM tbl_bbs_file WHERE file_seq = #{file_seq} ")
	public FileVO findBySeq(long file_seq);
	
	@InsertProvider(type = FileSQL.class, method = "file_insert_sql")
	public int insert(FileVO fileVO);

	@Delete(" DELETE FROM tbl_bbs_file WHERE file_seq = ${file_seq} ")
	public void delete(long file_seq);
	
	@Select(" SELECT * FROM tbl_bbs_file WHERE file_bbs_seq = #{bbs_seq} ")
	public List<FileVO> findByBBsSeq(long bbs_seq);
	
	@Delete(" DELETE FROM tbl_bbs_file WHERE file_bbs_seq = #{bbs_seq} ")
	public int deletes(long bbs_seq);
}
