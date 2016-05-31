package org.photon.rxmpp.core.stanza;

import com.google.common.base.Optional;
import org.photon.rxmpp.core.Jid;
import org.photon.rxmpp.util.XmlMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by buttink on 2/9/16.
 */
public class EndStream extends BaseStanza {

    protected EndStream() {
        super(null);
    }

    @Override
    public Optional<Jid> to() {
        return Optional.absent();
    }

    @Override
    public Optional<Jid> from() {
        return Optional.absent();
    }

    @Override
    public Optional<String> id() {
        return Optional.absent();
    }

    @Override
    public String name() {
        return "stream";
    }

    @Override
    public Optional<String> namespace() {
        return Optional.absent();
    }

    @Override
    public Optional<String> lang() {
        return Optional.absent();
    }
}
