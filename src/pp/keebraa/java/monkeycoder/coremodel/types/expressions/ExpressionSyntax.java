package pp.keebraa.java.monkeycoder.coremodel.types.expressions;

import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MSyntax;

public abstract class ExpressionSyntax implements MSyntax
{
   @Override
   public abstract ExpressionSnippet getCodeSnippet();
}
