package org.photon.rxmpp.core.xml.builder;

/**
 * Builds an xml element.
 */
public interface IXmlElementBuilder {
    /**
     * Adds an attribute to the xml element.
     * @param name  The name of the attribute.
     * @param value The value for the attribute.
     * @return  An {@link IXmlElementBuilder} to continue building the element.
     */
    IXmlElementBuilder a(String name, String value);

    /**
     * Adds an attribute to the xml element.
     * @param namespace The namespace of the attribute.
     * @param name      The name of the attribute.
     * @param value     The value for the attribute.
     * @return  An {@link IXmlElementBuilder} to continue building the element.
     */
    IXmlElementBuilder a(String namespace, String name, String value);

    /**
     * Closes building the element start tag and begins building the inner content of the element.
     * @return  An {@link IXmlBuilder} to start adding inner content.
     */
    IXmlBuilder c();
}
