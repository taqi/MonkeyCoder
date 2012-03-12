package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MAnnotation;
import pp.keebraa.java.monkeycoder.coremodel.types.MMethod;
import pp.keebraa.java.monkeycoder.coremodel.types.MSyntax;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;

public class MethodCodeSnippet implements ListCodeSnippet
{
   private MMethod method;
   
   private ParenthesisCodeSnippet arguments;
   
   private List<CodeSnippet> codeSnippets;
   
   public MethodCodeSnippet(MMethod method)
   {
	this.method = method;
	createArguments(method);
	createCode(method);
   }
   
   private void createArguments(MMethod method)
   {
	arguments = new ParenthesisCodeSnippet();
	for(MVariable variable : method.getArguments())
	{
	   arguments.addCodeSnippet(variable.getCodeSnippet());
	}
   }
   
   private void createCode(MMethod method)
   {
	codeSnippets = new ArrayList<CodeSnippet>();
	for(MSyntax syntax : method.getSyntax())
	{
	   codeSnippets.add(syntax.getCodeSnippet());
	}
   }
   
   public void setArgumentsSnippet(ParenthesisCodeSnippet snippet)
   {
	this.arguments = snippet;
   }
   
   public CodeSnippet getArgumentsCodeSnippet()
   {
	return arguments;
   }
   
   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	types.add(method.getReturnedType());
	for(CodeSnippet snippet : codeSnippets)
	{
	   types.addAll(snippet.getUsedTypes());
	}
	types.addAll(arguments.getUsedTypes());
	return types;
   }

   @Override
   public void addCodeSnippet(CodeSnippet snippet)
   {
	codeSnippets.add(snippet);
   }

   @Override
   public String getCode()
   {
	StringBuilder builder = new StringBuilder();
	for(MAnnotation annotation : method.getAnnotations())
	{
	   builder.append(annotation.getCodeSnippet().getCode());   
	}
	builder.append(method.getModificator().getValue());
	if(method.isStatic())
	   builder.append("static ");
	builder.append(method.getReturnedType().getClassName());
	builder.append(" ");
	builder.append(method.getName());
	builder.append(arguments.getCode());
	builder.append("\n");
	BraceBlockCodeSnippet body = new BraceBlockCodeSnippet();
	for(CodeSnippet snippet : codeSnippets)
	{
	   body.addCodeSnippet(snippet);
	}
	builder.append(body.getCode());
	return builder.toString();
   }

   @Override
   public List<CodeSnippet> getCodeSnippets()
   {
	return codeSnippets;
   }
}
