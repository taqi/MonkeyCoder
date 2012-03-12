package pp.keebraa.java.mockeycode.coremodel.snippets.expressions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ImportExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class ImportExpressionSnippetTest
{
   @Test
   public void getCodeNormalCase()
   {
	String exceptedCode = "import pp.keebraa.classes.SomeClass";
	MType type = mock(MType.class);
	when(type.getClassName()).thenReturn("SomeClass");
	when(type.getPackageName()).thenReturn("pp.keebraa.classes");
	ImportExpressionSnippet snippet = new ImportExpressionSnippet(type);
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(exceptedCode, code);
   }
}
