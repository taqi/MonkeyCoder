package pp.keebraa.java.monkeycoder.coremodel.snippets.expressions;

import java.util.HashSet;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MType;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;

public class VariableExpressionSnippet extends ExpressionSnippet
{
   private MVariable variable;

   public VariableExpressionSnippet(MVariable variable)
   {
	this.variable = variable;
   }
   
   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	types.add(variable.getType());
	return types;
   }

   @Override
   public String getCode()
   {
	return variable.getName();
   }
}
