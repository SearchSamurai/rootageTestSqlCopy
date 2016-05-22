package matsu.entity;

public class TestSqlBean {

    private String goodsId;

    /**
     * 商品番号を取得
     *
     * @return goodsId 商品番号
     */
    public String getGoodsId(){
        return goodsId;
    }

    /**
     * 商品番号を設定
     *
     * @param goodsId 商品番号
     */
    public void setGoodsId(String goodsId){
        this.goodsId = goodsId;
    }

}
