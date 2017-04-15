package org.photon.rxmpp.core.dns;

import java.util.List;

/**
 * Used to resolve services for a given domain name.
 */
public interface DnsResolver {
    /**
     * Queries for Service Records for the given domain.
     *
     * @param domain    The domain to get.
     * @return          A list of Service Records.
     */
    List<SrvRecord> resolve(String domain) throws Exception;
}
