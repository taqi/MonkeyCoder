package pp.keebraa.java.monkeycoder.coremodel.types;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;

public class MClass extends MType implements MSyntax
{
   private MModificator modificator;

   private MClass parent;

   private List<MInterface> interfaces;

   private List<MMethod> methods;

   private List<MField> fields;
   
   private List<MAnnotation> annotations;

   public MClass(String name, String packageName)
   {
	super(name, packageName);
	fields = new ArrayList<MField>();
	interfaces = new ArrayList<MInterface>();
	methods = new ArrayList<MMethod>();
	annotations = new ArrayList<MAnnotation>();
   }

   public List<MAnnotation> getAnnotations()
   {
      return annotations;
   }

   public void setAnnotations(List<MAnnotation> annotations)
   {
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

   public MClass getParent()
   {
	return parent;
   }

   public void setParent(MClass parent)
   {
	this.parent = parent;
   }

   public List<MInterface> getInterfaces()
   {
	return interfaces;
   }

   public void setInterfaces(List<MInterface> interfaces)
   {
	this.interfaces = interfaces;
   }

   public List<MMethod> getMethods()
   {
	return methods;
   }

   public void setMethods(List<MMethod> methods)
   {
	this.methods = methods;
   }

   public void addMethod(MMethod method)
   {
	this.methods.add(method);
   }
   
   public List<MField> getFields()
   {
	return fields;
   }

   public void setFields(List<MField> fields)
   {
	this.fields = fields;
   }
   
   public void addField(MField field)
   {
	fields.add(field);
   }
   
   public void addAnnotation(MAnnotation annotation)
   {
	annotations.add(annotation);
   }
   
   public Set<MType> getImportTypes()
   {
	Set<MType> types = new HashSet<MType>();
	for(MType type : types)
	{
	   types.add(type);
	}
	for(MType type : interfaces)
	{
	   types.add(type);
	}
	for(MType type : annotations)
	{
	   types.add(type);
	}
	for(MMethod method : methods)
	{
	   for(MVariable value : method.getArguments())
	   {
		types.add(value.getType());
	   }
	}
	if(parent != null)
	   types.add(parent);
	return types;
   }

   @Override
   public int hashCode()
   {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((fields == null) ? 0 : fields.hashCode());
	result = prime * result + ((interfaces == null) ? 0 : interfaces.hashCode());
	result = prime * result + ((methods == null) ? 0 : methods.hashCode());
	result = prime * result + ((modificator == null) ? 0 : modificator.hashCode());
	result = prime * result + ((parent == null) ? 0 : parent.hashCode());
	return result;
   }

   @Override
   public boolean equals(Object obj)
   {
	if (this == obj)
	   return true;
	if (!super.equals(obj))
	   return false;
	if (getClass() != obj.getClass())
	   return false;
	MClass other = (MClass) obj;
	if (fields == null)
	{
	   if (other.fields != null)
		return false;
	}
	else if (!fields.equals(other.fields))
	   return false;
	if (interfaces == null)
	{
	   if (other.interfaces != null)
		return false;
	}
	else if (!interfaces.equals(other.interfaces))
	   return false;
	if (methods == null)
	{
	   if (other.methods != null)
		return false;
	}
	else if (!methods.equals(other.methods))
	   return false;
	if (modificator != other.modificator)
	   return false;
	if (parent == null)
	{
	   if (other.parent != null)
		return false;
	}
	else if (!parent.equals(other.parent))
	   return false;
	return true;
   }

   @Override
   public CodeSnippet getCodeSnippet()
   {
	return null;
   }
}
