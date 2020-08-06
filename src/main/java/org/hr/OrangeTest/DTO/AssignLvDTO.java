package org.hr.OrangeTest.DTO;

public class AssignLvDTO {
	private String EmpNm; 
	private String LvTyp;
	private String FromMnt;
	private String FromYr;
	private String FromDay;
	private String ToMnt;
	private String ToYr;
	private String ToDay;
	private String Cmnt;
	
	public String getEmpNm() {
		return EmpNm;
	}
	public void setEmpNm(String empNm) {
		EmpNm = empNm;
	}
	public String getLvTyp() {
		return LvTyp;
	}
	public void setLvTyp(String lvTyp) {
		LvTyp = lvTyp;
	}
	public String getFromMnt() {
		return FromMnt;
	}
	public void setFromMnt(String fromMnt) {
		FromMnt = fromMnt;
	}
	public String getFromYr() {
		return FromYr;
	}
	public void setFromYr(String fromYr) {
		FromYr = fromYr;
	}
	public String getFromDay() {
		return FromDay;
	}
	public void setFromDay(String fromDay) {
		FromDay = fromDay;
	}
	public String getToMnt() {
		return ToMnt;
	}
	public void setToMnt(String toMnt) {
		ToMnt = toMnt;
	}
	public String getToYr() {
		return ToYr;
	}
	public void setToYr(String toYr) {
		ToYr = toYr;
	}
	public String getToDay() {
		return ToDay;
	}
	public void setToDay(String toDay) {
		ToDay = toDay;
	}
	public String getCmnt() {
		return Cmnt;
	}
	public void setCmnt(String cmnt) {
		Cmnt = cmnt;
	}
	@Override
	public String toString() {
		return "AssignLvDTO [EmpNm=" + EmpNm + ", LvTyp=" + LvTyp + ", FromMnt=" + FromMnt + ", FromYr=" + FromYr
				+ ", FromDay=" + FromDay + ", ToMnt=" + ToMnt + ", ToYr=" + ToYr + ", ToDay=" + ToDay + ", Cmnt=" + Cmnt
				+ "]";
	}	
}
