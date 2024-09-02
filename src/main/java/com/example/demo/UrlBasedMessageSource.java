package com.example.demo;

import org.springframework.context.support.AbstractMessageSource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;

public class UrlBasedMessageSource extends AbstractMessageSource {

    private final Properties messages;

    public UrlBasedMessageSource(String urlString) throws IOException {
        messages = new Properties();
        loadMessagesFromUrl(urlString);
    }

    private void loadMessagesFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        try (InputStream inputStream = url.openStream()) {
            messages.load(inputStream);
        }
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String message = messages.getProperty(code);
        return message != null ? new MessageFormat(message, locale) : null;
    }
}