package com.example.demo;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.layout.font.FontProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);
        String htmlSource = getContent();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider dfp = new DefaultFontProvider(true, false, false);
        dfp.addFont("C:\\Windows\\Fonts\\Arial.ttf");
        converterProperties.setFontProvider(dfp);
        converterProperties.setMediaDeviceDescription(new MediaDeviceDescription(MediaType.PRINT));
        HtmlConverter.convertToPdf(htmlSource, outputStream, converterProperties);
        byte[] bytes = outputStream.toByteArray();
        File pdfFile = new File("java19.pdf");
        FileOutputStream fos = new FileOutputStream(pdfFile);
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

    private static String getContent() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "      @page {\n" +
                "        margin: 0;\n" +
                "        font-family: arial;\n" +
                "      }\n" +
                "    </style>\n" +
                "</head>\n" +
                "\n" +
                "<body\n" +
                "    style=\"margin: 0;padding: 0;font-family: arial, sans-serif;font-size: 14px;line-height: 125%;width: 100%;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;color: #222222;\">\n" +
                "    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background: white; direction: rtl;\">\n" +
                "        <tbody>\n" +
                "            <tr>\n" +
                "                <td style=\"padding: 0 35px;\">\n" +
                "                    <p> Test...\n" +
                "                    </p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"padding: 0 35px;\">\n" +
                "                    <p> انا اسمى عبدالله\n" +
                "                    </p>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }
}