package jtool;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Administrator on 2017/2/19.
 */
public class JFile {
    public static final String FILE_EXTENSION_SEPARATOR = ".";

    private JFile() {
        throw new AssertionError();
    }

    public static String readFile(String filePath) {
        return readFile(filePath, "UTF-8");
    }

    public static String readFile(String filePath, String charsetName) {
        File file = new File(filePath);
        try {
            return readFile(file, charsetName).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String readFile(File file) {
        try {
            return readFile(file, "UTF-8").toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static StringBuilder readFile(File file, String charsetName) throws Exception {
        StringBuilder fileContent = new StringBuilder("");
        if (file != null && file.isFile()) {
            BufferedReader reader = null;

            StringBuilder var8;
            try {
                InputStreamReader e = new InputStreamReader(new FileInputStream(file), charsetName);
                reader = new BufferedReader(e);

                for (String line = null; (line = reader.readLine()) != null; fileContent.append(line)) {
                    if (!fileContent.toString().equals("")) {
                        fileContent.append("\r\n");
                    }
                }

                reader.close();
                var8 = fileContent;
            } catch (IOException var15) {
                throw new RuntimeException("IOException occurred. ", var15);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException var14) {
                        throw new RuntimeException("IOException occurred. ", var14);
                    }
                }

            }

            return var8;
        } else {
            throw new Exception("file null or notFile");
        }
    }

    /**
     * 读取文件
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static byte[] readBytes(String filename) throws IOException {

        File f = new File(filename);
        if (!f.exists()) {
            throw new FileNotFoundException(filename);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    public static boolean writeFile(String filePath, String content, boolean append) {
        if (content == null) {
            content = "";
        }
        FileWriter fileWriter = null;
        try {
            makeDirs(filePath);
            fileWriter = new FileWriter(filePath, append);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException var12) {
            throw new RuntimeException("IOException occurred. ", var12);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException var11) {
                    throw new RuntimeException("IOException occurred. ", var11);
                }
            }
        }
        return true;
    }

    public static boolean writeFile(String filePath, List<String> contentList, boolean append) {
        if (JArray.isEmpty(contentList)) {
            return false;
        } else {
            FileWriter fileWriter = null;

            try {
                makeDirs(filePath);
                fileWriter = new FileWriter(filePath, append);
                int e = 0;

                String line;
                for (Iterator var6 = contentList.iterator(); var6.hasNext(); fileWriter.write(line)) {
                    line = (String) var6.next();
                    if (e++ > 0) {
                        fileWriter.write("\r\n");
                    }
                }

                fileWriter.close();
                return true;
            } catch (IOException var14) {
                throw new RuntimeException("IOException occurred. ", var14);
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException var13) {
                        throw new RuntimeException("IOException occurred. ", var13);
                    }
                }

            }
        }
    }

    public static boolean writeFile(String filePath, String content) {
        return writeFile(filePath, content, false);
    }

    public static boolean writeFile(String filePath, List<String> contentList) {
        return writeFile(filePath, contentList, false);
    }

    public static boolean writeFile(String filePath, InputStream stream) {
        return writeFile(filePath, stream, false);
    }

    public static boolean writeFile(String filePath, InputStream stream, boolean append) {
        return writeFile(filePath != null ? new File(filePath) : null, stream, append);
    }

    public static boolean writeFile(File file, InputStream stream) {
        return writeFile(file, stream, false);
    }

    public static boolean writeFile(File file, InputStream stream, boolean append) {
        FileOutputStream o = null;

        try {
            makeDirs(file.getAbsolutePath());
            o = new FileOutputStream(file, append);
            byte[] e = new byte[1024];
            boolean length = true;

            int length1;
            while ((length1 = stream.read(e)) != -1) {
                o.write(e, 0, length1);
            }

            o.flush();
            return true;
        } catch (FileNotFoundException var14) {
            throw new RuntimeException("FileNotFoundException occurred. ", var14);
        } catch (IOException var15) {
            throw new RuntimeException("IOException occurred. ", var15);
        } finally {
            if (o != null) {
                try {
                    o.close();
                    stream.close();
                } catch (IOException var13) {
                    throw new RuntimeException("IOException occurred. ", var13);
                }
            }

        }
    }

    public static void moveFile(String sourceFilePath, String destFilePath) {
        if (!sourceFilePath.isEmpty() && !destFilePath.isEmpty()) {
            moveFile(new File(sourceFilePath), new File(destFilePath));
        } else {
            throw new RuntimeException("Both sourceFilePath and destFilePath cannot be null.");
        }
    }

    public static void moveFile(File srcFile, File destFile) {
        boolean rename = srcFile.renameTo(destFile);
        if (!rename) {
            copyFile(srcFile.getAbsolutePath(), destFile.getAbsolutePath());
            delete(srcFile.getAbsolutePath());
        }

    }

    public static boolean copyFile(String sourceFilePath, String destFilePath) {
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(sourceFilePath);
        } catch (FileNotFoundException var4) {
            throw new RuntimeException("FileNotFoundException occurred. ", var4);
        }

        return writeFile((String) destFilePath, (InputStream) inputStream);
    }

    public static List<String> readFileToList(String filePath, String charsetName) {
        File file = new File(filePath);
        ArrayList fileContent = new ArrayList();
        if (file != null && file.isFile()) {
            BufferedReader reader = null;

            try {
                InputStreamReader e = new InputStreamReader(new FileInputStream(file), charsetName);
                reader = new BufferedReader(e);
                String line = null;

                while ((line = reader.readLine()) != null) {
                    fileContent.add(line);
                }

                reader.close();
                ArrayList var8 = fileContent;
                return var8;
            } catch (IOException var15) {
                throw new RuntimeException("IOException occurred. ", var15);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException var14) {
                        throw new RuntimeException("IOException occurred. ", var14);
                    }
                }

            }
        } else {
            return null;
        }
    }

    public static String getFileNameWithoutExtension(String filePath) {
        if (JString.isEmpty(filePath)) {
            return filePath;
        } else {
            int extenPosi = filePath.lastIndexOf(".");
            int filePosi = filePath.lastIndexOf(File.separator);
            return filePosi == -1 ? (extenPosi == -1 ? filePath : filePath.substring(0, extenPosi)) : (extenPosi == -1 ? filePath.substring(filePosi + 1) : (filePosi < extenPosi ? filePath.substring(filePosi + 1, extenPosi) : filePath.substring(filePosi + 1)));
        }
    }

    public static String getFileName(String filePath) {
        if (JString.isEmpty(filePath)) {
            return filePath;
        } else {
            int filePosi = filePath.lastIndexOf(File.separator);
            return filePosi == -1 ? filePath : filePath.substring(filePosi + 1);
        }
    }

    public static String getFolderName(String filePath) {
        if (JString.isEmpty(filePath)) {
            return filePath;
        } else {
            int filePosi = filePath.lastIndexOf(File.separator);
            return filePosi == -1 ? "" : filePath.substring(0, filePosi);
        }
    }

    public static String getFileExtension(String filePath) {
        if (JString.isBlank(filePath)) {
            return filePath;
        } else {
            int extenPosi = filePath.lastIndexOf(".");
            int filePosi = filePath.lastIndexOf(File.separator);
            return extenPosi == -1 ? "" : (filePosi >= extenPosi ? "" : filePath.substring(extenPosi + 1));
        }
    }

    public static boolean makeDirs(String filePath) {
        String folderName = getFolderName(filePath);
        if (JString.isEmpty(folderName)) {
            return false;
        } else {
            File folder = new File(folderName);
            return folder.exists() && folder.isDirectory() ? true : folder.mkdirs();
        }
    }

    public static boolean isFileExist(String filePath) {
        if (JString.isBlank(filePath)) {
            return false;
        } else {
            File file = new File(filePath);
            return file.exists() && file.isFile();
        }
    }

    public static boolean isFolderExist(String directoryPath) {
        if (JString.isBlank(directoryPath)) {
            return false;
        } else {
            File dire = new File(directoryPath);
            return dire.exists() && dire.isDirectory();
        }
    }

    public static boolean delete(String path) {
        if (JString.isBlank(path)) {
            return true;
        } else {
            File file = new File(path);
            if (!file.exists()) {
                return true;
            } else if (file.isFile()) {
                return file.delete();
            } else if (!file.isDirectory()) {
                return false;
            } else {
                File[] var5;
                int var4 = (var5 = file.listFiles()).length;

                for (int var3 = 0; var3 < var4; ++var3) {
                    File f = var5[var3];
                    if (f.isFile()) {
                        f.delete();
                    } else if (f.isDirectory()) {
                        delete(f.getAbsolutePath());
                    }
                }

                return file.delete();
            }
        }
    }

    public static long getFileSize(String path) {
        if (JString.isBlank(path)) {
            return -1L;
        } else {
            File file = new File(path);
            return file.exists() && file.isFile() ? file.length() : -1L;
        }
    }

    /**
     * 获取文件SHA1摘要值
     *
     * @return
     */
    public static String getSHA1(String path) throws Exception {
        InputStream fileInputStream = new FileInputStream(new File(path));
        // 缓冲区大小
        int bufferSize = 256 * 1024;
        DigestInputStream digestInputStream = null;
        try {
            // 拿到一个SHA1转换器（这里可以换成MD5）
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            // 使用DigestInputStream
            digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
            // read的过程中进行SHA1处理，直到读完文件
            byte[] buffer = new byte[bufferSize];
            while (digestInputStream.read(buffer) > 0) ;
            // 获取最终的MessageDigest
            messageDigest = digestInputStream.getMessageDigest();
            // 拿到结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
            // 把字节数组转换成字符串
            return byteArrayToHex(resultByteArray);
        } catch (Exception e) {
            return null;
        } finally {
            try {
                digestInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {

            }
        }
    }

    /**
     * 将字节数组换成成16进制的字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteArrayToHex(byte[] byteArray) {
        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray = new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }


}
