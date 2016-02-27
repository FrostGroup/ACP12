package MyScanner;

import java.io.*;
import java.util.InputMismatchException;

public class MyScanner implements Closeable{

    private Reader reader;
    private StringBuilder dataLine;
    private char[] buffer = new char[1024];
    private int startIndex, endIndex = 0;

    public MyScanner(InputStream is) {
        reader = new InputStreamReader(is);
        read();
    }

    public MyScanner(String filePath) throws FileNotFoundException {
        reader = new InputStreamReader(new FileInputStream(new File(filePath)));
        read();
    }

    private void read(){
        dataLine = new StringBuilder();
        try {
            do {
                reader.read(buffer, 0, buffer.length);
                dataLine.append(buffer);
                endIndex++;
            } while (buffer.length != 1024);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String next() throws IOException {
        for (int i = 0; i < dataLine.length();) {
            if (dataLine.substring(i, i+1).equals(" ")) {
                return dataLine.substring(0, i);
            } else {
                i++;
            }
        }
        return String.valueOf(dataLine);
    }

    public int nextInt() throws IOException {
        if (hasNextInt()){
            for (int i = 0; i < dataLine.length();) {
                if (dataLine.substring(i, i+1).equals(" ")) {
                    return Integer.parseInt(dataLine.substring(0, i));
                } else i++;
            }
        }else throw new InputMismatchException();
        return Integer.parseInt(dataLine.toString().trim());
    }

    public String nextLine(){
        for (int i = 0; i < dataLine.length();) {
            if (dataLine.substring(i, i+1).equals(".") || dataLine.substring(i, i+1).equals("\n")) {
                return dataLine.substring(0, i);
            } else i++;
        }
        return String.valueOf(dataLine);
    }

    public boolean hasNext(){
        return dataLine.length() != 0;
    }

    public boolean hasNextInt() throws IOException {
        return Character.isDigit(buffer[0]);
    }

    private void resetBuffer(){
        dataLine = new StringBuilder();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}