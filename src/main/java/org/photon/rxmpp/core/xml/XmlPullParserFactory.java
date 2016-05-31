package org.photon.rxmpp.core.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.Reader;

public class XmlPullParserFactory {

    public XmlPullParser create(Reader reader) throws XmlPullParserException {
        org.xmlpull.v1.XmlPullParserFactory factory =
                org.xmlpull.v1.XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(reader);
        return parser;
    }
}
