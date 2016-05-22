package matsu;

import java.io.FileInputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import matsu.entity.CheckBean;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class FileCheck {

    //deleteファイルが格納してあるディレクトリ
    private  static final  String DELETE_FILE = "C:\\Documents and Settings\\Rootage\\デスクトップ\\java課題\\研修課題【初級】\\資料\\テストデータサンプル\\delete_T_SYAIN_MST.csv";

    //registファイルが格納してあるディレクトリ
    private static final  String REGIST_FILE = "C:\\Documents and Settings\\Rootage\\デスクトップ\\java課題\\研修課題【初級】\\資料\\テストデータサンプル\\regist_T_SYAIN_MST.csv";

    private static final  String encode = "UTF-8"; //encodeをUTF-8

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        boolean chechRegist = false;


        String syainId; //社員ID
        String busyoId; //部署ID
        String zipCd;   //郵便番号
        String telNo;   //電話番号
        String sintyou; //身長

        List<List<String>> registOrderFile = new ArrayList<List<String>>();
        List<List<String>> deleteOrderFile = new ArrayList<List<String>>();

        //ファイルが存在するか確認する
        Check check = new Check(REGIST_FILE,DELETE_FILE);
        int flag = check.existFile();

        //ファイルが両方存在した場合、登録依頼ファイルからデータを読み込み、指定された項目をチェックする。
        if(flag > 0){
            FileInputStream fis = new FileInputStream(REGIST_FILE);
            CsvReader csv = new CsvReader(fis,encode);

            //登録依頼ファイルの全ての行を取得する。
            registOrderFile = csv.getRows();

            //各項目のチェックをする
            for(int i =0; i < registOrderFile.size(); i++) {

                //チェックする項目を取得する
                syainId = registOrderFile.get(i).get(0); //社員番号の取得
                busyoId = registOrderFile.get(i).get(1); //部署番号の取得
                zipCd = registOrderFile.get(i).get(6); //郵便番号の取得
                telNo = registOrderFile.get(i).get(10); //電話番号の取得
                sintyou = registOrderFile.get(i).get(11); //身長の取得

                //System.out.println("社員番号:" + syainId + "部署番号:" + busyoId + "郵便番号:" + zipCd + "電話番号:" + telNo + "身長" + sintyou );

                //各項目のフォーマットチェック
                chechRegist = check.dataCheck(syainId, busyoId, zipCd, telNo, sintyou);

            }

            //System.out.println(chechRegist);
        }

        if(chechRegist){

            FileInputStream fis = new FileInputStream(DELETE_FILE);
            CsvReader csv = new CsvReader(fis,encode);

            deleteOrderFile = csv.getRows();

            syainId = deleteOrderFile.get(0).get(0); //社員番号の取得

            chechRegist = check.dataCheck(syainId);

        }

        SqlMapClient sqlMap = null;

        try {
            String resource = "matsu/sqlmap/SqlMapConfig.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
            sqlMap.startTransaction();

            for(int i =0; i < registOrderFile.size(); i++) {

                //登録する項目を取得する
                syainId = registOrderFile.get(i).get(0); //社員番号の取得
                busyoId = registOrderFile.get(i).get(1); //部署番号の取得
                zipCd = registOrderFile.get(i).get(6); //郵便番号の取得
                telNo = registOrderFile.get(i).get(10); //電話番号の取得
                sintyou = registOrderFile.get(i).get(11); //身長の取得

                //郵便番号と電話番号のハイフンを空白に置換する
                zipCd = zipCd.replaceAll("-", "");
                telNo = telNo.replaceAll("-", "");

                System.out.println("社員番号:" + syainId + "部署番号:" + busyoId + "郵便番号:" + zipCd + "電話番号:" + telNo + "身長" + sintyou );

                CheckBean cb = new CheckBean();
                cb.setSyainId(syainId);
                cb.setBusyoId(busyoId);
                cb.setZipCd(zipCd);
                cb.setTelNo(telNo);
                cb.setSintyou(sintyou);

                sqlMap.insert("registFile",cb);

                if(i == registOrderFile.size() -1) {

                    //登録時に異常がなければコミットする。
                    sqlMap.commitTransaction();
                    System.out.println("データを登録しました。");
                }

            }

            for(int j = 0; j < deleteOrderFile.size(); j++) {

                syainId = deleteOrderFile.get(j).get(0);

                CheckBean cb = new CheckBean();
                cb.setSyainId(syainId);
                System.out.println("社員番号:" + syainId + "を削除します。");
                sqlMap.delete("deleteFile", cb);

                if(j == deleteOrderFile.size() -1) {

                    //削除時に異常がなければコミットする。
                    sqlMap.commitTransaction();
                    System.out.println("データを削除しました。");
                }
            }

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
