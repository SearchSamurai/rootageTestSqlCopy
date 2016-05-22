package okazaki.KenkyuKadai1;

import java.sql.Date;

public class KkBean1 {

	private String syainId;
	private String busyoId;
	private String nameL;
	private String nameF;
	private String kNameL;
	private String kNameF;
	private String zipCd;
	private String kAddress1;
	private String kAddress2;
	private String kAddress3;
	private String telNo;
	private float sintyou;
	private Date updateDt;
	private Date entryDt;

	//syainIdのゲッター
    public String getSyainId() {
        return syainId;
    }
	//syainIdのセッター
    public void setSyainId(String syainId) {
        this.syainId = syainId;
    }

	//busyoIdのゲッター
    public String getBusyoId() {
        return busyoId;
    }
	//busyoIdのセッター
    public void setBusyoId(String busyoId) {
        this.busyoId = busyoId;
    }

	//nameLのゲッター
    public String getNameL() {
        return nameL;
    }
	//nameLのセッター
    public void setNameL(String nameL) {
        this.nameL = nameL;
    }

	//nameFのゲッター
    public String getNameF() {
        return nameF;
    }
	//nameFのセッター
    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

	//kNameLのゲッター
    public String getKNameL() {
        return kNameL;
    }
	//kNameLのセッター
    public void setKNameL(String kNameL) {
        this.kNameL = kNameL;
    }

	//kNameFのゲッター
    public String getKNameF() {
        return kNameF;
    }
	//kNameFのセッター
    public void setKNameF(String kNameF) {
        this.kNameF = kNameF;
    }

	//zipCdのゲッター
    public String getZipCd() {
        return zipCd;
    }
	//zipCdのセッター
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

	//kAddress1のゲッター
    public String getKAddress1() {
        return kAddress1;
    }
	//kAddress1のセッター
    public void setKAddress1(String kAddress1) {
        this.kAddress1 = kAddress1;
    }

	//kAddress2のゲッター
    public String getKAddress2() {
        return kAddress2;
    }
	//kAddress1のセッター
    public void setKAddress2(String kAddress2) {
        this.kAddress2 = kAddress2;
    }

	//kAddress3のゲッター
    public String getKAddress3() {
        return kAddress3;
    }
	//kAddress1のセッター
    public void setKAddress3(String kAddress3) {
        this.kAddress3 = kAddress3;
    }

	//telNoのゲッター
    public String getTelNo() {
        return telNo;
    }
	//telNoのセッター
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

	//sintyouのゲッター
    public float getSintyou() {
        return sintyou;
    }
	//sintyouのセッター
    public void setSintyou(float sintyou) {
        this.sintyou = sintyou;
    }

	//updateDtのゲッター
    public Date getUpdateDt() {
        return updateDt;
    }
	//updateDtのセッター
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

	//entryDtのゲッター
    public Date getEntryDt() {
        return entryDt;
    }
	//entryDtのセッター
    public void setEntryDt(Date entryDt) {
        this.entryDt = entryDt;
    }
}