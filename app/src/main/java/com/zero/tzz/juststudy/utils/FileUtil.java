package com.zero.tzz.juststudy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
    /**
     *
     * @param src
     * @param dest
     * @throws IOException
     */

    public static void CopyFile(File src, File dest) throws IOException {
        InputStream is=null;
        OutputStream os = null;
        File destSecond=null;
        if(dest.isDirectory()){ //如果目标是一个文件夹，那么就在该dest文件夹下建立一个新的文件类型
            destSecond = new File(dest,src.getName()); //这一步如何制定文件的格式，因为单独的文件拷贝要指定双方的文件类型
            //实现文件拷文件夹中去

            os = new FileOutputStream(destSecond); //实现拷文件操作
        }else{
            //如果是个文件的话，直接拷贝
            os =new FileOutputStream(dest);
        }
        try {
            is = new FileInputStream(src);


            byte[] by = new byte[1024];//准备车子
            int len=0; //假设车上没有人

            try {
                while(-1!=(len=is.read(by))){ //开始慢慢下车和上车
                    os.write(by, 0, len); //下车
                }
            } catch (IOException e) {
                e.printStackTrace();

            }finally{
                os.flush();
                is.close();
                os.close();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        }
    }
    /**
     *
     * @param srcPath
     * @param destPath
     * @throws IOException
     */
    public static void CopyFile(String srcPath,String destPath) throws IOException{
        CopyFile(new File(srcPath), new File(destPath));
    }

    /**
     * 文件夹的拷贝
     * @param src
     * @param dest
     */
    public static void copyDir(String src,String dest){
        File srcPath =new File(src);
        File destPath = null;
        if(srcPath.isDirectory()){
            destPath = new File(dest,srcPath.getName());//如果源文件是个文件夹，那么现在目标文件夹下再建一个一样的文件夹
        }

        copyDirDetail(srcPath,destPath);
    }

    public static void copyDirDetail(File srcPath,File destPath){
        if(srcPath.isFile()){ //为下级做准备，这级估计用不到
            try {
                FileUtil.CopyFile(srcPath, destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(srcPath.isDirectory()){
            destPath.mkdir();//，建立它，确保目标文件夹存在
            File[] filelist = srcPath.listFiles();
            for(File file:filelist){
                copyDirDetail(file,new File(destPath,file.getName()));
            }
        }
    }
}