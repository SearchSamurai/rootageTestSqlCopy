package matsu.entity;

public class RegistBean {

    //社員ID
    private String syainid;

    //部署ID
    private String busyoid;

    //社員氏名姓（カナ）
    private String namel;

    //社員氏名名（カナ）
    private String namef;

    //社員氏名姓（漢字）
    private String knamel;

    //社員氏名名（漢字）
    private String knamef;

    //郵便番号
    private String zipcd;

    //社員住所１（漢字）
    private String kaddress1;

    //社員住所２（漢字）
    private String kaddress2;

    //社員住所３（漢字）
    private String kaddress3;

    //電話番号
    private String telno;

    //身長
    private Float sintyou;



    /**
     * 社員IDを設定する
     *
     * @param syainid 社員ID
     */
    public void setSyainid(String syainid) {
        this.syainid = syainid;
    }

    /**
     * 社員IDを取得する
     *
     * @return 社員ID
     */
    public String getSyainid() {
        return syainid;
    }

    /**
     * 部署IDを設定する
     *
     * @param syainid 部署ID
     */
    public void setBusyoid(String busyoid) {
        this.busyoid = busyoid;
    }

    /**
     * 部署IDを取得する
     *
     * @return 部署ID
     */
    public String getBusyoid() {
        return busyoid;
    }

    /**
     * 社員氏名姓（カナ）を設定する
     *
     * @param namel 社員氏名姓（カナ）
     */
    public void setNamel(String namel) {
        this.namel = namel;
    }

    /**
     * 社員氏名姓（カナ）を取得する
     *
     * @return namel 社員氏名姓（カナ）
     */
    public String getNamel() {
        return namel;
    }

    /**
     * 社員氏名名（カナ）を設定する
     *
     * @param namef 社員氏名名（カナ）
     */
    public void setNamef(String namef) {
        this.namef = namef;
    }

    /**
     * 社員氏名姓（カナ）を取得する
     *
     * @return namef 社員氏名名（カナ）
     */
    public String getNamef() {
        return namef;
    }

    /**
     * 社員氏名姓（漢字）を設定する
     *
     * @param knamel 社員氏名姓（漢字）
     */
    public void setKnamel(String knamel) {
        this.knamel = knamel;
    }

    /**
     * 社員氏名姓（漢字）を取得する
     *
     * @return knamel 社員氏名姓（漢字）
     */
    public String getKnamel() {
        return knamel;
    }

    /**
     * 社員氏名名（漢字）を設定する
     *
     * @param knamef 社員氏名名（漢字）
     */
    public void setKnamef(String knamef) {
        this.knamef = knamef;
    }

    /**
     * 社員氏名姓（漢字）を取得する
     *
     * @return knamef 社員氏名名（漢字）
     */
    public String getKnamef() {
        return knamef;
    }


    /**
     * 郵便番号を設定する
     *
     * @param zipcd 郵便番号
     */
    public void setZipcd(String zipcd) {
        //ハイフンなしの番号でセットする
        this.zipcd = zipcd.replace("-","");

    }

    /**
     * 郵便番号を取得する
     *
     * @return zipcd 郵便番号
     */
    public String getZipcd() {
        return zipcd;
    }

    /**
     * 社員住所１（漢字）を設定する
     *
     * @param kaddress1 社員住所１（漢字）
     */
    public void setKaddress1(String kaddress1) {
        this.kaddress1 = kaddress1;
    }

    /**
     * 社員住所１（漢字）を取得する
     *
     * @return kaddress1 社員住所１（漢字）
     */
    public String getKaddress1() {
        return kaddress1;
    }

    /**
     * 社員住所２（漢字）を設定する
     *
     * @param kaddress2 社員住所２（漢字）
     */
    public void setKaddress2(String kaddress2) {
        this.kaddress2 = kaddress2;
    }

    /**
     * 社員住所２（漢字）を取得する
     *
     * @return kaddress2 社員住所２（漢字）
     */
    public String getKaddress2() {
        return kaddress2;
    }

    /**
     * 社員住所３（漢字）を設定する
     *
     * @param kaddress3 社員住所３（漢字）
     */
    public void setKaddress3(String kaddress3) {
        this.kaddress3 = kaddress3;
    }

    /**
     * 社員住所３（漢字）を取得する
     *
     * @return kaddress3 社員住所３（漢字）
     */
    public String getKaddress3() {
        return kaddress3;
    }

    /**
     * 電話番号を設定する
     *
     * @param telno 電話番号）
     */
    public void setTelno(String telno) {
        //ハイフンなしの番号でセットする
        this.telno = telno.replace("-","");
    }

    /**
     * 電話番号を取得する
     *
     * @return telno 電話番号
     */
    public String getTelno() {
        return telno;
    }

    /**
     * 身長を設定する
     *
     * @param sintyou 身長）
     */
    public void setSintyou(Float sintyou) {
        this.sintyou = sintyou;
    }

    /**
     * 身長を取得する
     *
     * @return sintyou 身長
     */
    public Float getSintyou() {
        return sintyou;
    }


}
