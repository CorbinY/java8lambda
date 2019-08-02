package other;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Objects;

public class Piped {
    private PipedOutputStream pipedOutputStream;
    private PipedInputStream pipedInputStream;
    private ByteArrayOutputStream byteArrayOutputStream;


    public Piped(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = Objects.requireNonNull(byteArrayOutputStream);
        connect();
    }

    private void connect() {
        pipedInputStream = new PipedInputStream();
        try {
            pipedOutputStream = new PipedOutputStream(pipedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void writeToPipedOutPutStream() {
        new Thread(() -> {
            try {
                byteArrayOutputStream.writeTo(pipedOutputStream);
                byteArrayOutputStream.close();
                pipedOutputStream.flush();
                pipedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public PipedInputStream getPipedInputStream() {
        writeToPipedOutPutStream();
        return this.pipedInputStream;
    }


}
