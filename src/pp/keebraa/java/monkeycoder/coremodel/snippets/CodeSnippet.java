package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.Collection;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MCode;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public interface CodeSnippet extends MCode
{
   public Collection<CodeSnippet> getCodeSnippets();
   
   public Set<MType> getUsedTypes();

   public void addCodeSnippet(CodeSnippet snippet);
}
