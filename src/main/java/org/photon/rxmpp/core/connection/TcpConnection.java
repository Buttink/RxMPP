package org.photon.rxmpp.core.connection;

import com.fasterxml.aalto.out.XmlWriter;
import com.fasterxml.aalto.stax.InputFactoryImpl;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.XMLStreamReader2;
import rx.Observable;
import rx.observables.StringObservable;
import rx.schedulers.Schedulers;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by buttink on 2/6/16.
 */
public class TcpConnection implements IConnection {

    private final Socket socket;
    private XMLStreamReader2 xmlReader;
    private Observable<byte[]> recieved;

    public TcpConnection(Socket socket) {
        this.socket = socket;
    }

    private IStream stream() throws IOException, XMLStreamException {
        XMLInputFactory2 factory = new InputFactoryImpl();
        xmlReader = (XMLStreamReader2)
                factory.createXMLStreamReader(socket.getInputStream());
        StanzaReader reader = new StanzaReader(xmlReader);
        StanzaWriter writer = new StanzaWriter(socket.getOutputStream());
        return new Stream(reader, writer);
    }

    @Override
    public void send(byte[] data) throws IOException {
        OutputStream stream = socket.getOutputStream();
        stream.write(data);
    }

    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }
}
