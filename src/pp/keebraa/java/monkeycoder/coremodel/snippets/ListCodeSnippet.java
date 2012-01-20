package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.List;

/**
 * @author taqi
 * 
 */
public interface ListCodeSnippet extends CodeSnippet
{
   @Override
   public List<CodeSnippet> getCodeSnippets();
}
