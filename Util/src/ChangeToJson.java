import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cn.hutool.json.JSONObject;

import java.util.*;

/**
 Function: 将文件层级转为JSON格式数据<br>
 USing: 使用hutool库<br>
 RUN: 在Java项目中运行<br>
 */
public class ChangeToJson {
    public static void main(String[] args) throws IOException {
        String filePath = "E:\\ideaProject\\kepu\\public\\videos"; // 替换为您的文件路径
        System.out.println("开始转换");
        JSONObject json = convertFileHierarchyToJson(filePath);
        System.out.println(json);
        File file = new File(filePath + "\\videoList.json");
        file.createNewFile();
        System.out.println("开始写入");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(json.toString());
        writer.close();
        System.out.println("完成");
    }

    public static JSONObject convertFileHierarchyToJson(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("Invalid file directory");
        }
        JSONObject json = new JSONObject();
        convertFileToJson(file, json);
        return json;
    }

    private static void convertFileToJson(File file, JSONObject parentJson) {
        File[] files = file.listFiles();
        if (files == null) return;

        for (File childFile : files) {
            if (childFile.isDirectory()) {
                JSONObject childJson = new JSONObject();
                convertFileToJson(childFile, childJson);
                parentJson.put(childFile.getName(), childJson);
            } else if (childFile.getName().endsWith(".mp4")) {
                parentJson.append("videos", childFile.getName());
            }
        }
    }
}
