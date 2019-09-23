package com.biz.bbs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {
	private long file_seq;	//number
	private long file_bbs_seq;	//number
	private String file_origin_name;	//nvarchar2(1000 char)
	private String file_name;	//nvarchar2(1000 char)
}
