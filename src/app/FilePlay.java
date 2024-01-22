package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class demonstrates file copying functionality.
 */
public class FilePlay {

    /**
     * The main method that calls the copyFile() method and handles exceptions.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Call method to read/write files and display any errors
            FilePlay.copyFile("InUsers4.txt", "OutUsers4.txt");
            System.out.println("File was copied successfully.");
        } catch (FileNotFoundException e) {
            // Catch file not found error
            e.printStackTrace();
            System.out.println("File could not be copied. File not found.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File I/O error.");
        }
    }

    /**
     * Copies the contents of one file to another, modifying the format in the process.
     * @param inputFilename The input file to read from.
     * @param outputFilename The output file to write to.
     * @throws FileNotFoundException If the input file is not found.
     * @throws IOException If an I/O error occurs.
     */
    private static void copyFile(String inputFilename, String outputFilename) throws FileNotFoundException, IOException {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            // Create BufferedReader and BufferedWriter instances
            in = new BufferedReader(new FileReader(inputFilename));
            out = new BufferedWriter(new FileWriter(outputFilename));

            // Loop to read all lines from BufferedReader and write to BufferedWriter
            String line;
            while ((line = in.readLine()) != null) {
                // Split the line into tokens using the pipe delimiter
                String[] tokens = line.split("\\|");

                // Format and write the modified line to the output file
                out.write(String.format("Name is %s %s of age %s\n", tokens[0], tokens[1], tokens[2]));
            }
        } finally {
            // Close BufferedReader and BufferedWriter in the finally block
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}