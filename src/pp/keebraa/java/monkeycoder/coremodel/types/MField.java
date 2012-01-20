package pp.keebraa.java.monkeycoder.coremodel.types;

import java.util.ArrayList;
import java.util.List;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.FieldCodeSnippet;

/**
 * Represents one class field. (e.g. public String name;)
 * 
 * @author taqi
 * 
 */
public class MField implements MSyntax
{
   private MModificator modificator;

   private String name;

   private boolean isStatic;

   private MVariable variable;

   private List<MAnnotation> annotations;

   public MField(MModificator modificator, String name, boolean isStatic, MVariable variable,
	   List<MAnnotation> annotations)
   {
	super();
	this.modificator = modificator;
	this.name = name;
	this.isStatic = isStatic;
	this.variable = variable;
	if (annotations == null)
	{
	   annotations = new ArrayList<MAnnotation>();
	}
	this.annotations = annotations;
   }

   public MModificator getModificator()
   {
	return modificator;
   }

   public void setModificator(MModificator modificator)
   {
	this.modificator = modificator;
   }

   public String getName()
   {
	return name;
   }

   public void setName(String name)
   {
	this.name = name;
   }

   public boolean isStatic()
   {
	return isStatic;
   }

   public void setStatic(boolean isStatic)
   {
	this.isStatic = isStatic;
   }

   public MVariable getVariable()
   {
	return variable;
   }

   public void setVariable(MVariable variable)
   {
	this.variable = variable;
   }

   public void setAnnotations(List<MAnnotation> annotations)
   {
	this.annotations = annotations;
   }

   public void addAnnotation(MAnnotation annotation)
   {
	this.annotations.add(annotation);
   }

   public List<MAnnotation> getAnnotations()
   {
	return annotations;
   }

   @Override
   public CodeSnippet getCodeSnippet()
   {
	return new FieldCodeSnippet(this);
   }
   
   @Override
   public int hashCode()
   {
	final int prime = 31;
	int result = 1;
	result = prime * result + (isStatic ? 1231 : 1237);
	result = prime * result + ((modificator == null) ? 0 : modificator.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((variable == null) ? 0 : variable.hashCode());
	return result;
   }

   @Override
   public boolean equals(Object obj)
   {
	if (this == obj)
	   return true;
	if (obj == null)
	   return false;
	if (getClass() != obj.getClass())
	   return false;
	MField other = (MField) obj;
	if (isStatic != other.isStatic)
	   return false;
	if (modificator != other.modificator)
	   return false;
	if (name == null)
	{
	   if (other.name != null)
		return false;
	}
	else if (!name.equals(other.name))
	   return false;
	if (variable == null)
	{
	   if (other.variable != null)
		return false;
	}
	else if (!variable.equals(other.variable))
	   return false;
	return true;
   }
}
