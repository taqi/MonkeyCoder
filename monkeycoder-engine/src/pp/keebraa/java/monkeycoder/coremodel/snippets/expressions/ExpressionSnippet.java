package pp.keebraa.java.monkeycoder.coremodel.snippets.expressions;

import java.util.Collection;
import java.util.HashSet;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;

public abstract class ExpressionSnippet implements CodeSnippet
{
   @Override
   public final Collection<CodeSnippet> getCodeSnippets()
   {
	return new HashSet<CodeSnippet>();
   }
   
   @Override
   public final void addCodeSnippet(CodeSnippet snippet)
   {
   }
}
