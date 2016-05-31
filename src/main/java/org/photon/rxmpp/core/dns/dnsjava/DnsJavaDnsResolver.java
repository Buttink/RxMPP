package org.photon.rxmpp.core.dns.dnsjava;

import org.photon.rxmpp.core.dns.DnsResolver;
import org.photon.rxmpp.core.dns.SrvRecord;
import org.xbill.DNS.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the DnsResolver via dnsjava.
 */
public class DnsJavaDnsResolver implements DnsResolver {

    private final LookupFactory factory;

    @Inject
    public DnsJavaDnsResolver(LookupFactory factory1) {
        this.factory = factory1;
    }

    @Override
    public List<SrvRecord> resolve(String domain) throws Exception {
        List<SrvRecord> results = new ArrayList<SrvRecord>();
        Lookup lookup = factory.build(domain, Type.SRV);
        Record[] lookupResults = lookup.run();
        if (lookupResults == null) {
            return results;
        }

        for (Record record : lookupResults) {
            SRVRecord srvRecord = (SRVRecord) record;
            if (srvRecord != null && srvRecord.getTarget() != null) {
                SrvRecord s = SrvRecord.create(
                        srvRecord.getAdditionalName().toString(),
                        srvRecord.getPort(),
                        srvRecord.getPriority(),
                        srvRecord.getName().toString(),
                        srvRecord.getTarget().toString(),
                        srvRecord.getTTL(),
                        srvRecord.getType(),
                        srvRecord.getWeight());

                results.add(s);
            }
        }

        return results;
    }
}
