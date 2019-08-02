package other;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.util.Objects;

/**
 * 向管道写内容,管道输出流
 */
class PipedWrite extends Thread {
    private PipedOutputStream pipedOutputStream;
    private InputStream contentInputStream;

    public PipedWrite(PipedOutputStream pipedOutputStream, InputStream contentInputStream) {
        this.pipedOutputStream = Objects.requireNonNull(pipedOutputStream);
        this.contentInputStream = Objects.requireNonNull(contentInputStream);
    }

    /**
     * 将内容写到管道输出流中
     */
    @Override
    public void run() {
        writeStream(contentInputStream, pipedOutputStream);
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
