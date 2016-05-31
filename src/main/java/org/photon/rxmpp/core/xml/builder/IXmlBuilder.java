package org.photon.rxmpp.core.xml.builder;

/**
 * Builds the inner content of an xml element.
 */
public interface IXmlBuilder {

    /**
     * Adds text to the inner content of this element.
     * @param text  The text.
     * @return      An {@link IXmlBuilder} to continue building inner content for the element.
     */
    IXmlBuilder t(String text);

    /**
     * Adds an element to the inner content of this element.
     * @param namespace  The namespace of the element.
     * @param name       The name of the element.
     * @return      An {@link IXmlElementBuilder} to build the element.
     */
    IXmlElementBuilder e(String namespace, String name);

    /**
     * Adds an element to the inner content of this element.
     * @param name       The name of the element.
     * @return      An {@link IXmlElementBuilder} to build the element.
     */
    IXmlElementBuilder e(String name);

    /**
     * Closes the element. This usually means putting in a right angle bracket, but is not always true.
     * @return The {@link IXmlBuilder} that is building this parents xml element.
     */
    IXmlBuilder ra();
}
