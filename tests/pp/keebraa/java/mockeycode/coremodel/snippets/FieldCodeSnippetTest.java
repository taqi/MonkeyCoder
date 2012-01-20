package pp.keebraa.java.mockeycode.coremodel.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import pp.keebraa.java.monkeycoder.coremodel.snippets.SetCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.FieldCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MField;
import pp.keebraa.java.monkeycoder.coremodel.types.MModificator;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;

public class FieldCodeSnippetTest
{
   @Test
   public void getCodeSimpleNonStaticField()
   {
	MField field = Mockito.mock(MField.class);
	MVariable variable = Mockito.mock(MVariable.class);
	MType type = Mockito.mock(MType.class);
	when(field.getModificator()).thenReturn(MModificator.PRIVATE);
	when(field.isStatic()).thenReturn(false);
	when(field.getVariable()).thenReturn(variable);
	when(variable.getType()).thenReturn(type);
	when(type.getClassName()).thenReturn("String");
	when(variable.getName()).thenReturn("name");
	
	SetCodeSnippet snippet = new FieldCodeSnippet(field);
	String code = snippet.getCode();
	
	String expectedCode = "private String name;\n"; 
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Test
   public void getCodeSimpleStaticField()
   {
	MField field = Mockito.mock(MField.class);
	MVariable variable = Mockito.mock(MVariable.class);
	MType type = Mockito.mock(MType.class);
	when(field.getModificator()).thenReturn(MModificator.PRIVATE);
	when(field.isStatic()).thenReturn(true);
	when(field.getVariable()).thenReturn(variable);
	when(variable.getType()).thenReturn(type);
	when(type.getClassName()).thenReturn("String");
	when(variable.getName()).thenReturn("name");
	
	SetCodeSnippet snippet = new FieldCodeSnippet(field);
	String code = snippet.getCode();
	
	String expectedCode = "private static String name;\n"; 
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
}


