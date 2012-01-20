package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.HashSet;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MField;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class FieldCodeSnippet implements SetCodeSnippet
{
   private MField field;
   
   public FieldCodeSnippet(MField field)
   {
	this.field = field;
   }
   
   @Override
   public Set<CodeSnippet> getCodeSnippets()
   {
	return new HashSet<CodeSnippet>();
   }

   @Override
   public void addCodeSnippet(CodeSnippet snippet)
   {
	/*
	 * Nothing to do. We can't have snippets in a field;
	 */
   }

   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	builder.append(field.getModificator().getValue());
	if(field.isStatic())
	{
	   builder.append("static ");
	}
	builder.append(field.getVariable().getType().getClassName()+" ");
	builder.append(field.getVariable().getName());
	builder.append(";\n");
	return builder.toString();
   }

   @Override
   public Set<MType> getUsedTypes()
   {
	return new HashSet<MType>();
   }
}
