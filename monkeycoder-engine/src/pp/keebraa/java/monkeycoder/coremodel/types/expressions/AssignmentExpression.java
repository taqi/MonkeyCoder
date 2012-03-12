package pp.keebraa.java.monkeycoder.coremodel.types.expressions;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.AssignmentExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;

public class AssignmentExpression extends ExpressionSyntax
{
   private MVariable leftPart;
   private ExpressionSyntax rightPart;
   
   @Override
   public ExpressionSnippet getCodeSnippet()
   {
	return new AssignmentExpressionSnippet(this);
   }

   public CodeSnippet getLeftPart()
   {
	return leftPart.getCodeSnippet();
   }
   
   public ExpressionSnippet getRightPart()
   {
	return rightPart.getCodeSnippet();
   }
}
