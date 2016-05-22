package okazaki.KenkyuKadai1;
import java.io.File;
import java.util.List;

public class KadaiMain1 {
	public static void main(String[] args) {

		//登録依頼ファイルのパスを指定
		String pass = "C:\\Users\\ルーテイジ\\Desktop\\岡﨑\\研修課題【初級】\\研修課題【初級】\\資料\\テストデータサンプル\\regist_T_SYAIN_MST.csv";
		//削除依頼ファイルのパスを指定
		String pass1 = "C:\\Users\\ルーテイジ\\Desktop\\岡﨑\\研修課題【初級】\\研修課題【初級】\\資料\\テストデータサンプル\\delete_T_SYAIN_MST.csv";

		File file = new File(pass);
		File file2 = new File(pass1);

		//登録依頼ファイルと削除依頼ファイルがセットで存在するかどうかのチェック
		if (file.exists() == true && file2.exists() == true){
			System.out.println("ファイルの存在を確認しました");

			//ファイル読み込みメソッドの呼び出し。引数として登録依頼ファイルを渡す。
			//","を削除した値を格納したリストを戻り値として受け取る。
			List<String> li1 = FileLoader1.registLoader(file);
			//ファイル読み込みメソッドの呼び出し。引数として削除依頼ファイルを渡す。
			//","を削除した値を格納したリストを戻り値として受け取る。
			List<String> li2 = FileLoader1.deleteLoader(file2);

			//登録依頼ファイル(リスト1)が詳細設計書のチェック内容に基いているか確認するメソッドを呼び出す。
			//戻り値として、チェック内容に基いていればtrueを、NG項目が一つでもあればfalseを受け取る。
			boolean result = FileChecker1.registChecker(li1);

			//削除依頼ファイル(リスト2)が詳細設計書のチェック内容に基いているか確認するメソッドを呼び出す。
			//戻り値として、チェック内容に基いていればtrueを、NG項目が一つでもあればfalseを受け取る。
			boolean result2 = FileChecker1.deleteChecker(li2);

			//登録依頼ファイルと削除依頼ファイルが両方ともチェック内容に基いていれば処理を続行する。
			if(result == true && result2 == true){

				//登録依頼ファイルから読み込んだデータを社員マスタテーブルに登録する。
				RegistAndDelete1.masterRegist(li1);

				//削除依頼ファイルから読み込んだデータと社員マスタテーブルの社員IDが一致するデータを
				//社員マスタテーブルから削除する。
				RegistAndDelete1.masterDelete(li2);

				//resultとresult2がfalseだった場合
				//(登録依頼ファイルと削除依頼ファイルの両方にNG項目があった場合)、異常終了として処理を終了する。
			} else if(result == false && result2 == false){
				System.out.println("登録依頼ファイルと削除依頼ファイルの両方にNGデータが存在したため、異常終了しました");

				//resultがfalseだった場合(登録依頼ファイルにNG項目があった場合)、異常終了として処理を終了する。
			} else if(result == false && result2 == true){
				System.out.println("登録依頼ファイルにNGデータが存在したため、異常終了しました");

				//result2がfalseだった場合(削除依頼ファイルにNG項目があった場合)、異常終了として処理を終了する。
			} else if(result == true && result2 == false){
				System.out.println("削除依頼ファイルにNGデータが存在したため、異常終了しました");
			}

			//登録依頼ファイルと削除依頼ファイルが両方とも無い場合、正常終了として処理を終了する。
		} else if (file.exists() == false && file2.exists() == false) {
			System.out.println("ファイルが両方とも見つからなかったため正常終了しました");

			//登録依頼ファイルと削除依頼ファイルどちらか片方が無い場合、異常終了として処理を終了する。
		} else if (file.exists() == false && file2.exists() == true){
			System.out.println("登録依頼ファイルが見つかりません。異常終了します。");

		} else if(file.exists() == true && file2.exists() == false){
			System.out.println("削除依頼ファイルが見つからなかったため、異常終了しました");
		}
	}
}