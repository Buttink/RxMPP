package org.photon.rxmpp.core.connection;

import com.google.common.base.Optional;
import org.codehaus.stax2.XMLStreamReader2;
import org.photon.rxmpp.core.Jid;
import org.photon.rxmpp.core.stanza.BaseStanza;
import org.photon.rxmpp.core.stanza.IQ;
import org.photon.rxmpp.core.stanza.IStanza;
import org.photon.rxmpp.core.stanza.IStanzaExtension;
import org.photon.rxmpp.util.XmlMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.Executor;

public class StanzaReader {

    private final XMLStreamReader2 parser;
    private final ConnectableObservable<IStanza> observable;
    private final XmlMap<>

    public StanzaReader(XMLStreamReader2 parser) {
        this.parser = parser;

        observable = Observable.create(
                (Subscriber<? super IStanza> observer) -> {
            executor.execute(() -> {
                while (!observer.isUnsubscribed()) {
                    try {
                        parse(observer);
                    } catch (Exception e) {
                        observer.onError(e);
                    }
                }
            });
        }).publish();
    }

    public Observable<IStanza> onStanza() {
        return observable;
    }

    public void startParsing() {

    }

    private IStanza parse(Subscriber<? super IStanza> observer) {
        switch (parser.getEventType()) {
            case XmlPullParser.START_TAG:
                return
                break;
            case XmlPullParser.END_TAG:
                if ("stream".equals(parser.getName())) {
                }
                break;
            case XmlPullParser.END_DOCUMENT:
                //throw new UnexpectedDocumentCloseException("Found unexpected document end.");
                break;
            default:
                break;
        }
        try {
            parser.next();
        } catch (XMLStreamException e) {
            observer.onError(e);
        }
    }
}
