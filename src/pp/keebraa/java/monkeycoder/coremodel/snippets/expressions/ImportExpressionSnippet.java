package pp.keebraa.java.monkeycoder.coremodel.snippets.expressions;

import java.util.HashSet;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class ImportExpressionSnippet extends ExpressionSnippet
{
   private MType type;
   
   public ImportExpressionSnippet(MType type)
   {
	this.type = type;
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
	builder.append("import ");
	builder.append(type.getPackageName());
	builder.append(".");
	builder.append(type.getClassName());
	return builder.toString();
   }
}
