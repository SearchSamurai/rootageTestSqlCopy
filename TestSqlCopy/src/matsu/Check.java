package matsu;

import java.io.File;
import java.util.regex.Pattern;

public class Check {

    private String regist;
    private String delete;
    int count;
    private boolean flag = false;

    private static Pattern checkSyainId = Pattern.compile("^[0-9]{3}");
    private static Pattern checkBusyoId = Pattern.compile("^[B][0-9]{2}");
    private static Pattern checkZipCd = Pattern.compile("^[0-9]{3}[-][0-9]{4}$");
    private static Pattern checkTelNo = Pattern.compile("^[0-9]{3}[-][0-9]{4}[-][0-9]{4}$");
    private static Pattern checkSintyou = Pattern.compile("^[0-9]{3}[.][0-9]{3}$");


    Check(String regist,String delete) {

        this.regist = regist;
        this.delete = delete;
    }

    //任意の入力ファイルに格納されている登録依頼ファイル、及び削除依頼ファイルが存在するかチェックする
    public int existFile() {

        File registFile = new File(regist);
        File deleteFile = new File(delete);

        if(!(registFile.exists() && deleteFile.exists() ) ) {

            //登録依頼ファイル、及び削除依頼ファイルが存在しなければ正常終了。
            System.out.println("ファイルは存在しません。");
            System.out.println("正常終了します。");
            System.exit(0);

        }else if(!registFile.exists() || !deleteFile.exists()) {

            //登録依頼ファイル、及び削除依頼ファイルのいずれかが存在しなければ異常終了。
            System.out.println("いずれかのファイルが存在しません。");
            System.out.println("異常終了します。");
            System.exit(0);

        }else if(registFile.exists() && deleteFile.exists()) {

            //登録依頼ファイル、及び削除依頼ファイルが両方存在した場合カウントを増やす。
            count += 1;

        }
        return count;
    }

    public boolean dataCheck(String syainId, String busyoId, String zipCd, String telNo, String sintyou){

        //登録依頼ファイルの各項目をチェックする
        if(checkSyainId.matcher(syainId).matches() && checkBusyoId.matcher(busyoId).matches() && checkZipCd.matcher(zipCd).matches()
                && checkTelNo.matcher(telNo).matches() && checkSintyou.matcher(sintyou).matches() ) {

                flag = true;
        }else {

            System.out.println("登録依頼ファイルのいずれかの項目がマッチしません。");
            System.out.println("異常終了します。");
            System.exit(0);
        }
            return flag;
    }

    public boolean dataCheck(String syainId) {

        if(checkSyainId.matcher(syainId).matches()) {
            flag = true;
        }else {

            System.out.println("削除依頼ファイルの社員番号がフォーマットにマッチしません。");
            System.out.println("異常終了します。");
            System.exit(0);
        }
            return flag;
    }

}
