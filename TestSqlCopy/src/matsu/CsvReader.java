package matsu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private InputStream stream;
    private List<List<String>> csvData;

    /** 文字コード (default:UTF-8) */
    private String encode = "UTF-8";
    /** CSV区切り文字 (カンマ) */
    private static final String separator = ",";
    /** ダブルクォート */
    private static final String enclose = "\"";

    /**
     * コンストラクタ
     * @param stream CSVデータを格納したInputStream
     * @throws Exception
     */
    public CsvReader(InputStream stream) throws Exception{
        this.setStream(stream);
    }

    /**
     * コンストラクタ
     * @param stream CSVデータを格納したInputStream
     * @param encode 文字コード指定文字列("MS932","UTF-8" 等)
     * @throws Exception
     */
    public CsvReader(InputStream stream, String encode) throws Exception{
        this.setStream(stream);
        this.setEncode(encode);
    }

    /**
     * CSVデータを格納したInputStreamを設定します。
     * @param stream setter
     */
    private void setStream(InputStream stream){
        this.stream = stream;
    }

    /**
     * <pre>
     * CSV読み込み時の文字コードを指定します。
     * 設定されない場合、UTF-8で読み込まれます。
     * </pre>
     * @param encode
     */
    public void setEncode(String encode){
        this.encode = encode;
    }

    /**
     * CSVデータを取得します。
     * @return CSVデータ
     * @throws Exception
     */
    public List<List<String>> getRows() throws Exception{
        if (csvData == null){
            this.readCsvData();
        }
        return csvData;
    }

    /**
     * CSVデータから指定された行のデータを取得します。
     * @param rowNo
     * @return CSVデータの指定行のデータ
     * @throws Exception
     */
    public List<String> getRow(int rowNo) throws Exception{
        if (csvData == null){
            this.readCsvData();
        }
        return csvData.get(rowNo);
    }

    /**
     * <pre>
     * CSVデータを読み込みcsvDataに格納します。
     * 初回のデータ取得時(getRowsメソッドまたはgetRowメソッドの呼出時)
     * に呼び出されるメソッドです。
     * </pre>
     * @throws IOException
     */
    private void readCsvData() throws Exception{

        csvData = new ArrayList<List<String>>();

        BufferedReader buffer = null;
        try{

            buffer = getBufferedReader();

            String line;
            while ((line = buffer.readLine()) != null) {
                csvData.add(getCsvLineList(line));
            }

        }finally{
            if (buffer != null){
                buffer.close();
            }
        }
    }

    /**
     * CSVデータをバッファリングします。
     * @param stream
     * @return
     * @throws Exception
     */
    private BufferedReader getBufferedReader() throws Exception{
        return new BufferedReader(new InputStreamReader(this.stream,this.encode));
    }

    /**
     * CSVデータの１行分の文字列を解析しリストに格納して返却します。
     * @param csvLine １行分の文字列
     * @return １行分のデータの解析結果を格納したList
     */
    private List<String> getCsvLineList(String csvLine){

        List<String> list = new ArrayList<String>();

        int charCnt = 0;
        int charIdx = 0;

        StringBuilder builder = new StringBuilder();
        while (charCnt < csvLine.length())
        {

            boolean isDoubleQuote =
                csvLine.substring(charCnt, charCnt+1).equals(enclose);

            if (isDoubleQuote) ++charCnt;

            charIdx = csvLine.indexOf(isDoubleQuote
                                        ? enclose
                                        : separator , charCnt);

            if (charIdx < 0) {
                charIdx = csvLine.length();
            }

            String workStr = csvLine.substring(charCnt, charIdx);

            if (isDoubleQuote
                && charIdx < csvLine.length() - 1
                && csvLine.substring(charIdx + 1, charIdx + 2).equals(enclose)){
                // 文字列内のクォートと判断
                builder.append(workStr);
                builder.append(enclose);
                charCnt = charIdx + 1;

            }else{
                list.add(builder.toString() + workStr);
                builder.setLength(0);
                charCnt = charIdx + (isDoubleQuote ? 2 : 1);
            }

            // 最後の文字が"SEPARATOR" modify:2008.04.16
            if (csvLine.length() == charCnt) {
                String lastStr = csvLine.substring(charCnt - 1, charCnt);
                if (lastStr.equals(separator)) {
                    list.add("");
                }

            }
        }

        return list;
    }
}

