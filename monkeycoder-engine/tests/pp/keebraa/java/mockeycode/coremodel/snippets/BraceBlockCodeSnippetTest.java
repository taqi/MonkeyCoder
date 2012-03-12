package pp.keebraa.java.mockeycode.coremodel.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.snippets.BraceBlockCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;

public class BraceBlockCodeSnippetTest
{
   @Test
   public void getCodeEmptyBlock()
   {
	String expectedCode = "{\n}";
	BraceBlockCodeSnippet snippet = new BraceBlockCodeSnippet();
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Test
   public void getCodeWithInnerCode()
   {
	String expectedCode = "{\nString a = b;\n}";
	CodeSnippet innerSnippet = mock(CodeSnippet.class);
	when(innerSnippet.getCode()).thenReturn("String a = b");
	BraceBlockCodeSnippet snippet = new BraceBlockCodeSnippet();
	snippet.addCodeSnippet(innerSnippet);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Test
   public void getCodeWithInnerBraceCodeSnippet()
   {
	String expectedCode = "{\n{\nString a = b;\n}\n}";
	
	CodeSnippet innerSnippet = mock(CodeSnippet.class);
	when(innerSnippet.getCode()).thenReturn("String a = b");
	CodeSnippet innerBraceSnippet = new BraceBlockCodeSnippet();
	innerBraceSnippet.addCodeSnippet(innerSnippet);
	BraceBlockCodeSnippet snippet = new BraceBlockCodeSnippet();
	snippet.addCodeSnippet(innerBraceSnippet);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Test
   public void getCodeWithInnerBraceCodeSnippetAndSimpleCodeSnippet()
   {
	String expectedCode = "{\nString a = b;\n{\nString a = b;\n}\n}";
	
	CodeSnippet innerSnippet = mock(CodeSnippet.class);
	when(innerSnippet.getCode()).thenReturn("String a = b");
	CodeSnippet innerBraceSnippet = new BraceBlockCodeSnippet();
	innerBraceSnippet.addCodeSnippet(innerSnippet);
	BraceBlockCodeSnippet snippet = new BraceBlockCodeSnippet();
	snippet.addCodeSnippet(innerSnippet);
	snippet.addCodeSnippet(innerBraceSnippet);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
}
