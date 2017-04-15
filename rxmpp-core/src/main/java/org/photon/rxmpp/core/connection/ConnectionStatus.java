package org.photon.rxmpp.core.connection;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ConnectionStatus {

    public ConnectionStatus create(boolean connected, boolean authenticated) {
        return new AutoValue_ConnectionStatus(connected, authenticated);
    }

    public abstract boolean connected();
    public abstract boolean authenticated();
}
