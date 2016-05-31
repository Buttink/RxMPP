package org.photon.rxmpp.core.stanza;

import com.google.common.base.Optional;
import org.photon.rxmpp.core.Jid;

import java.util.Collection;

/**
 */
public interface IStanza {
    Optional<Jid> to();
    Optional<Jid> from();

    Optional<String> id();
    String name();
    Optional<String> namespace();
    Optional<String> lang();

    <S extends IStanzaExtension> S extension(String namespace);
    <S extends IStanzaExtension> S extension(String element, String namespace);

    <S extends IStanzaExtension> Collection<S> extensions();
    <S extends IStanzaExtension> Collection<S> extensions(String namespace);
    <S extends IStanzaExtension> Collection<S> extensions(String namespace, String element);
}
