package pp.keebraa.java.monkeycoder.coremodel.types;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;

/**
 * This interface requires all client realization to create code snippet.
 * Usefull for types, and code structures (methods, etc...).
 * 
 * @author taqi
 * 
 */
public interface MSyntax
{
   public CodeSnippet getCodeSnippet();
}
