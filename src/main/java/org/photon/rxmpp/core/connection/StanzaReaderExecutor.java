package org.photon.rxmpp.core.connection;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * Created by stockingd on 3/27/16.
 */
public class StanzaReaderExecutor {

    private final Executor executor;
    private final StanzaReader stanzaReader;

    public StanzaReaderExecutor(Executor executor, StanzaReader stanzaReader, Ilog logger) {
        this.executor = executor;
        this.stanzaReader = stanzaReader;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void startParsing() {
        executor.execute(() -> {
            try {
                while (stanzaReader.parse());
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
