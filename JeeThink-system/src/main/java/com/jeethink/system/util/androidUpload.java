package com.jeethink.system.util;

import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class androidUpload {
    public static String upload(String file){
        /*String destDir = "/android";*/
        String imgByte=file;
        imgByte=imgByte.replaceAll("data:image/png;base64,","");
        BASE64Decoder decoder =  new BASE64Decoder();
        byte[] imageByte = null;
        try{
            imageByte = decoder.decodeBuffer(imgByte);
            for (int i = 0; i < imageByte.length; ++i) {
                if (imageByte[i] < 0) {// 调整异常数据
                    imageByte[i] += 256;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (imageByte.length>0) {
            try {
                //获取文件上传的真实路径E:\demo\JeeThink-admin\src\main\java\com\jeethink\web\profile\web
                String uploadPath = "C:\\demo";//request.getSession().getServletContext().getRealPath("/")
                //保存文件的路径
                String filepath =  File.separator + createNewDir();
              //  System.out.println("保存文件的路径："+filepath);
                File destfile = new File(uploadPath + filepath);
              //  System.out.println("获取文件上传的真实路径："+uploadPath);
                if (!destfile.exists()) {
                    destfile.mkdirs();
                }
                //文件新名称
                String fileNameNew = getFileNameNew() + ".png";
                File f = new File(destfile.getAbsoluteFile() + File.separator + fileNameNew);
                // 将字符串转换成二进制，用于显示图片
                // 将上面生成的图片格式字符串 imgStr，还原成图片显示
                InputStream in = new ByteArrayInputStream(imageByte);
                FileOutputStream fos = new FileOutputStream(f);
                // BufferedOutputStream bos = new BufferedOutputStream(fos);
                byte[] buf = new byte[1024];
                int length;
                length = in.read(buf, 0, buf.length);

                while (length != -1) {
                    fos.write(buf,0,length);
                    length = in.read(buf);
                }
                fos.flush();
                fos.close();
                in.close();
                String lastpath = filepath + File.separator + fileNameNew;
               // System.out.println("返回图片路径：" + fileNameNew);
                return createNewDir2()+fileNameNew;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }

        }
        return null;
    }
    private static String getFileNameNew() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return fmt.format(new Date());
    }

    /**
     * 以当前日期为名，创建新文件夹
     *
     * @return
     */
    private static String createNewDir() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy\\MM\\dd");
        return "avatar\\"+fmt.format(new Date());
    }
    private static String createNewDir2() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        return "/profile/avatar/"+fmt.format(new Date())+"/";
    }

    public static void main(String[] args) {
       // System.err.println(createNewDir2());
    }
}
