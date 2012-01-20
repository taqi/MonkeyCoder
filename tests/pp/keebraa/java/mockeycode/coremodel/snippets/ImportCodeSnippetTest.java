package pp.keebraa.java.mockeycode.coremodel.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.snippets.ImportCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ImportExpressionSnippet;

public class ImportCodeSnippetTest
{
   @Test
   public void getCodeWithoutImports()
   {
	ImportCodeSnippet snippet = new ImportCodeSnippet();
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals("", code);
   }
   
   @Test
   public void getCodeWithOneImportClause()
   {
	String expectedCode = "import pp.keebraa.java.SomeClass;\n";
	ImportCodeSnippet snippet = new ImportCodeSnippet();
	ImportExpressionSnippet innerSnippet = mock(ImportExpressionSnippet.class);
	when(innerSnippet.getCode()).thenReturn("import pp.keebraa.java.SomeClass");
	snippet.addCodeSnippet(innerSnippet);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Test
   public void getCodeWithFewImportClauses()
   {
	String expectedCode = "import pp.keebraa.java.SomeClass;\nimport pp.keebraa.java.SomeAnotherClass;\n";
	ImportCodeSnippet snippet = new ImportCodeSnippet();
	ImportExpressionSnippet innerSnippet1 = mock(ImportExpressionSnippet.class);
	when(innerSnippet1.getCode()).thenReturn("import pp.keebraa.java.SomeClass");
	
	ImportExpressionSnippet innerSnippet2 = mock(ImportExpressionSnippet.class);
	when(innerSnippet2.getCode()).thenReturn("import pp.keebraa.java.SomeAnotherClass");
	snippet.addCodeSnippet(innerSnippet1);
	snippet.addCodeSnippet(innerSnippet2);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
}
