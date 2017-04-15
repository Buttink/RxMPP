package org.photon.rxmpp.core.connection;

import org.photon.rxmpp.core.filter.IStanzaFilter;
import org.photon.rxmpp.core.stanza.IStanza;
import rx.Observable;

public interface IStream {
    void send(IStanza stanza);
    Observable<IStanza> stream();
}
