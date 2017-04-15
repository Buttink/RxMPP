package org.photon.rxmpp.core;

import com.google.auto.value.AutoValue;
import com.google.common.base.Optional;

/**
 */
@AutoValue
public abstract class Jid {

    public static final Jid INVALID = new AutoValue_Jid(
            Optional.of(""), "", Optional.of(""), false);

    public static Jid create(String jid) {
        if (jid == null) {
            return INVALID;
        }

        int index = jid.indexOf("@");
        if (index < 0) {
            return INVALID;
        }

        String node = jid.substring(0, index);

        int slashIndex = jid.indexOf("/");
        if (slashIndex < 0) {
            slashIndex = jid.length();
        }

        String domain = jid.substring(0, slashIndex);

        String resource = null;
        if (slashIndex < jid.length()) {
            resource = jid.substring(slashIndex + 1);
        }

        return new AutoValue_Jid(
                Optional.of(node),
                domain,
                Optional.of(resource),
                true);
    }

    public static Jid create(String node,
                             String domain,
                             String resource) {
        if (domain == null) {
            return INVALID;
        }

        return new AutoValue_Jid(
                Optional.of(node),
                domain,
                Optional.of(resource),
                true);
    }

    public abstract Optional<String> node();
    public abstract String domain();
    public abstract Optional<String> resource();

    public abstract boolean valid();
}
