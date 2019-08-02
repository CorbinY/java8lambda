//package other;
//
//
//import java.io.*;
//import java.util.Objects;
//import java.util.concurrent.Callable;
//
///**
// * 使用管道的方式，一边进行流的写入，一边进行数据的读取，
// * 减少内存占用
// *
// * @author yin
// * @date 2019/07/30
// */
//public class JavaStreamUtil implements Callable<OutputStream> {
//    /**
//     * 定义流的转换状态是否完成
//     */
//    private static boolean converStatus = false;
//
//    private InputStream inputStream;
//    private OutputStream outputStream;
//
//    public JavaStreamUtil(InputStream inputStream, OutputStream outputStream) {
//        this.inputStream = inputStream;
//        this.outputStream = outputStream;
//    }
//
//    /**
//     * 流转换
//     *
//     * @param inputStream
//     * @return
//     */
//    private void inputStream2OutputStream(InputStream inputStream, OutputStream outputStream) {
//        PipedInputStream in = new PipedInputStream();
//        PipedOutputStream out = new PipedOutputStream();
//
//        PipedWrite pipedWrite = new PipedWrite(out, inputStream);
//        PipedRead pipedRead = new PipedRead(in, outputStream);
//        try {
//            in.connect(out);
//            pipedWrite.start();
//            pipedRead.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public OutputStream call() {
//        inputStream2OutputStream(inputStream, outputStream);
//        while (converStatus) {
//            try {
//                Thread.currentThread().wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return this.outputStream;
//    }
//
//
//}
//
//
