package other;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public class Pipedmain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        InputStream inputStream = new ByteArrayInputStream("上传成功".getBytes(StandardCharsets.UTF_8));
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//
//
//        FutureTask<OutputStream> futureTask = new FutureTask<>(new JavaStreamUtil(inputStream, byteArrayOutputStream));
//        futureTask.run();
//
//             Thread.currentThread().sleep(1000);
//        System.out.println((new String(((ByteArrayOutputStream) futureTask.get()).toByteArray())));


        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        InputStream inputStream = new ByteArrayInputStream("上传成功".getBytes(StandardCharsets.UTF_8));

        PipedWrite pipedWrite = new PipedWrite(out, inputStream);
        PipedRead pipedRead = new PipedRead(in, outputStream);
        try {
            in.connect(out);
            pipedWrite.start();
            pipedRead.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(new String(outputStream.toByteArray()));

    }
}
