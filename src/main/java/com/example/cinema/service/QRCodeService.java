package com.example.cinema.service;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodeService {
    void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException;
}
