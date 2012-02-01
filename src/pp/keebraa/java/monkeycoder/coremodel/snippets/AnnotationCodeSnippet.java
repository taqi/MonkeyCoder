package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MAnnotation;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;

public class AnnotationCodeSnippet implements ListCodeSnippet
{
   private MAnnotation annotation;
   
   private ParenthesisCodeSnippet parenthesisBlock;

   public AnnotationCodeSnippet(MAnnotation annotation)
   {
	this.annotation = annotation;
   }
   
   public void setParenthesisBlock(ParenthesisCodeSnippet block)
   {
	this.parenthesisBlock = block;
   }

   private void generateBasicClause(StringBuilder builder)
   {
	builder.append("@");
	builder.append(annotation.getClassName());
   }
   
   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	generateBasicClause(builder);
	generateParenthesisBlock(builder);
	builder.append("\n");
	return builder.toString();
   }

   private void generateParenthesisBlock(StringBuilder builder)
   {
	if(parenthesisBlock != null)
	   builder.append(parenthesisBlock.getCode());	
   }

   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	types.add(annotation);
	for(String key : annotation.getValues().keySet())
	{
	   MVariable variable = annotation.getValues().get(key);
	   types.add(variable.getType());
	}
	return types;
   }

   @Override
   public void addCodeSnippet(CodeSnippet snippet)
   {
   }

   @Override
   public List<CodeSnippet> getCodeSnippets()
   {
	return new ArrayList<CodeSnippet>();
   }
}
