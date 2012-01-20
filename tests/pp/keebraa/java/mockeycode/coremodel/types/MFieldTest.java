package pp.keebraa.java.mockeycode.coremodel.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MAnnotation;
import pp.keebraa.java.monkeycoder.coremodel.types.MField;
import pp.keebraa.java.monkeycoder.coremodel.types.MModificator;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;
import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MFieldTest
{
   @Ignore
   @Test
   public void generateCodeSimpleField()
   {
	String expectedString = "public String someName;\n";
	MVariable variable = new MVariable(DefTypes.STRING, "someName");
	MField stringName = new MField(MModificator.PUBLIC, "someName", false, variable,
		new ArrayList<MAnnotation>());
	CodeSnippet snippet = stringName.getCodeSnippet();
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedString, code);
   }
   
   @Ignore
   @Test
   public void generateCodeSimpleStaticField()
   {
	String expectedString = "public static String someName;\n";
	MVariable variable = new MVariable(DefTypes.STRING, "someName");
	MField stringName = new MField(MModificator.PUBLIC, "someName", true, variable,
		new ArrayList<MAnnotation>());
	CodeSnippet snippet = stringName.getCodeSnippet();
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedString, code);
   }
   
   @Ignore
   @Test
   public void generateCodeSimpleFieldWithOneAnnotation()
   {
	String expectedString = "@Column\npublic String someName;\n";
	MAnnotation annotation = new MAnnotation("Column", "com.hibernate.annotations", null);
	List<MAnnotation> annotations = new ArrayList<MAnnotation>();
	annotations.add(annotation);
	MVariable variable = new MVariable(DefTypes.STRING, "someName");
	MField stringName = new MField(MModificator.PUBLIC, "someName", false, variable,
		annotations);
	
	CodeSnippet snippet = stringName.getCodeSnippet();
	String code = snippet.getCode();
	assertNotNull(code);
	assertEquals(expectedString, code);
   }
}
