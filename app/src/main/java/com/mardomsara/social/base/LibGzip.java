package com.mardomsara.social.base;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class LibGzip {

    public static byte[] compress(String data) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = null;
        byte[] compressed =  {Byte.decode("").byteValue()};
        try {
            gzip = new GZIPOutputStream(bos);
            gzip.write(data.getBytes());
            gzip.close();
            compressed = bos.toByteArray();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compressed;
    }

    public static String decompress(byte[] compressed){
        ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
        GZIPInputStream gis = null;
        StringBuilder sb = new StringBuilder();
        try {
            gis = new GZIPInputStream(bis);
            BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            gis.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}