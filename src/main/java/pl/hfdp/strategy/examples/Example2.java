package pl.hfdp.strategy.examples;

import java.io.*;
import java.net.InetAddress;

class Server {

    public static void writeHostname(Writer w) throws IOException {
        String hostname = InetAddress.getLocalHost().getHostName();
        w.write(hostname);
        w.flush();
    }
}


public class Example2 {

    public static Writer getFileWriter() throws IOException {
        File file = new File("all_hostname.txt");
        boolean created = file.createNewFile();
        if (created) {
            return new FileWriter(file);
        }
        throw new IOException("cannot create a new file");
    }

    public static Writer getStandardOutput() {
        return new OutputStreamWriter(System.out);
    }


    public static void main(String[] args) throws IOException {
        Writer soWriter = getStandardOutput();
        Server.writeHostname(soWriter);
        Writer fileWriter = getFileWriter();
        Server.writeHostname(fileWriter);
    }

}
