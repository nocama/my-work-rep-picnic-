package com.picmem.model;

import java.util.List;

public class PicmemService {
	private PicmemDAO dao = null;

	public PicmemService() {
		dao = new PicmemDAO();
	}

	public PicmemVO addPicmem() {
		return null;
	}

	public PicmemVO updatePicmem() {
		return null;
	}

	public void deletePicmem() {
	}

	public PicmemVO getOne() {
		return null;
	}

	public List<PicmemVO> getAll() {
		return null;
	}
	public void addowner(String picnic_no,String mem_no){
		PicmemVO picmemVO =new PicmemVO();
		picmemVO.setPicnic_no(picnic_no);
		picmemVO.setMem_no(mem_no);
		dao.insertowner(picmemVO);
	}
}
