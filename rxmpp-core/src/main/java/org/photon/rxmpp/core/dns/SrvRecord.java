package org.photon.rxmpp.core.dns;

import com.google.auto.value.AutoValue;

/**
 * The data from an SRV request
 */
@AutoValue
public abstract class SrvRecord {

    public static SrvRecord create(String additionalName,
                                   int port,
                                   int priority,
                                   String name,
                                   String target,
                                   long ttl,
                                   int type,
                                   int weight) {
        return new AutoValue_SrvRecord(
                additionalName,
                port,
                priority,
                name,
                target,
                ttl,
                type,
                weight);
    }

    public abstract String additionalName();
    public abstract int port();
    public abstract int priority();
    public abstract String name();
    public abstract String target();
    public abstract long ttl();
    public abstract int type();
    public abstract int weight();
}
