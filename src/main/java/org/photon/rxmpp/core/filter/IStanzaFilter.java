package org.photon.rxmpp.core.filter;

import org.photon.rxmpp.core.stanza.IStanza;
import rx.Observable;

public interface IStanzaFilter extends Observable.Transformer<IStanza, IStanza> {
}
