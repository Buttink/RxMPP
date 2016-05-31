package org.photon.rxmpp.core.connection;

import rx.functions.Action1;

public interface IConnector {
    void connect(Action1<IConnection> onConnected);
}
