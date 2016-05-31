package org.photon.rxmpp.log;

/**
 * Created by stockingd on 3/27/16.
 */
public interface ILog {
    void fatal(String message, Exception e, String ... format);
    void error(String message, Exception e, String ... format);
    void warn(String message, Exception e, String ... format);
    void info(String message, Exception e, String ... format);
    void debug(String message, Exception e, String ... format);
    void trace(String message, Exception e, String ... format);
}
