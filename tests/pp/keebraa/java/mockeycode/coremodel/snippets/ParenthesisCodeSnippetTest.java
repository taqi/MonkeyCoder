package pp.keebraa.java.mockeycode.coremodel.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.snippets.ParenthesisCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ExpressionSnippet;

public class ParenthesisCodeSnippetTest
{
   @Test
   public void getCodeWithoutSnippets()
   {
	String expectedCode = "()";
	ParenthesisCodeSnippet snippet = new ParenthesisCodeSnippet();
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Test
   public void getCodeWithOneSnippet()
   {
	ExpressionSnippet innerSnippet = mock(ExpressionSnippet.class);
	when(innerSnippet.getCode()).thenReturn("a = b");
	String expectedCode = "(a = b)";
	ParenthesisCodeSnippet snippet = new ParenthesisCodeSnippet();
	snippet.addCodeSnippet(innerSnippet);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Test
   public void getCodeWithFewSnippets()
   {
	ExpressionSnippet innerSnippet1 = mock(ExpressionSnippet.class);
	when(innerSnippet1.getCode()).thenReturn("a = b");
	ExpressionSnippet innerSnippet2 = mock(ExpressionSnippet.class);
	when(innerSnippet2.getCode()).thenReturn("b = c");
	ExpressionSnippet innerSnippet3 = mock(ExpressionSnippet.class);
	when(innerSnippet3.getCode()).thenReturn("c = d");
	String expectedCode = "(a = b, b = c, c = d)";
	ParenthesisCodeSnippet snippet = new ParenthesisCodeSnippet();
	snippet.addCodeSnippet(innerSnippet1);
	snippet.addCodeSnippet(innerSnippet2);
	snippet.addCodeSnippet(innerSnippet3);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
}