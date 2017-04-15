package org.photon.rxmpp.core.serializer;

public interface IDeserializer<To, From> {
    To deserialize(From data);
}
