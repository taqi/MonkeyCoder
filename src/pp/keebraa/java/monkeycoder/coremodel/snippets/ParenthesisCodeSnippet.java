package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class ParenthesisCodeSnippet implements ListCodeSnippet
{
   private List<ExpressionSnippet> expressions;

   public ParenthesisCodeSnippet()
   {
	this.expressions = new ArrayList<ExpressionSnippet>();
   }

   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	for (CodeSnippet snippet : expressions)
	{
	   types.addAll(snippet.getUsedTypes());
	}
	return types;
   }

   @Override
   public void addCodeSnippet(CodeSnippet codeSnippet)
   {
	if(!(codeSnippet instanceof ExpressionSnippet))
	{
	   throw new RuntimeException("for Parenthesis Code Snippet you must set only ExpressionSnippets");
	}
	ExpressionSnippet snippet = (ExpressionSnippet) codeSnippet;
	expressions.add(snippet);
   }

   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	builder.append("(");
	Iterator<ExpressionSnippet> iterator = expressions.iterator();
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
	return new ArrayList<CodeSnippet>(expressions);
   }
}
