package org.photon.rxmpp.core.dns.dnsjava;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.photon.rxmpp.core.dns.SrvRecord;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xbill.DNS.*;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Lookup.class})
public class DnsJavaDnsResolverTest {

    @Test
    public void testResolve() throws Exception {
        LookupFactory mockFactory = mock(LookupFactory.class);
        DnsJavaDnsResolver resolver = new DnsJavaDnsResolver(mockFactory);

        Lookup mockLookup = mock(Lookup.class);
        when(mockFactory.build("www.rxmpp.com", Type.SRV)).thenReturn(mockLookup);
        Record[] records = new Record[] {
             new SRVRecord(
                     new Name("www.rxmpp.com."),
                     10,
                     100,
                     2,
                     1,
                     8080,
                     new Name("www.rxmpp.com."))
        };
        when(mockLookup.run()).thenReturn(records);

        List<SrvRecord> items = resolver.resolve("www.rxmpp.com");
    }
}
