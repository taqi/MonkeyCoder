package pp.keebraa.java.mockeycode.coremodel.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.types.MAnnotation;
import pp.keebraa.java.monkeycoder.types.MTypeValue;
import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MAnnotationTest
{
   @Test
   public void generateCodeSimpleAnnotation()
   {
	String expectedCode = "@Column\n";
	String name = "Column";
	String pkg = "org.example.columns";
	
	MAnnotation annotation = new MAnnotation(name, pkg, null);
	StringBuilder codeBuilder = new StringBuilder();
	annotation.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Test
   public void generateCodeAnnotationWithValues()
   {
	String expectedCode = "@Column(name = \"Column\", package = \"org.example.columns\")\n";
	String name = "Column";
	String pkg = "org.example.columns";
	Map<String, MTypeValue> values = new HashMap<String, MTypeValue>();
	MTypeValue nameTypeValue = new MTypeValue(DefTypes.STRING, "\""+name+"\"");
	values.put("name", nameTypeValue);
	
	MTypeValue pkgTypeValue = new MTypeValue(DefTypes.STRING, "\""+pkg+"\"");
	values.put("package", pkgTypeValue);
	
	MAnnotation annotation = new MAnnotation(name, pkg, values);
	StringBuilder codeBuilder = new StringBuilder();
	annotation.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
}
