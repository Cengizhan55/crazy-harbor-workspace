package com.crazycoder.crazyharborbff.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoggingUtils {

    public static String getStackTraceFullAsString(Throwable t) {

        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);

        String trace = "";
        try {
            t.printStackTrace(pw);
            pw.flush();
            sw.flush();
            trace = sw.toString();

        } catch (Exception e) {
            log.error(e.getMessage());

        } finally {
            try {
                sw.close();
                pw.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return trace;
    }
}
