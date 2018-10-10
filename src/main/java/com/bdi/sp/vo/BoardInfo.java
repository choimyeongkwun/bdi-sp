package com.bdi.sp.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("bi")
public class BoardInfo {

	private Integer binum;
	private String bititle;
	private String bitext;
	private String bicredate;
	private String bimoddat;
	private Integer bicnt;
	private Integer biactive;
	@Override
	public String toString() {
		return "BoardInfo [binum=" + binum + ", bititle=" + bititle + ", bitext=" + bitext + ", bicredate=" + bicredate
				+ ", bimoddat=" + bimoddat + ", bicnt=" + bicnt + ", biactive=" + biactive + "]";
	}
	public Integer getBinum() {
		return binum;
	}
	public void setBinum(Integer binum) {
		this.binum = binum;
	}
	public String getBititle() {
		return bititle;
	}
	public void setBititle(String bititle) {
		this.bititle = bititle;
	}
	public String getBitext() {
		return bitext;
	}
	public void setBitext(String bitext) {
		this.bitext = bitext;
	}
	public String getBicredate() {
		return bicredate;
	}
	public void setBicredate(String bicredate) {
		this.bicredate = bicredate;
	}
	public String getBimoddat() {
		return bimoddat;
	}
	public void setBimoddat(String bimoddat) {
		this.bimoddat = bimoddat;
	}
	public Integer getBicnt() {
		return bicnt;
	}
	public void setBicnt(Integer bicnt) {
		this.bicnt = bicnt;
	}
	public Integer getBiactive() {
		return biactive;
	}
	public void setBiactive(Integer biactive) {
		this.biactive = biactive;
	}
	
}
