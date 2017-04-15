package org.photon.rxmpp.core.connection;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by stockingd on 4/17/16.
 */
public class TcpConnector {

    private final String domain;
    private final short port;

    public TcpConnector(String domain, short port) {
        this.domain = domain;
        this.port = port;
    }

    public TcpConnection connect() throws IOException {
        return new TcpConnection(new Socket(domain, port));
    }

    public class Builder {

        private String domain;
        private short port;

        public Builder setDomain(String domain) {
            this.domain = domain;
            return this;
        }

        public Builder setPort(short port) {
            this.port = port;
            return this;
        }

        public TcpConnector build() {
            return new TcpConnector(domain, port);
        }
    }
}
