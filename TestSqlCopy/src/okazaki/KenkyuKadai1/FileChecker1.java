package okazaki.KenkyuKadai1;

import java.util.List;

public class FileChecker1 {

	public static boolean registChecker(List<String> li1) {
		//登録依頼ファイルのリストの中身をfor文で回してチェック
		for(int i = 0; i < li1.size(); i++){
			//社員IDが数字3桁以外だった場合はNGとし、呼び出し元メソッドで異常終了として処理を終了するためにfalseを返す。
			if((i == 0 || i % 12 == 0) && li1.get(i).matches("^\\d{3}$") == false){
				System.out.println("不正な値です。登録依頼ファイルの社員IDが数字3桁で指定されていません。");
				return false;

				//部署IDが"B" + 数字2桁以外だった場合はNGとし、呼び出し元メソッドで異常終了として処理を終了するためにfalseを返す。
			} else if((i == 1 || (i - 1 ) % 12 == 0) && li1.get(i).matches("^[B]\\d{2}$") == false){
				System.out.println("不正な値です。登録依頼ファイルの部署IDが\"B\"+数字2桁で指定されていません。");
				return false;

				//郵便番号が数字3桁 + "-" + 数字4桁以外だった場合はNGとし、呼び出し元メソッドで異常終了として処理を終了するためにfalseを返す。
			} else if((i == 6 || (i - 6 ) % 12 == 0) && li1.get(i).matches("^\\d{3}-\\d{4}$") == false){
				System.out.println("不正な値です。登録依頼ファイルの郵便番号が数字3桁+\"-\"+数字4桁で指定されていません。");
				return false;

				//電話番号が数字3桁 + "-" + 数字4桁 + "-" + 数字4桁以外だった場合はNGとし、呼び出し元メソッドで異常終了として処理を終了するためにfalseを返す。
			} else if((i == 10 || (i - 10 ) % 12 == 0) && li1.get(i).matches("^\\d{3}-\\d{4}-\\d{4}$") == false){
				System.out.println("不正な値です。登録依頼ファイルの電話番号が数字3桁+\"-\"+数字4桁+\"-\"数字4桁で指定されていません。");
				return false;

				//身長が数字3桁 + "." + 数字3桁以外だった場合はNGとし、呼び出し元メソッドで異常終了として処理を終了するためにfalseを返す。
			} else if((i == 11 || (i + 1 ) % 12 == 0) && li1.get(i).matches("\\d{3}.\\d{3}$") == false){
				System.out.println("不正な値です。登録依頼ファイルの身長が数字3桁+\".\"+数字3桁で指定されていません。");
				return false;

			}

		}

		//登録依頼ファイルにNG項目がなかった場合に一旦ログ代わりとして下記を出力する。
		System.out.println("登録依頼ファイルは正常な書式で記述されていました");
		return true;
	}

	public static boolean deleteChecker(List<String> li2) {
		for(int i = 0; i < li2.size(); i++){
			//社員IDが数字3桁以外だった場合はNGとし、呼び出し元メソッドで異常終了として処理を終了するためにfalseを返す。
			if((i == 0 || i % 12 == 0) && li2.get(i).matches("^\\d{3}$") == false){
				System.out.println("不正な値です。削除依頼ファイルの社員IDが数字3桁で指定されていません。");
				return false;
			}
		}

		//削除依頼ファイルにNG項目がなかった場合に一旦ログ代わりとして下記を出力する。
		System.out.println("削除依頼ファイルは正常な書式で記述されていました");
		return true;
	}
}