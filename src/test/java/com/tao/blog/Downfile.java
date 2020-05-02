package com.tao.blog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class Downfile {
	
	static String lujing="http://ww4.sinaimg.cn/bmiddle/8f582d77gw1eo9e9rmkatg20bu0cfx6r.gif";
    static String downlujing="/Users/tao/Desktop";


    public static void main(String[] args) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();// 创建默认http连接
        HttpGet post = new HttpGet(lujing);// 创建一个get请求
        HttpResponse response = client.execute(post);// 用http连接去执行get请求并且获得http响应

        org.apache.http.HttpEntity entity = response.getEntity();// 从response中取到响实体
        String lassName = Downfile.lassName(lujing);
        boolean createDir = Downfile.createDir(downlujing);
        File f = new File(downlujing+lassName);
        OutputStream out = new FileOutputStream(f);// 如果文件不存在会自动创建
        entity.writeTo(out);
        out.flush();
        out.close();
        System.out.println("下载完成本地完成");
    }

    // 获取url路径结尾文件皆为名字
    public static String lassName(String all) {

        int gang = 0;
        for (int i = all.length() - 1; i > 0; i--) {
            char charAt = all.charAt(i);
            String valueOf = String.valueOf(charAt);
            if (valueOf.equals("/")) {
                gang = i;
//              System.out.println("/" + i);
                break;
            }
        }
        String substring2 = all.substring(gang + 1);
        return substring2;

    }
    //创建目录
     public static boolean createDir(String destDirName) {  
            File dir = new File(destDirName);  
            if (dir.exists()) {  
                System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");  
                return false;  
            }  
            if (!destDirName.endsWith(File.separator)) {  
                destDirName = destDirName + File.separator;  
            }  
            //创建目录  
            if (dir.mkdirs()) {  
                System.out.println("创建目录" + destDirName + "成功！");  
                return true;  
            } else {  
                System.out.println("创建目录" + destDirName + "失败！");  
                return false;  
            }  
        }  

}
