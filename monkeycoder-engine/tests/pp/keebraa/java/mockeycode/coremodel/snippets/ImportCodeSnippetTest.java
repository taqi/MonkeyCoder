package pp.keebraa.java.mockeycode.coremodel.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import pp.keebraa.java.mockeycode.testutils.SetCodeSnippetTestUtil;
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

   /**
    * Check if importCodeSnippet generates right code with few imports. Note,
    * that the last line should be empty line, because ImportCodeSnippet should
    * generate \n character in the end of code.
    */
   @Test
   public void getCodeWithFewImportClauses()
   {
	SetCodeSnippetTestUtil util = new SetCodeSnippetTestUtil();
	util.addExpectedLine("import pp.keebraa.java.SomeClass;");
	util.addExpectedLine("import pp.keebraa.java.SomeAnotherClass;");
	util.addExpectedLine("");
	ImportCodeSnippet snippet = new ImportCodeSnippet();
	ImportExpressionSnippet innerSnippet1 = mock(ImportExpressionSnippet.class);
	when(innerSnippet1.getCode()).thenReturn("import pp.keebraa.java.SomeClass");

	ImportExpressionSnippet innerSnippet2 = mock(ImportExpressionSnippet.class);
	when(innerSnippet2.getCode()).thenReturn("import pp.keebraa.java.SomeAnotherClass");
	snippet.addCodeSnippet(innerSnippet1);
	snippet.addCodeSnippet(innerSnippet2);
	String code = snippet.getCode();
	assertNotNull(code);
	assertTrue(util.isEqualTo(code));
   }
}
