package com.picnic.model;

import java.sql.Date;
import java.util.List;

public class PicnicService {
	private PicnicDAO dao = null;

	public PicnicService() {
		dao = new PicnicDAO();
	}

	public PicnicVO addPicnic() {
		return null;
	}

	public PicnicVO updatePicnic() {
		return null;
	}

	public void deletePicnic() {
	}

	public PicnicVO getOne() {
		return null;
	}

	public List<PicnicVO> getAll() {
		return null;
	}
	public void addPicnic(String picnic_name,Date picnic_date,Integer picnic_pl){}
}
