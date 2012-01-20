package pp.keebraa.java.mockeycode.coremodel.snippets.expressions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.VariableExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;

public class VariableExpressionSnippetTest
{
   @Test
   public void getCodeNormalCase()
   {
	MVariable variable = mock(MVariable.class);
	when(variable.getName()).thenReturn("someName");
	VariableExpressionSnippet snippet = new VariableExpressionSnippet(variable);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals("someName", code);
   }
}
