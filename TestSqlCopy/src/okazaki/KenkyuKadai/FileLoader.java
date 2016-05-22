package okazaki.KenkyuKadai;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileLoader {

	public static List<String> registLoader(File file) {

		List<String> li1 = new ArrayList<String>();

		try {
			//登録依頼ファイルを読み込む
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			//読み込んだ登録ファイルを1行ずつ処理する
			String line;
			StringTokenizer token;

			while ((line = br.readLine()) != null) {
				//区切り文字","で分割してリストに保存
				token = new StringTokenizer(line, ",");

				while (token.hasMoreTokens()) {
					li1.add(token.nextToken());
				}
			}
			br.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//呼び出し元(KadaiMain)に、登録依頼ファイルのデータが格納されたリストを返す。
		return li1;
	}

	public static List<String> deleteLoader(File file2){

		List<String> li2 = new ArrayList<String>();

		try {

			//削除依頼ファイルを読み込む
			FileReader fr2 = new FileReader(file2);
			BufferedReader br2 = new BufferedReader(fr2);

			//読み込んだ削除依頼ファイルを1行ずつ処理する
			String line2;
			StringTokenizer token;

			while ((line2 = br2.readLine()) != null) {

				//区切り文字","で分割する
				token = new StringTokenizer(line2, ",");
				while (token.hasMoreTokens()) {
					li2.add(token.nextToken());
				}
			}
			br2.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//呼び出し元(KadaiMain)に削除依頼ファイルのデータが格納されたリストを返す。
		return li2;
	}
}

