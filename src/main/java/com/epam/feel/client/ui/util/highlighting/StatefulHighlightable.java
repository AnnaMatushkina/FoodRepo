package com.epam.feel.client.ui.util.highlighting;

/**
 * Indicates that component implements both interfaces of {@link Stateful} and {@link Highlightable}. Used to simplify
 * highlighting logic for changeable components.
 * 
 * @author Michael_Silvanovich
 */
public interface StatefulHighlightable extends Stateful, Highlightable {}
