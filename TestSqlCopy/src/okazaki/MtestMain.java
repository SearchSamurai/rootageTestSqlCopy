package okazaki;

import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okazaki.entity.RcSample;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MtestMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SqlMapClient sqlMap = null;

		try {
			String resource = "okazaki/sqlmap/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			sqlMap.startTransaction();

			//SELECT (パラメータ無し) queryForList
			System.out.println("-----SELECT (パラメータ無し) queryForList ここから-----");
			List<RcSample> li1 = sqlMap.queryForList("selectList");
			//goodsNameを取得して出力
			for(RcSample i : li1){
			    System.out.println(i.getGoodsId());
			    System.out.println(i.getGoodsName() + "\n");
			}
			System.out.println("-----SELECT (パラメータ無し) queryForList ここまで-----\n\n");

			//SELECT (パラメータ無し) queryForObject
			System.out.println("-----SELECT (パラメータ無し) queryForObject ここから-----");
			RcSample data = (RcSample) sqlMap.queryForObject("selectObject");
			System.out.println(data.getGoodsId());
            System.out.println(data.getGoodsName());
			System.out.println("-----SELECT (パラメータ無し) queryForObject ここまで-----\n\n");

            //SELECT (パラメータクラスを使用する) Bean
			System.out.println("-----SELECT (パラメータクラスを使用する) Bean ここから-----");
            //goods_idの指定
			data.setGoodsId(2);
			RcSample data2 = (RcSample) sqlMap.queryForObject("selectObject2" , data);
            //goodsIdとgoodsNameを取得して出力
            System.out.println(data2.getGoodsId());
            System.out.println(data2.getGoodsName());
            System.out.println("-----SELECT (パラメータクラスを使用する) Bean ここまで-----\n\n");

            //SELECT (パラメータクラスを使用する) Map
            System.out.println("-----SELECT (パラメータクラスを使用する) Map ここから-----");
            Map<String , Object> map = new HashMap<String, Object>();
            //goods_idの指定
            map.put("goodsId", Integer.valueOf(4));
            RcSample data3 = (RcSample) sqlMap.queryForObject("selectObject3" , map);
            System.out.println(data3.getGoodsId());
            System.out.println(data3.getGoodsName());
            System.out.println("-----SELECT (パラメータクラスを使用する) Map ここまで-----\n\n");

            //INSERT (パラメータクラスを使用する) Bean
            System.out.println("-----INSERT (パラメータクラスを使用する) Bean ここから-----");
            int goodsId = 43438;
			RcSample data4 = new RcSample();
            data4.setGoodsId(goodsId);
            data4.setGoodsName("ガチムチドリンク");
            data4.setFormat("4545");
            data4.setUnitPrice(114514);
            sqlMap.insert("insertRecord" , data4);
            //以下、正常にINSERTできたか出力して確認
            //INSERTしたgoods_idの指定
			RcSample data5 = new RcSample();
            data5.setGoodsId(goodsId);
            RcSample data6 = (RcSample) sqlMap.queryForObject("selectObject2" , data5);
            //INSERTしたgoodsIdとgoodsNameを取得して出力
            System.out.println("INSERTしたレコードを出力します。");
            System.out.println(data6.getGoodsId());
            System.out.println(data6.getGoodsName());
            System.out.println(data6.getFormat());
            System.out.println(data6.getUnitPrice());
            System.out.println("-----INSERT (パラメータクラスを使用する) Bean ここまで-----\n\n");

            //INSERT (パラメータクラスを使用する) Map
            System.out.println("-----INSERT (パラメータクラスを使用する) Map ここから-----");
            int goodsId2 = 43439;
            //キー(=カラム)と、インサートする値を指定
            Map<String , Object> map2 = new HashMap<String, Object>();
            map2.put("goodsId",Integer.valueOf(goodsId2));
            map2.put("goodsName","スヤスヤドリンク");
            map2.put("format","12321");
            map2.put("unitPrice",Integer.valueOf(400));
            //紐づけ
            sqlMap.insert("insertRecord2",map2);
            //以下、正常にINSERTできたか出力して確認
            //INSERTしたgoods_idの指定
			RcSample data7 = new RcSample();
            data7.setGoodsId(goodsId2);
            RcSample data8 = (RcSample) sqlMap.queryForObject("selectObject2" , data7);
            System.out.println("INSERTしたレコードを出力します。");
            System.out.println(data8.getGoodsId());
            System.out.println(data8.getGoodsName());
            System.out.println(data8.getFormat());
            System.out.println(data8.getUnitPrice());
            System.out.println("-----INSERT (パラメータクラスを使用する) Map ここまで-----\n\n");

			//UPDATE (パラメータクラスを使用する) Bean
            System.out.println("-----UPDATE (パラメータクラスを使用する) Bean ここから-----");
			int goodsId3 = 43438;
			//変更したい場所と変更する値の入力
			RcSample data9 = new RcSample();
			data9.setGoodsId(goodsId3);
			data9.setGoodsName("謎の液体");
			//紐づけ
			sqlMap.update("updateRecord", data9);
			//以下、正常にUPDATEできたか出力して確認
			//UPDATEしたgoods_idの指定
			RcSample data10 = new RcSample();
			data10.setGoodsId(goodsId3);
			RcSample data11 = (RcSample) sqlMap.queryForObject("selectObject2" , data10);
			//UPDATEしたgoodsIdとgoodsNameを取得して出力
			System.out.println("UPDATEしたレコードを出力します。");
			System.out.println(data11.getGoodsId());
			System.out.println(data11.getGoodsName());
			System.out.println(data11.getFormat());
			System.out.println(data11.getUnitPrice());
            System.out.println("-----UPDATE (パラメータクラスを使用する) Bean ここまで-----\n\n");

			//UPDATE (パラメータクラスを使用する) Map
            System.out.println("-----UPDATE (パラメータクラスを使用する) Map ここから-----");
			int goodsId4 = 43439;
            Map<String , Object> map3 = new HashMap<String, Object>();
			map3.put("goodsId",Integer.valueOf(goodsId4));
			map3.put("goodsName","あの夜の温もり");
			sqlMap.update("updateRecord2",map3);
			//以下、正常にUPDATEできたか出力して確認
			//UPDATEしたgoods_idの指定
			RcSample data12 = new RcSample();
			data12.setGoodsId(goodsId4);
			RcSample data13 = (RcSample) sqlMap.queryForObject("selectObject2" , data12);
			//UPDATEしたgoodsIdとgoodsNameを取得して出力
			System.out.println("UPDATEしたレコードを出力します。");
			System.out.println(data13.getGoodsId());
			System.out.println(data13.getGoodsName());
			System.out.println(data13.getFormat());
			System.out.println(data13.getUnitPrice());
            System.out.println("-----UPDATE (パラメータクラスを使用する) Map ここまで-----\n\n");

			//DELETE (パラメータクラスを使用する) Bean
            System.out.println("-----DELETE (パラメータクラスを使用する) Bean ここから-----");
            RcSample del = new RcSample();
			//DELETEするレコードの指定
			int goodsId5 = 43438;
			del.setGoodsId(goodsId5);
			sqlMap.delete("deleteRecord", del);
			//以下、正常にDELETEできたか確認
			System.out.println("指定したレコードが削除されているか確認します。");
			RcSample data14 = new RcSample();
			data14.setGoodsId(goodsId);
			RcSample data15 = (RcSample) sqlMap.queryForObject("selectObject2" , data14);
			if(data15 == null){
				System.out.println("goods_id:" + goodsId5 + "のレコードは正常に削除されました。");
			} else {
				System.out.println("指定されたレコードは何らかの原因で削除されませんでした。");
			}
            System.out.println("-----DELETE (パラメータクラスを使用する) Bean ここまで-----\n\n");

			//DELETE (パラメータクラスを使用する) Map
            System.out.println("-----DELETE (パラメータクラスを使用する) Map ここから-----");
			int goodsId6 = 43439;
            Map<String , Object> map4 = new HashMap<String, Object>();
			map4.put("goodsId",Integer.valueOf(goodsId6));
			sqlMap.delete("deleteRecord2",map4);
			//以下、正常にDELETEできたか確認
			System.out.println("指定したレコードが削除されているか確認します。");
            Map<String , Object> map5 = new HashMap<String, Object>();
            map5.put("goodsId", Integer.valueOf(goodsId6));
            RcSample data16 = (RcSample) sqlMap.queryForObject("selectObject3" , map5);
			if(data16 == null){
				System.out.println("goods_id:" + goodsId6 + "のレコードは正常に削除されました。");
			} else {
				System.out.println("指定されたレコードは何らかの原因で削除されませんでした。");
			}
            System.out.println("-----DELETE (パラメータクラスを使用する) Map ここまで-----");

			sqlMap.commitTransaction();

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				sqlMap.endTransaction();
			} catch (SQLException e1) {
			}
		}
	}
}