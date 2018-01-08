package com.momo.spring.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Nationalized;
import org.springframework.lang.Nullable;

@Entity
public class Student {

	@Id
	private int id;
	
	@Column(name = "SUID")
	private int suID;
	
	@Column(name = "STUID")
	private int stuID;
	
	@Column(name = "REGNO")
	private String regNum;
	
	@Column(name = "STRN")
	@Nullable
	private String strn;
	
	@Basic
	@Nationalized
	@Column(name = "CHNAME")
	private String chiName;
	
	@Column(name = "ENNAME")
	private String engName;

	@Column(name = "SEX")
	private char sex;

	@Column(name = "UPDVERSION")
	private long updVersion;
	
	@Column(name = "CLASSCODE")
	private String classCode;
	
	@Column(name = "CLASSLVL")
	private String classLvl;
	
	@Column(name = "CLASSNO")
	private int classNum;
	
	@Column(name = "SCHLVL")
	private String schLvl;
	
	@Column(name = "SCHSESS")
	private String schScc;
	
	@Column(name = "SCHLEAVERSIGN")
	private int schLevelSign;
	
	@Nullable
	@Column(name = "FEEREMISSIONIND")
	private String freeMissionInd;
	
	@Nullable
	@Column(name = "SCHHOUSE")
	private String schHse;
	
	@Column(name = "HEIGHT")
	private int height;
	
	@Column(name = "WEIGHT")
	private int weight;

	public Student() {}

	public Student(int suID, int stuID, String regNum, String strn, String chiName, String engName, char sex,
			long updVersion, String classCode, String classLvl, int classNum, String schLvl, String schScc,
			int schLevelSign, String freeMissionInd, String schHse, int height, int weight, boolean status) {
		super();
		this.suID = suID;
		this.stuID = stuID;
		this.regNum = regNum;
		this.strn = strn;
		this.chiName = chiName;
		this.engName = engName;
		this.sex = sex;
		this.updVersion = updVersion;
		this.classCode = classCode;
		this.classLvl = classLvl;
		this.classNum = classNum;
		this.schLvl = schLvl;
		this.schScc = schScc;
		this.schLevelSign = schLevelSign;
		this.freeMissionInd = freeMissionInd;
		this.schHse = schHse;
		this.height = height;
		this.weight = weight;
	}

	public int getSuID() {
		return suID;
	}

	public void setSuID(int suID) {
		this.suID = suID;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getStrn() {
		return strn;
	}

	public void setStrn(String strn) {
		this.strn = strn;
	}

	public String getChiName() {
		return chiName;
	}

	public void setChiName(String chiName) {
		this.chiName = chiName;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public long getUpdVersion() {
		return updVersion;
	}

	public void setUpdVersion(long updVersion) {
		this.updVersion = updVersion;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassLvl() {
		return classLvl;
	}

	public void setClassLvl(String classLvl) {
		this.classLvl = classLvl;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public String getSchLvl() {
		return schLvl;
	}

	public void setSchLvl(String schLvl) {
		this.schLvl = schLvl;
	}

	public String getSchScc() {
		return schScc;
	}

	public void setSchScc(String schScc) {
		this.schScc = schScc;
	}

	public int getSchLevelSign() {
		return schLevelSign;
	}

	public void setSchLevelSign(int schLevelSign) {
		this.schLevelSign = schLevelSign;
	}

	public String getFreeMissionInd() {
		return freeMissionInd;
	}

	public void setFreeMissionInd(String freeMissionInd) {
		this.freeMissionInd = freeMissionInd;
	}

	public String getSchHse() {
		return schHse;
	}

	public void setSchHse(String schHse) {
		this.schHse = schHse;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String toString() {
		return String.format("Student: [name - %s, stdID - %s]", this.engName, this.stuID);
	}
}
