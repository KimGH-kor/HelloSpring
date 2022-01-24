package jUnit;

public class DTO {
	String clss;
	String seq;
	int kor;
	int eng;
	int mat;
	public String getClss() {
		return clss;
	}
	public void setClss(String clss) {
		this.clss = clss;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	@Override
	public String toString() {
		return "DTO [clss=" + clss + ", seq=" + seq + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + "]";
	}
	
	
}
