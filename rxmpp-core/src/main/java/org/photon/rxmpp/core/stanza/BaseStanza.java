package org.photon.rxmpp.core.stanza;

import com.google.common.base.Optional;
import org.photon.rxmpp.core.Jid;
import org.photon.rxmpp.util.XmlMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by buttink on 2/9/16.
 */
public abstract class BaseStanza implements IStanza {

    private XmlMap extensions = new XmlMap();

    protected BaseStanza(XmlMap extensions) {
        if (extensions != null) {
            this.extensions = extensions;
        }
    }

    @Override
    public <S extends IStanzaExtension> S extension(String namespace) {
        return extensions.get(namespace);
    }

    @Override
    public <S extends IStanzaExtension> S extension(String namespace, String element) {
        return extensions.get(namespace, element);
    }

    @Override
    public <S extends IStanzaExtension> Collection<S> extensions() {
        return extensions.getAll();
    }

    @Override
    public <S extends IStanzaExtension> Collection<S> extensions(String namespace) {
        return extensions.getAll(namespace);
    }

    @Override
    public <S extends IStanzaExtension> Collection<S> extensions(String namespace, String element) {
        return extensions.getAll(namespace, element);
    }
}
