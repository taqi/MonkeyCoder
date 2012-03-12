package pp.keebraa.java.monkeycoder.coremodel.snippets.expressions;

import java.util.HashSet;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MType;
import pp.keebraa.java.monkeycoder.coremodel.types.expressions.AssignmentExpression;

/**
 * Expression like: leftPart = rightPart; rightPart can be also Statement;
 * 
 * @author taqi
 * 
 */
public class AssignmentExpressionSnippet extends ExpressionSnippet
{
   private AssignmentExpression expression;

   public AssignmentExpressionSnippet(AssignmentExpression expression)
   {
	this.expression = expression;
   }
   
   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	builder.append(expression.getLeftPart().getCode());
	builder.append(" = ");
	builder.append(expression.getRightPart().getCode());
	return builder.toString();
   }

   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	types.addAll(expression.getLeftPart().getUsedTypes());
	types.addAll(expression.getRightPart().getUsedTypes());
	return types;
   }
}
