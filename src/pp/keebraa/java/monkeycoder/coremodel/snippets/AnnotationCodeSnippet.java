package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.List;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MAnnotation;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class AnnotationCodeSnippet implements ListCodeSnippet
{
   private MAnnotation annotation;
   
   public AnnotationCodeSnippet(MAnnotation annotation)
   {
	this.annotation = annotation;
   }

   private void generateBasicClause(StringBuilder builder)
   {
	builder.append("@");
	builder.append(annotation.getClassName());
   }
   
   private void generateValues(StringBuilder builder)
   {
   }
   
   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	generateBasicClause(builder);
	generateValues(builder);
	builder.append("\n");
	return builder.toString();
   }

   @Override
   public Set<MType> getUsedTypes()
   {
	return null;
   }

   @Override
   public void addCodeSnippet(CodeSnippet snippet)
   {
	// TODO Auto-generated method stub
	
   }

   @Override
   public List<CodeSnippet> getCodeSnippets()
   {
	// TODO Auto-generated method stub
	return null;
   }
}
