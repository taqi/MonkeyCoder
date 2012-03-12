package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.HashSet;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ImportExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class ImportCodeSnippet implements SetCodeSnippet
{
   private Set<ImportExpressionSnippet> importExpressions;
   
   public ImportCodeSnippet()
   {
	importExpressions = new HashSet<ImportExpressionSnippet>();
   }
   
   @Override
   public Set<CodeSnippet> getCodeSnippets()
   {
	return new HashSet<CodeSnippet>(importExpressions);
   }

   @Override
   public void addCodeSnippet(CodeSnippet snippet)
   {
	if(!(snippet instanceof ImportExpressionSnippet))
	{
	   throw new RuntimeException("not import expression in the ImportCodeSnippet");
	}
	ImportExpressionSnippet expression = (ImportExpressionSnippet) snippet;
	importExpressions.add(expression);
   }

   @Override
   public Set<MType> getUsedTypes()
   {
	return new HashSet<MType>();
   }

   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	for(ImportExpressionSnippet snippet : importExpressions)
	{
	   builder.append(snippet.getCode());
	   builder.append(";\n");
	}
	return builder.toString();
   }
}
