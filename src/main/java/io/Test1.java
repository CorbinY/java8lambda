package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/**
 * 用于把OutputStream 转化为 InputStream。
 * 适合于数据量不大，且内存足够全部容纳这些数据的情况。
 *
 */
public class Test1 {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bs0 = new byte[] { 1, 2, 3, 4, 5 };
        out.write(bs0);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

        byte[] bs = new byte[1024];
        int len = in.read(bs);
        for (int i = 0; i < len; i++) {
            System.out.println(bs[i]);
        }
    }
}