import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cn.hutool.json.JSONObject;

/**
 功能: 将文件层级转为JSON格式数据<br>
 第三方库: 使用了hutool库, Util/lib/hutool-all-5.8.10.jar<br>
 输入: main函数第一行的filePath为要转换的目录<br>
 输出: 在filePath目录下生成videoList.json文件(如果不存在则创建,存在则重写内容)<br>
 */
public class ChangeToJson {
    public static void main(String[] args) throws IOException {

        String filePath = "E:\\ideaProject\\kepu\\public\\videos"; // 文件路径

        System.out.println("开始转换");
        JSONObject json = convert(filePath);
        System.out.println("转换完成,结果为:\n"+json);

        File file = new File(filePath + "\\videoList.json");
        file.createNewFile();

        System.out.println("开始写入");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(json.toString());
        writer.close();
        System.out.println("执行完毕");
    }

    /**
     将目录转换为JSON对象
     * @param filePath 要转换的目录
     * @return 返回转换后的JSON对象
     * @throws IllegalArgumentException 输入的应为真实存在的目录
     */
    public static JSONObject convert(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("转换过程出现错误,输入的目录不存在或者不是文件夹");
        }
        JSONObject json = new JSONObject();
        convertFileToJson(file, json);//真正的转换函数
        return json;
    }

    /**
     递归函数:
     * @param file 一个目录
     * @param parentJson json对象容器,转换的结果存储到这个对象中
     */
    private static void convertFileToJson(File file, JSONObject parentJson) {
        File[] files = file.listFiles();
        if (files == null) return;

        for (File childFile : files) {//遍历子文件或文件夹
            if (childFile.isDirectory()) {//如果是文件夹,则递归调用自身进行转
                JSONObject childJson = new JSONObject();
                convertFileToJson(childFile, childJson);
                parentJson.put(childFile.getName(), childJson);
            } else if (childFile.getName().endsWith(".mp4")) {//如果是mp4文件,则添加到videos项中
                parentJson.append("videos", childFile.getName());
            }
        }
    }
}
