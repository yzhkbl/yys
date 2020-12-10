package com.jeethink.system.domain.vo;

import lombok.Data;

@Data
public class Pics {
	/**
	 * 材料的fileName
	 */
	private String picFileName;
	/**
	 * 材料完整路径地址
	 */
	private String picAddress;
	/**
	 * 材料ID
	 */
	private Integer picId;
	/**
	 * 材料Code
	 */
	private String picCode;

}
