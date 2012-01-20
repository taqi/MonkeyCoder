package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class BraceBlockCodeSnippet implements ListCodeSnippet
{
   private List<CodeSnippet> snippets;
   
   public BraceBlockCodeSnippet()
   {
	snippets = new ArrayList<CodeSnippet>();
   }
   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	for(CodeSnippet snippet : snippets)
	{
	   types.addAll(snippet.getUsedTypes());
	}
	return types;
   }

   @Override
   public void addCodeSnippet(CodeSnippet snippet)
   {
	snippets.add(snippet);
   }

   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	builder.append("{\n");
	for(CodeSnippet snippet : snippets)
	{
	   builder.append(snippet.getCode());
	   if(!(snippet instanceof BraceBlockCodeSnippet))
		builder.append(";");
	   builder.append("\n");
	}
	builder.append("}");
	return builder.toString();
   }

   @Override
   public List<CodeSnippet> getCodeSnippets()
   {
	return snippets;
   }
}
