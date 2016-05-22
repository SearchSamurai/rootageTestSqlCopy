package matsu;

import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import matsu.entity.EntitySample;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MtestMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SqlMapClient sqlMap = null;

		try {
			String resource = "matsu/sqlmap/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			sqlMap.startTransaction();

			// 全件
			List<EntitySample> a = sqlMap.queryForList("selectList");
			for (EntitySample as : a) {
				System.out.println(as.getGoods_name());
			}

			System.out.println("=========================================");

			Map<String , Object> map = new HashMap<String, Object>();
			map.put("goodsId", "G001");
			EntitySample result = (EntitySample) sqlMap.queryForObject("selectObject", map);
			System.out.println(result.getGoods_id());
			System.out.println(result.getGoods_name());
			System.out.println(result.getUnit_price());

			EntitySample result2 = new EntitySample();
			result2.setGoods_id("G003");
			result2.setGoods_name("みかん");
		    result = (EntitySample)sqlMap.queryForObject("selectObject2" , result2);
		    System.out.println("=========================================");
		    System.out.println(result.getGoods_id());
			System.out.println(result.getGoods_name());
			System.out.println(result.getUnit_price());

			System.out.println("=========================================");
			List<EntitySample> name = sqlMap.queryForList("selectMyList");
			for (EntitySample as : name) {
				System.out.println(as.getAnimalname());
			}
			System.out.println("=========================================");
			List<EntitySample> num = sqlMap.queryForList("t3");
			System.out.println(num);

			System.out.println("=========================================");
			EntitySample result3 = new EntitySample();
			result3.setAnimaltype("cat");
			result3.setAnimalname("モモ");
			List<EntitySample> vvvvv = sqlMap.queryForList("getparm", result3);
			for (EntitySample e : vvvvv) {
				System.out.println(e.getAnimaltype());
				System.out.println(e.getAnimalname());
			}

//	        System.out.println("★★★★★★★★★★★★★★★★★★★★★");
//            List<EntitySample> in = sqlMap.queryForList("001");
//                System.out.println("SELECT文");
//            for(EntitySample an : in){
//                System.out.println(an.getName());
//            }
//
//            System.out.println("------------------------------------------");
//            List<EntitySample> in2 = sqlMap.queryForList("001_2");
//            System.out.println("SELECT文②」");
//            for(EntitySample an2 : in2){
//                System.out.println(an2.getNumber() + an2.getName() + an2.getGen());
//
//            }
//
//
//            /* INSERT文 */
//            EntitySample inareturn2 = new EntitySample();
//            inareturn2.setNumber(400);
//            inareturn2.setName("紅茶4");
//            inareturn2.setGen("さいたま市4");
//            sqlMap.insert("002", inareturn2);
//
//            /* UPDATE文 */
//            EntitySample inaUpdate = new EntitySample();
//            inaUpdate.setNumber(400);
//            inaUpdate.setName("RED BULL");
//            sqlMap.update("003", inaUpdate);
//
//            System.out.println("------------------------------------------");
//            /* DELETE文 */
//            EntitySample inadelete = new EntitySample();
//            inadelete.setName("メロンパン");
//            sqlMap.delete("004", inadelete);

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
