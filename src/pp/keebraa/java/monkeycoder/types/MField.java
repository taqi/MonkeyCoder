package pp.keebraa.java.monkeycoder.types;

import java.util.ArrayList;
import java.util.List;

public class MField implements MCode
{
   private MModificator modificator;

   private String name;

   private boolean isStatic;

   private MType type;

   private List<MAnnotation> annotations;
   
   public MField(MModificator modificator, String name, boolean isStatic, MType type, List<MAnnotation> annotations)
   {
	super();
	this.modificator = modificator;
	this.name = name;
	this.isStatic = isStatic;
	this.type = type;
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

   public MType getType()
   {
	return type;
   }

   public void setType(MType type)
   {
	this.type = type;
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
   public void generateCode(StringBuilder codeBuilder)
   {
	for(MAnnotation annotation : annotations)
	{
	   annotation.generateCode(codeBuilder);
	}
	codeBuilder.append(modificator.getValue());
	if(isStatic)
	   codeBuilder.append("static"+" ");
	codeBuilder.append(type.getClassName()+" ");
	codeBuilder.append(name);
	codeBuilder.append(";\n");
	
   }
   
   @Override
   public int hashCode()
   {
	final int prime = 31;
	int result = 1;
	result = prime * result + (isStatic ? 1231 : 1237);
	result = prime * result + ((modificator == null) ? 0 : modificator.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
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
	if (type == null)
	{
	   if (other.type != null)
		return false;
	}
	else if (!type.equals(other.type))
	   return false;
	return true;
   }
}
