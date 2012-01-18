package pp.keebraa.java.mockeycode.coremodel.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pp.keebraa.java.monkeycoder.types.MAnnotation;
import pp.keebraa.java.monkeycoder.types.MClass;
import pp.keebraa.java.monkeycoder.types.MField;
import pp.keebraa.java.monkeycoder.types.MMethod;
import pp.keebraa.java.monkeycoder.types.MModificator;
import pp.keebraa.java.monkeycoder.types.MTypeValue;
import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MClassTest
{
   @Test
   public void generateCodeSimpleClass()
   {
	String expectedCode = "package pp.keebraa.java.monkeyCode.example;\npublic class SomeClass\n{\n}\n";
	MClass clazz = new MClass("SomeClass", "pp.keebraa.java.monkeyCode.example");
	clazz.setModificator(MModificator.PUBLIC);
	StringBuilder codeBuilder = new StringBuilder();
	clazz.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode, code);
   }

   @Test
   public void generateCodeWithFields()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("package pp.keebraa.java.monkeyCode.example;\n");
	expectedCode.append("public class SomeClass\n");
	expectedCode.append("{\n");
	expectedCode.append("public String name;\n");
	expectedCode.append("public String value;\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "pp.keebraa.java.monkeyCode.example");
	MField nameField = new MField(MModificator.PUBLIC, "name", false, DefTypes.STRING, null);
	MField valueField = new MField(MModificator.PUBLIC, "value", false, DefTypes.STRING, null);
	clazz.setModificator(MModificator.PUBLIC);
	clazz.addField(nameField);
	clazz.addField(valueField);
	StringBuilder codeBuilder = new StringBuilder();
	clazz.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }

   @Test
   public void generateCodeWithAnnotations()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("package pp.keebraa.java.monkeyCode.example;\n");
	expectedCode.append("@Annotation\n");
	expectedCode.append("@AnotherAnnotation\n");
	expectedCode.append("public class SomeClass\n");
	expectedCode.append("{\n");
	expectedCode.append("public String name;\n");
	expectedCode.append("public String value;\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "pp.keebraa.java.monkeyCode.example");
	MField nameField = new MField(MModificator.PUBLIC, "name", false, DefTypes.STRING, null);
	MField valueField = new MField(MModificator.PUBLIC, "value", false, DefTypes.STRING, null);
	MAnnotation annotation1 = new MAnnotation("Annotation", null, null);
	MAnnotation annotation2 = new MAnnotation("AnotherAnnotation", null, null);
	clazz.addAnnotation(annotation1);
	clazz.addAnnotation(annotation2);
	clazz.setModificator(MModificator.PUBLIC);
	clazz.addField(nameField);
	clazz.addField(valueField);
	StringBuilder codeBuilder = new StringBuilder();
	clazz.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }

   @Test
   public void generateCodeWithImports()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("package pp.keebraa.java.monkeyCode.example;\n");
	expectedCode.append("import some.package.Annotation;\n");
	expectedCode.append("import some.package.AnotherAnnotation;\n");
	expectedCode.append("@Annotation\n");
	expectedCode.append("@AnotherAnnotation\n");
	expectedCode.append("public class SomeClass\n");
	expectedCode.append("{\n");
	expectedCode.append("public String name;\n");
	expectedCode.append("public String value;\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "pp.keebraa.java.monkeyCode.example");
	MField nameField = new MField(MModificator.PUBLIC, "name", false, DefTypes.STRING, null);
	MField valueField = new MField(MModificator.PUBLIC, "value", false, DefTypes.STRING, null);
	MAnnotation annotation1 = new MAnnotation("Annotation", "some.package", null);
	MAnnotation annotation2 = new MAnnotation("AnotherAnnotation", "some.package", null);
	clazz.addAnnotation(annotation1);
	clazz.addAnnotation(annotation2);
	clazz.setModificator(MModificator.PUBLIC);
	clazz.addField(nameField);
	clazz.addField(valueField);
	StringBuilder codeBuilder = new StringBuilder();
	clazz.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }

   @Test
   public void generateCodeWithOneVoidMethod()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("package pp.keebraa.java.monkeyCode.example;\n");
	expectedCode.append("import some.package.Annotation;\n");
	expectedCode.append("import some.package.AnotherAnnotation;\n");
	expectedCode.append("@Annotation\n");
	expectedCode.append("@AnotherAnnotation\n");
	expectedCode.append("public class SomeClass\n");
	expectedCode.append("{\n");
	expectedCode.append("public String name;\n");
	expectedCode.append("public String value;\n");
	expectedCode.append("public void foo()\n");
	expectedCode.append("{\n");
	expectedCode.append("}\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "pp.keebraa.java.monkeyCode.example");
	MField nameField = new MField(MModificator.PUBLIC, "name", false, DefTypes.STRING, null);
	MField valueField = new MField(MModificator.PUBLIC, "value", false, DefTypes.STRING, null);
	MAnnotation annotation1 = new MAnnotation("Annotation", "some.package", null);
	MAnnotation annotation2 = new MAnnotation("AnotherAnnotation", "some.package", null);
	MMethod method = new MMethod(clazz, "foo");
	clazz.addAnnotation(annotation1);
	clazz.addAnnotation(annotation2);
	clazz.addMethod(method);
	clazz.setModificator(MModificator.PUBLIC);
	clazz.addField(nameField);
	clazz.addField(valueField);
	StringBuilder codeBuilder = new StringBuilder();
	clazz.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }

   /**
    * Check generating of the class with imports, annotations, fields, and
    * method, which contains arguments, which should be imported;
    */
   @Test
   public void generateCodeWithOneMethodAndImport()
   {
	StringBuilder expectedCode = new StringBuilder();
	expectedCode.append("package pp.keebraa.java.monkeyCode.example;\n");
	expectedCode.append("import some.package.SomeClass;\n");
	expectedCode.append("import some.package.Annotation;\n");
	expectedCode.append("import some.package.AnotherAnnotation;\n");
	expectedCode.append("@Annotation\n");
	expectedCode.append("@AnotherAnnotation\n");
	expectedCode.append("public class SomeClass\n");
	expectedCode.append("{\n");
	expectedCode.append("public String name;\n");
	expectedCode.append("public String value;\n");
	expectedCode.append("public void foo(String value, SomeClass someClass)\n");
	expectedCode.append("{\n");
	expectedCode.append("}\n");
	expectedCode.append("}\n");
	MClass clazz = new MClass("SomeClass", "pp.keebraa.java.monkeyCode.example");
	MField nameField = new MField(MModificator.PUBLIC, "name", false, DefTypes.STRING, null);
	MField valueField = new MField(MModificator.PUBLIC, "value", false, DefTypes.STRING, null);
	MAnnotation annotation1 = new MAnnotation("Annotation", "some.package", null);
	MAnnotation annotation2 = new MAnnotation("AnotherAnnotation", "some.package", null);

	MMethod method = new MMethod(clazz, "foo");
	MTypeValue value1 = new MTypeValue(DefTypes.STRING, "value");
	MClass someClass = new MClass("SomeClass", "some.package");
	MTypeValue value2 = new MTypeValue(someClass, "someClass");
	method.addArgument(value1);
	method.addArgument(value2);
	clazz.addAnnotation(annotation1);
	clazz.addAnnotation(annotation2);
	clazz.addMethod(method);
	clazz.setModificator(MModificator.PUBLIC);
	clazz.addField(nameField);
	clazz.addField(valueField);
	StringBuilder codeBuilder = new StringBuilder();
	clazz.generateCode(codeBuilder);
	String code = codeBuilder.toString();
	assertNotNull(code);
	assertEquals(expectedCode.toString(), code);
   }
}
