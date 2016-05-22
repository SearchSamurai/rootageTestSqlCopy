package okazaki.entity;

public class RcSample {

	private int goodsId;
	private String goodsName;
	private String format;
	private  int unitPrice;

	//goods_idのゲッター
    public int getGoodsId() {
        return goodsId;
    }
	//goods_idのセッター
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

	//goods_nameのゲッター
    public String getGoodsName() {
        return goodsName;
    }
	//goods_nameのセッター
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

	//formatのゲッター
    public String getFormat() {
        return format;
    }
	//formatのセッター
    public void setFormat(String format) {
        this.format = format;
    }

	//unit_priceのゲッター
    public int getUnitPrice() {
        return unitPrice;
    }
	//unit_priceのセッター
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

}