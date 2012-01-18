package pp.keebraa.java.monkeycoder.types;

import java.util.Iterator;

public class MethodCodeGenerator
{
   private MMethod method;

   private StringBuilder codeBuilder;

   public MethodCodeGenerator(MMethod method, StringBuilder codeBuilder)
   {
	this.method = method;
	this.codeBuilder = codeBuilder;
   }

   private void generateAnnotations()
   {
	for (MAnnotation annotation : method.getAnnotations())
	{
	   annotation.generateCode(codeBuilder);
	}
   }

   private void generateBasicMethodClause()
   {
	codeBuilder.append(method.getModificator().getValue());
	codeBuilder.append(method.getReturnedType().getClassName()+" ");
	codeBuilder.append(method.getName());
   }
   
   private void generateMethodArguments()
   {
	codeBuilder.append("(");
	Iterator<MTypeValue> iterator = method.getArguments().iterator();
	while(iterator.hasNext())
	{
	   MTypeValue arg = iterator.next();
	   codeBuilder.append(arg.getType().getClassName());
	   codeBuilder.append(" ");
	   codeBuilder.append(arg.getValue());
	   if(iterator.hasNext())
		codeBuilder.append(", ");
	}
	codeBuilder.append(")\n");
   }
   
   private void generateMethodBody()
   {
	codeBuilder.append("{\n");
	codeBuilder.append(method.getCode());
	codeBuilder.append("}\n");
   }
   
   public void buildCode()
   {
	generateAnnotations();
	generateBasicMethodClause();
	generateMethodArguments();
	generateMethodBody();
   }
}
