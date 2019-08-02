package other;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CircularByteBufferTest {

    public static void main(String[] args) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byteArrayOutputStream.write("哈哈".getBytes(StandardCharsets.UTF_8));
        PipedInputStream pipedInputStream=new Piped(byteArrayOutputStream).getPipedInputStream();

        int len;
        byte temp[]=new byte[1024];
        while ((len=pipedInputStream.read(temp))>-1){
            System.out.println(new String(temp,0,len,StandardCharsets.UTF_8));
        }
        pipedInputStream.close();



    }

}
