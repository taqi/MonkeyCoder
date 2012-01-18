package pp.keebraa.java.monkeycoder.types;

import java.util.Iterator;

public class ClassCodeGenerator
{
   private StringBuilder codeBuilder;
   
   private MClass clazz;
   
   public ClassCodeGenerator(StringBuilder codeBuilder, MClass clazz)
   {
	this.codeBuilder = codeBuilder;
	this.clazz = clazz;
   }
   
   private void generatePackage()
   {
	codeBuilder.append("package ");
	codeBuilder.append(clazz.getPackageName()+";\n");
   }
   
   private void generateImports()
   {
	for(MType type : clazz.getImportTypes())
	{
	   if(type.isSimple() || type.isInTheSamePackage(clazz.getPackageName()))
		continue;
	   codeBuilder.append("import "+type.getPackageName()+"."+type.getClassName()+";\n");
	}
   }
   
   private void generateBasicClassLine()
   {
	codeBuilder.append(clazz.getModificator().getValue());
	codeBuilder.append("class "+clazz.getClassName());
   }
   
   private void generateExtendsClause()
   {
	codeBuilder.append("extends "+clazz.getParent());
	codeBuilder.append(clazz.getParent());
   }
   
   private void generateImplementsClause()
   {
	if(clazz.getInterfaces() == null || clazz.getInterfaces().size() < 1)
	   return;
	codeBuilder.append("implements ");
	Iterator<MInterface> iterator = clazz.getInterfaces().iterator();
	while(iterator.hasNext())
	{
	   codeBuilder.append(iterator.next());
	   if(iterator.hasNext())
		codeBuilder.append(", ");
	}
   }
   
   private void generateFields()
   {
	for(MField field : clazz.getFields())
	{
	   field.generateCode(codeBuilder);
	}
   }
   
   private void generateMethods()
   {
	for(MMethod method : clazz.getMethods())
	{
	   method.generateCode(codeBuilder);
	}
   }
   private void generateBody()
   {
	codeBuilder.append("\n{\n");
	generateFields();
	generateMethods();
	codeBuilder.append("}\n");
   }
   
   private void generateAnnotations()
   {
	for(MCode code : clazz.getAnnotations())
	{
	   code.generateCode(codeBuilder);
	}
   }
   
   public void buildCode()
   {
	generatePackage();
	generateImports();
	generateAnnotations();
	generateBasicClassLine();
	if(clazz.getParent() != null)
	   generateExtendsClause();
	generateImplementsClause();
	generateBody();
   }
}