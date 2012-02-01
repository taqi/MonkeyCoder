package pp.keebraa.java.mockeycode.coremodel.snippets;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.MethodCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MMethod;
import pp.keebraa.java.monkeycoder.coremodel.types.MModificator;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;
import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MethodCodeSnippetTest
{
   @Test
   public void getCodeSimpleMethod()
   {
	StringBuilder expectedCodeBuilder = new StringBuilder();
	expectedCodeBuilder.append("String someMethod(String a, String b)\n");
	expectedCodeBuilder.append("{\n}");
	String expectedCode = expectedCodeBuilder.toString();
	MMethod method = mock(MMethod.class);
	MVariable arg1 = mock(MVariable.class);
	ExpressionSnippet arg1Snippet = mock(ExpressionSnippet.class);
	MVariable arg2 = mock(MVariable.class);
	ExpressionSnippet arg2Snippet = mock(ExpressionSnippet.class);
	when(method.getModificator()).thenReturn(MModificator.DEFAULT);
	when(arg1.getCodeSnippet()).thenReturn(arg1Snippet);
	when(arg1Snippet.getCode()).thenReturn("String a");
	when(arg2.getCodeSnippet()).thenReturn(arg2Snippet);
	when(arg2Snippet.getCode()).thenReturn("String b");
	when(method.getName()).thenReturn("someMethod");
	when(method.getReturnedType()).thenReturn(DefTypes.STRING);
	List<MVariable> arguments = new ArrayList<MVariable>();
	arguments.add(arg1);
	arguments.add(arg2);
	when(method.getArguments()).thenReturn(arguments);
	CodeSnippet snippet = new MethodCodeSnippet(method);
	String code = snippet.getCode();
	assertEquals(expectedCode, code);
   }
}
