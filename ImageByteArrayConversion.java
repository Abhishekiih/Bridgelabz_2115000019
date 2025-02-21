import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destinationImage = "copy.jpg";

        byte[] imageBytes = readImageToByteArray(sourceImage);
        if (imageBytes != null) {
            writeByteArrayToImage(imageBytes, destinationImage);
            System.out.println("Image successfully copied.");
        }
    }

    private static byte[] readImageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();

        } catch (IOException e) {
            System.err.println("Error reading image: " + e.getMessage());
            return null;
        }
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String destinationPath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.err.println("Error writing image: " + e.getMessage());
        }
    }
}
