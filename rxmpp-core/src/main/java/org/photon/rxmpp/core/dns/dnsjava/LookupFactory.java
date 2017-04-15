package org.photon.rxmpp.core.dns.dnsjava;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.TextParseException;

import javax.annotation.Nonnull;

public class LookupFactory {

    public LookupFactory() {
    }

    public Lookup build(@Nonnull String domain, int type)
            throws TextParseException {
        return new Lookup(domain, type);
    }
}
