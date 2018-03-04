import java.io.*;
import java.util.*;

public class readfile {

    public static List<String> readTxtFile(String filePath){
        try {
            List<String> word_list = new ArrayList<>();
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    word_list.add(lineTxt);
                }
                read.close();
                return word_list;
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();

        }
        return Collections.emptyList();
    }

}
