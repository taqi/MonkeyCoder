package pp.keebraa.java.mockeycode.coremodel.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;
import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MAnnotationTest
{
   @Ignore
   @Test
   public void generateCodeSimpleAnnotation()
   {
	String expectedCode = "@Column\n";
//	String name = "Column";
//	String pkg = "org.example.columns";
	
//	MAnnotation annotation = new MAnnotation(name, pkg, null);
	StringBuilder codeBuilder = new StringBuilder();
//	annotation.generateCodeSnippet(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
   
   @Ignore
   @Test
   public void generateCodeAnnotationWithValues()
   {
	String expectedCode = "@Column(name = \"Column\", package = \"org.example.columns\")\n";
	String name = "Column";
	String pkg = "org.example.columns";
	Map<String, MVariable> values = new HashMap<String, MVariable>();
	MVariable nameTypeValue = new MVariable(DefTypes.STRING, "\""+name+"\"");
	values.put("name", nameTypeValue);
	
	MVariable pkgTypeValue = new MVariable(DefTypes.STRING, "\""+pkg+"\"");
	values.put("package", pkgTypeValue);
	
//	MAnnotation annotation = new MAnnotation(name, pkg, values);
	StringBuilder codeBuilder = new StringBuilder();
//	annotation.generateCodeSnippet(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }
}
