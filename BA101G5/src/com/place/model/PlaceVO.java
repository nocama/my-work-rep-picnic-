package com.place.model;
import java.sql.Date;
public class PlaceVO implements java.io.Serializable{
		private String p_no;
		private String mf_no;
		private String mem_no;
		private String p_name;
		private Date p_until;
		private String p_place;
		private Integer p_pop;
		private byte[] pimg;
		private String p_info;
		private String p_sta;
		private Integer p_price;
		public String getP_no() {
			return p_no;
		}
		public void setP_no(String p_no) {
			this.p_no = p_no;
		}
		public String getMf_no() {
			return mf_no;
		}
		public void setMf_no(String mf_no) {
			this.mf_no = mf_no;
		}
		public String getMem_no() {
			return mem_no;
		}
		public void setMem_no(String mem_no) {
			this.mem_no = mem_no;
		}
		public String getP_name() {
			return p_name;
		}
		public void setP_name(String p_name) {
			this.p_name = p_name;
		}
		public Date getP_until() {
			return p_until;
		}
		public void setP_until(Date p_until) {
			this.p_until = p_until;
		}
		public String getP_place() {
			return p_place;
		}
		public void setP_place(String p_place) {
			this.p_place = p_place;
		}
		public Integer getP_pop() {
			return p_pop;
		}
		public void setP_pop(Integer p_pop) {
			this.p_pop = p_pop;
		}
		public byte[] getPimg() {
			return pimg;
		}
		public void setPimg(byte[] pimg) {
			this.pimg = pimg;
		}
		public String getP_info() {
			return p_info;
		}
		public void setP_info(String p_info) {
			this.p_info = p_info;
		}
		public String getP_sta() {
			return p_sta;
		}
		public void setP_sta(String p_sta) {
			this.p_sta = p_sta;
		}
		public Integer getP_price() {
			return p_price;
		}
		public void setP_price(Integer p_price) {
			this.p_price = p_price;
		}
}
