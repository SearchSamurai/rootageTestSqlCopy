package okazaki.KenkyuKadai1;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class RegistAndDelete1 {
	//登録依頼ファイルの内容を社員マスタテーブルに登録するメソッド
	public static void masterRegist(List<String> li1){

		try{

			//MySql関連の必要事項を入力
			String resource = "okazaki/sqlmap/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = null;
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

			try {

				sqlMap.startTransaction();

				KkBean1 data = new KkBean1();

				//日付情報だけ先に登録。今回は更新日はnullで指定されているのでnullをセットする
				data.setUpdateDt(null);

				//リスト1(登録依頼ファイル)の内容を社員マスタテーブルに登録
				for(int i = 0; i < li1.size(); i++){

					//社員IDの登録(カラムが12個あるので、社員IDに関してはリスト内で0番目及び
					//i-12を12で割り切れるインデックス番号の要素が社員IDとなるので、if文で判定してセッターで登録)
					//部署ID以下のカラムもその法則に基いて判定する。
					if(i == 0 || i % 12 == 0){
						if(i == 0){
							data.setSyainId(li1.get(i).substring(0, 3));
						} else {
							data.setSyainId(li1.get(i).substring(0, 3));
						}

						//部署IDの登録)
					} else if(i == 1 || (i - 1) % 12 == 0){
						data.setBusyoId(li1.get(i));

						//社員氏名_姓(カナ)の登録
					} else if(i == 2 || (i - 2) % 12 == 0){
						data.setNameL(li1.get(i));

						//社員氏名_名(カナ)の登録
					} else if(i == 3 || (i - 3) % 12 == 0){
						data.setNameF(li1.get(i));

						//社員氏名_姓(漢字)の登録
					} else if(i == 4 || (i - 4) % 12 == 0){
						data.setKNameL(li1.get(i));

						//社員氏名_名(漢字)の登録
					} else if(i == 5 || (i - 5) % 12 == 0){
						data.setKNameF(li1.get(i));

						//郵便番号の登録
					} else if(i == 6 || (i - 6) % 12 == 0){
						//"-"を削除し、数値だけの並びにする
						data.setZipCd((li1.get(i)).replaceAll("-", ""));

						//社員住所１(漢字)の登録
					} else if(i == 7 || (i - 7) % 12 == 0){
						data.setKAddress1(li1.get(i));

						//社員住所２(漢字)の登録
					} else if(i == 8 || (i - 8) % 12 == 0){
						data.setKAddress2(li1.get(i));

						//社員住所３(漢字)の登録
					} else if(i == 9 || (i - 9) % 12 == 0){
						data.setKAddress3(li1.get(i));

						//電話番号の登録
					} else if(i == 10 || (i - 10) % 12 == 0){
						//"-"を削除し、数値だけの並びにする
						data.setTelNo((li1.get(i)).replaceAll("-", ""));

						//身長の登録
					} else if(i == 11 || (i + 1) % 12 == 0){
						data.setSintyou(Float.parseFloat(li1.get(i)));
						sqlMap.insert("kenkyuKadai1" , data);
					}
				}
				sqlMap.commitTransaction();
				System.out.println("登録依頼ファイルのデータは正常に社員マスタテーブルに登録されました");
			} catch (NumberFormatException e) {
				System.out.println("登録に失敗したため異常終了しました。");
				try {
					sqlMap.endTransaction();
				} catch (SQLException e1){
					System.out.println("登録に失敗したため異常終了しました。");
				}
			} catch (MySQLIntegrityConstraintViolationException e) {
				System.out.println("SQL関連のエラーで登録に失敗したため異常終了しました。社員ID(PK)の重複などを確認してみて下さい。");
				try {
					sqlMap.endTransaction();
				} catch (SQLException e1) {
					System.out.println("登録に失敗したため異常終了しました。3");
				}
			} catch (SQLException e) {
				System.out.println("SQL関連のエラーで登録に失敗したため異常終了しました。社員ID(PK)の重複などを確認してみて下さい。");
			}
		} catch (IOException e){
			System.out.println("登録に失敗したため異常終了しました。2");
		}
	}

	//削除依頼ファイルの内容を社員マスタテーブルに登録するメソッド
	public static void masterDelete(List<String> li2){
		try{
			//MySql関連の必要事項を入力
			String resource = "okazaki/sqlmap/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = null;
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			try {
				sqlMap.startTransaction();

				KkBean1 del = new KkBean1();
				//リスト2(削除依頼テーブルのデータ(社員ID))と社員マスタテーブル内の社員IDが合致するレコードを削除する。
				for(int i = 0; i < li2.size(); i++){
					if(i == 0){
						del.setSyainId(li2.get(i));
					} else {
						del.setSyainId(li2.get(i));
					}
					sqlMap.delete("kenkyuKadai1_1", del);
				}
				sqlMap.commitTransaction();
				System.out.println("削除依頼テーブル内で指定された社員IDと" +
						"合致するレコードを、社員マスタテーブルから削除しました。\nもしくは、指定されたデータは最初から存在しませんでした。");

			} catch (SQLException e) {
				e.printStackTrace();
				try {
					sqlMap.endTransaction();
				} catch (SQLException e3) {
					System.out.println("登録に失敗したため異常終了しました。");
				}
				try {
					sqlMap.endTransaction();
				} catch (SQLException e1) {
					System.out.println("登録に失敗したため異常終了しました。");
					try {
						sqlMap.endTransaction();
					} catch (SQLException e2) {
						System.out.println("登録に失敗したため異常終了しました。");
					}
				}
			}
		} catch (IOException e){
			System.out.println("登録に失敗したため異常終了しました。");
		}
	}
}
