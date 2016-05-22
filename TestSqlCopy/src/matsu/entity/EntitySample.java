package matsu.entity;


public class EntitySample {

    private String goods_id;
    private String goods_name;
    private Integer unit_price;
    private String animalname;
    private String animaltype;

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public void setAnimalname(String animalname){
    	this.animalname = animalname;
    }

    public String getAnimalname(){
    	return animalname;
    }

    public void setAnimaltype(String animaltype){
    	this.animaltype = animaltype;
    }

    public String getAnimaltype(){
    	return animaltype;
    }
}
