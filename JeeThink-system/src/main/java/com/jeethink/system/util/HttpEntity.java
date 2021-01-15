package com.jeethink.system.util;





import org.apache.http.Header;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface HttpEntity {
    boolean isRepeatable();

    boolean isChunked();

    long getContentLength();

    Header getContentType();

    Header getContentEncoding();

    InputStream getContent() throws IOException, UnsupportedOperationException;

    void writeTo(OutputStream var1) throws IOException;

    boolean isStreaming();

    /** @deprecated */
    @Deprecated
    void consumeContent() throws IOException;
}