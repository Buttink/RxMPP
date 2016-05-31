package org.photon.rxmpp.core.serializer;

/**
 * Created by buttink on 2/5/16.
 */
public interface ISerializer<From, To> {
    To serialize(From data);
}
