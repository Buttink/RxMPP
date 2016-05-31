package org.photon.rxmpp.util;

import org.photon.rxmpp.core.stanza.IStanzaExtension;

import java.util.*;

/**
 * A special map used for getting xml by namespace and element.
 */
public class XmlMap {

    public Map<String, Map<String, Set<IStanzaExtension>>> extensions;

    public XmlMap() {
        extensions = new HashMap<>();
    }

    public <S extends IStanzaExtension>
    S get(String namespace) {
        Collection<S> all = getAll(namespace);
        if (all.size() > 0) {
            return all.iterator().next();
        }

        return null;
    }

    public <S extends IStanzaExtension>
    S get(String namespace, String element) {
        Collection<S> all = getAll(namespace, element);
        if (all.size() > 0) {
            return all.iterator().next();
        }

        return null;
    }

    public <S extends IStanzaExtension>
    Collection<S> getAll() {
        List<S> results = new ArrayList<>();
        for (Map<String, Set<IStanzaExtension>> elementToExtension
                : extensions.values()) {
            for (Set<IStanzaExtension> elements : elementToExtension.values()) {
                for (IStanzaExtension extension : elements) {
                    results.add((S) extension);
                }
            }
        }

        return results;
    }

    public <S extends IStanzaExtension>
    Collection<S> getAll(String namespace) {
        Map<String, Set<IStanzaExtension>> elementToExtension =
                extensions.getOrDefault(namespace, Collections.emptyMap());

        List<S> results = new ArrayList<>();
        for (Set<IStanzaExtension> elements : elementToExtension.values()) {
            for (IStanzaExtension extension : elements) {
                results.add((S) extension);
            }
        }

        return results;
    }

    public <S extends IStanzaExtension>
    Collection<S> getAll(String namespace, String element) {
        Map<String, Set<IStanzaExtension>> elementToExtension =
                extensions.getOrDefault(namespace, Collections.emptyMap());

        Set<IStanzaExtension> foundElements =
                elementToExtension.getOrDefault(element, Collections.emptySet());

        List<S> results = new ArrayList<>();
        if (foundElements.size() > 0) {
            for (IStanzaExtension extension : foundElements) {
                results.add((S) extension);
            }
        }

        return results;
    }

}
