package org.photon.rxmpp.core.xml.builder;

import java.util.Stack;

/**
 * Created by buttink on 3/2/16.
 */
public class XmlBuilder implements IXmlElementBuilder, IXmlBuilder {

    public static IXmlBuilder create() {
        return new XmlBuilder();
    }

    private final StringBuilder builder;
    private final Stack<String> elements;

    private XmlBuilder() {
        builder = new StringBuilder();
        elements = new Stack<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IXmlElementBuilder a(String namespace, String name, String value) {
        builder.append(" ");
        builder.append(namespace);
        builder.append(":");
        return a(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public XmlBuilder a(String name, String value) {
        builder.append(name);
        builder.append("=");
        builder.append(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IXmlBuilder t(String text) {
        builder.append(text);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IXmlElementBuilder e(String namespace, String name) {
        String fullyQualifiedName = namespace + ":" + name;
        elements.push(name);
        builder.append("<");
        builder.append(fullyQualifiedName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IXmlElementBuilder e(String name) {
        elements.push(name);
        builder.append("<");
        builder.append(name);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IXmlBuilder ra() {
        builder.append(">");
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IXmlBuilder c() {
        String fullyQualifiedName = elements.pop();
        builder.append("</");
        builder.append(fullyQualifiedName);
        builder.append(">");
        return this;
    }
}
