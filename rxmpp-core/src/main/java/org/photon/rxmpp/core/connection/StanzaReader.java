package org.photon.rxmpp.core.connection;

import com.google.common.base.Optional;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.flowables.ConnectableFlowable;
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

import javax.inject.Inject;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.Executor;

public class StanzaReader {

    private final XmlPullParser parser;
    private ConnectableFlowable<IStanza> observable;
    private final XmlMap<>

    @Inject
    public StanzaReader(XmlPullParser parser) {
        this.parser = parser;
    }

    @Inject
    public void start() {
        observable = Flowable.<IStanza>create(subscription -> {
            while (true) {
                try {
                    subscription.onNext(parse());
                } catch (Throwable e) {
                    subscription.onError(e);
                    subscription.onComplete();
                }
            }
        }, BackpressureStrategy.BUFFER)
                .publish();
    }

    public Flowable<IStanza> onStanza() {
        return observable;
    }

    private IStanza parse() {
        try {
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
            parser.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
