package org.photon.rxmpp.core.connection;

import org.photon.rxmpp.core.stanza.IStanza;
import rx.Observable;

/**
 * Created by buttink on 2/6/16.
 */
public class Stream implements IStream {

    private final StanzaReader reader;
    private final StanzaWriter writer;

    public Stream(IConnection connection) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void send(IStanza stanza) {
        writer.send(stanza);
    }

    @Override
    public Observable<IStanza> stream() {
        return reader.onStanza();
    }
}
