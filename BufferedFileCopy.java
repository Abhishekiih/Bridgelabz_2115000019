import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String destinationFileBuffered = "copy_buffered.txt";
        String destinationFileUnbuffered = "copy_unbuffered.txt";

        long bufferedTime = copyWithBufferedStreams(sourceFile, destinationFileBuffered);
        long unbufferedTime = copyWithUnbufferedStreams(sourceFile, destinationFileUnbuffered);

        System.out.println("Buffered Streams Execution Time: " + bufferedTime + " ns");
        System.out.println("Unbuffered Streams Execution Time: " + unbufferedTime + " ns");
    }

    private static long copyWithBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Buffered Copy Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    private static long copyWithUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            System.err.println("Unbuffered Copy Error: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
