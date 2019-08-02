package other;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.util.Objects;

/**
 * 从管道读内容
 */
public class PipedRead extends Thread {
    private PipedInputStream pipedInputStream;
    private volatile OutputStream contentOutputStream;

    public PipedRead(PipedInputStream pipedInputStream, OutputStream contentOutputStream) {
        this.pipedInputStream = Objects.requireNonNull(pipedInputStream);
        this.contentOutputStream = contentOutputStream;
    }


    @Override
    public void run() {
        writeStream(pipedInputStream, contentOutputStream);
    }


    private void writeStream(InputStream inputStream, OutputStream outputStream) {
        byte[] temp = new byte[1024];
        int len;
        try {
            //当且文件结束时，才停止读取
            while ((len = inputStream.read(temp)) != -1) {
                outputStream.write(temp, 0, len);
                System.out.println(new String(temp));
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("出现异常");
        }
    }
}