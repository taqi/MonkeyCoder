package pp.keebraa.java.mockeycode.coremodel.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.types.MAnnotation;
import pp.keebraa.java.monkeycoder.types.MField;
import pp.keebraa.java.monkeycoder.types.MModificator;
import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MFieldTest
{
   @Test
   public void generateCodeSimpleField()
   {
	String expectedString = "public void someName;\n";
	MField stringName = new MField(MModificator.PUBLIC, "someName", false, DefTypes.VOID,
		new ArrayList<MAnnotation>());
	StringBuilder codeBuilder = new StringBuilder();
	stringName.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedString, code);
   }
   
   @Test
   public void generateCodeSimpleStaticField()
   {
	String expectedString = "public static void someName;\n";
	MField stringName = new MField(MModificator.PUBLIC, "someName", true, DefTypes.VOID,
		new ArrayList<MAnnotation>());
	StringBuilder codeBuilder = new StringBuilder();
	stringName.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedString, code);
   }
   
   @Test
   public void generateCodeSimpleFieldWithOneAnnotation()
   {
	String expectedString = "@Column\npublic void someName;\n";
	StringBuilder codeBuilder = new StringBuilder();
	MAnnotation annotation = new MAnnotation("Column", "com.hibernate.annotations", null);
	List<MAnnotation> annotations = new ArrayList<MAnnotation>();
	annotations.add(annotation);
	MField stringName = new MField(MModificator.PUBLIC, "someName", false, DefTypes.VOID,
		annotations);
	
	stringName.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedString, code);
   }
}
