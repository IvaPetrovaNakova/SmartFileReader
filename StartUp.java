package io;

import javax.swing.*;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;

public class StartUp {
    private static final int ERROR = JFileChooser.ERROR_OPTION;
    private static final int APPROVE = JFileChooser.APPROVE_OPTION;
    private static final int CANCEL = JFileChooser.CANCEL_OPTION;

    public static void main(String[] args) throws IOException {

        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int result = fileChooser.showOpenDialog(null);
        if (!(result == APPROVE)) {
            System.exit(0);
        }

        File file = fileChooser.getSelectedFile();

        String content = readStream(file);
        FileFormatStrategy ffsDecode = null;

        FileFormats fileType = FileFormats.XML;
        switch (fileType) {
            case CSV:
                ffsDecode = new CsvFileFormatter();
                break;
            case XML:
                ffsDecode = new XmlFileFormatter();
                break;
            default:
                throw new UnsupportedEncodingException("UNKNOWN FILE FORMAT");

        }

        List<LinkedHashMap<String, String>> decodedContent = ffsDecode.decode(content, true);

        FileFormatStrategy ffsEncode = new CsvFileFormatter();

        String encodedContent = ffsEncode.encode(decodedContent);
        System.out.println(encodedContent);

    }

    /**
     * gets content of a file in the format of a string
     *
     * @param file
     * @return
     */
    public static String readStream(File file) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = new FileInputStream(file);

        Reader r = new InputStreamReader(fis, "UTF-8");
        int c = 0;
        while ((c = r.read()) != -1) {
            sb.append((char) c);
        }

        return sb.toString();
    }
}
