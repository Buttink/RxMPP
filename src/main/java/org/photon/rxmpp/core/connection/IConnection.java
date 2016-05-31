package org.photon.rxmpp.core.connection;

import rx.functions.Action1;

public interface IConnection {
    void openStream(Action1<IStream> onStreamOpened);
}
