package matsu.entity;

public class CheckBean {
    
    private  String syainId; //社員ID
    private  String busyoId; //部署ID
    private  String zipCd;   //郵便番号
    private  String telNo;   //電話番号
    private  String sintyou; //身長
    
    /**
     * @return syainId 社員ID
     */
    public String getSyainId() {
        return syainId;
    }
    /**
     * @param syainId 社員IDをセットする 
     */
    public void setSyainId(String syainId) {
        this.syainId = syainId;
    }
    /**
     * @return busyoId　部署ID
     */
    public String getBusyoId() {
        return busyoId;
    }
    /**
     * @param busyoId 部署IDをセットする 
     */
    public void setBusyoId(String busyoId) {
        this.busyoId = busyoId;
    }
    /**
     * @return zipCd　郵便番号
     */
    public String getZipCd() {
        return zipCd;
    }
    /**
     * @param zipCd 郵便番号をセットする 
     */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }
    /**
     * @return telNo　電話番号
     */
    public String getTelNo() {
        return telNo;
    }
    /**
     * @param telNo 電話番号をセットする 
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    /**
     * @return sintyou　身長
     */
    public String getSintyou() {
        return sintyou;
    }
    /**
     * @param sintyou 身長をセットする 
     */
    public void setSintyou(String sintyou) {
        this.sintyou = sintyou;
    }
    
    
    
}
