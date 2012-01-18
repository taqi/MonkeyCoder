package pp.keebraa.java.mockeycode.coremodel.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.types.MAnnotation;
import pp.keebraa.java.monkeycoder.types.MClass;
import pp.keebraa.java.monkeycoder.types.MMethod;
import pp.keebraa.java.monkeycoder.types.MTypeValue;
import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MMethodTest
{
   @Test
   public void generateCodeSimpleVoidMethod()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("public void foo()\n");
	expectedCode.append("{\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "somePackage");
	MMethod method = new MMethod(clazz, "foo");
	StringBuilder codeBuilder = new StringBuilder();
	method.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }
   
   @Test
   public void generateCodeSimpleVoidMethodWithAnnotations()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("@SomeAnnotation\n");
	expectedCode.append("@SomeAnotherAnnotation\n");
	expectedCode.append("public void foo()\n");
	expectedCode.append("{\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "somePackage");
	MMethod method = new MMethod(clazz, "foo");
	MAnnotation annotation1 = new MAnnotation("SomeAnnotation", null, null);
	MAnnotation annotation2 = new MAnnotation("SomeAnotherAnnotation", null, null);
	method.addAnnotation(annotation1);
	method.addAnnotation(annotation2);
	StringBuilder codeBuilder = new StringBuilder();
	method.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }
   
   @Test
   public void generateCodeWithSimpleArgument()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("public void foo(String value)\n");
	expectedCode.append("{\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "somePackage");
	MMethod method = new MMethod(clazz, "foo");
	MTypeValue value = new MTypeValue(DefTypes.STRING, "value");
	method.addArgument(value);
	StringBuilder codeBuilder = new StringBuilder();
	method.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }
   
   @Test
   public void generateCodeWithTwoArguments()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("public void foo(String value, SomeClass someClass)\n");
	expectedCode.append("{\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "somePackage");
	MMethod method = new MMethod(clazz, "foo");
	MTypeValue value1 = new MTypeValue(DefTypes.STRING, "value");
	MClass someClass = new MClass("SomeClass", "somePackage");
	MTypeValue value2 = new MTypeValue(someClass, "someClass");
	method.addArgument(value1);
	method.addArgument(value2);
	StringBuilder codeBuilder = new StringBuilder();
	method.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }
}
