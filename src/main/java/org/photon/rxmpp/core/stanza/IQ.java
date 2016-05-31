package org.photon.rxmpp.core.stanza;

/**
 * Created by buttink on 2/6/16.
 */
public abstract class IQ implements IStanza {

    public enum Type { GET, SET, RESULT, ERROR }

    public abstract Type type();
}
