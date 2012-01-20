package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class ParenthesisCodeSnippet implements ListCodeSnippet
{
   private List<CodeSnippet> codeSnippets;

   public ParenthesisCodeSnippet()
   {
	this.codeSnippets = new ArrayList<CodeSnippet>();
   }

   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	for (CodeSnippet snippet : codeSnippets)
	{
	   types.addAll(snippet.getUsedTypes());
	}
	return types;
   }

   @Override
   public void addCodeSnippet(CodeSnippet codeSnippet)
   {
	codeSnippets.add(codeSnippet);
   }

   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	builder.append("(");
	Iterator<CodeSnippet> iterator = codeSnippets.iterator();
	while (iterator.hasNext())
	{
	   builder.append(iterator.next().getCode());
	   if(iterator.hasNext())
		builder.append(", ");
	}
	builder.append(")");
	return builder.toString();
   }

   @Override
   public List<CodeSnippet> getCodeSnippets()
   {
	return codeSnippets;
   }
}
