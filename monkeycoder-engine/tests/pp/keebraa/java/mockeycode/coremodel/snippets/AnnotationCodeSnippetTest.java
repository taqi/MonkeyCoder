package pp.keebraa.java.mockeycode.coremodel.snippets;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.snippets.AnnotationCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.ParenthesisCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MAnnotation;

public class AnnotationCodeSnippetTest
{
   @Test
   public void getCodeSimpleCase()
   {
	String expectedCode = "@Column\n";
	MAnnotation annotation = mock(MAnnotation.class);
	when(annotation.getClassName()).thenReturn("Column");
	AnnotationCodeSnippet snippet = new AnnotationCodeSnippet(annotation);
	String code = snippet.getCode();
	assertEquals(expectedCode, code);
   }
   
   @Ignore
   @Test
   public void getCodeWithSomeValues()
   {
	String expectedCode = "@Column(a = b)\n";
	MAnnotation annotation = mock(MAnnotation.class);
	ParenthesisCodeSnippet parenthesisSnippet = mock(ParenthesisCodeSnippet.class);
	when(annotation.getClassName()).thenReturn("Column");
	when(parenthesisSnippet.getCode()).thenReturn("(a = b)");
	AnnotationCodeSnippet snippet = new AnnotationCodeSnippet(annotation);
//	snippet.setParenthesisBlock(parenthesisSnippet);
	String code = snippet.getCode();
	assertEquals(expectedCode, code);
   }
}
