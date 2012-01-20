package pp.keebraa.java.monkeycoder.coremodel.types;

import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.VariableExpressionSnippet;

public class MVariable implements MSyntax
{
   private MType type;
   private String name;

   public MVariable(MType type, String name)
   {
	super();
	this.type = type;
	this.name = name;
   }
   public MType getType()
   {
      return type;
   }
   public void setType(MType type)
   {
      this.type = type;
   }
   public String getName()
   {
      return name;
   }
   public void setName(String name)
   {
      this.name = name;
   }
   @Override
   public ExpressionSnippet getCodeSnippet()
   {
	return new VariableExpressionSnippet(this);
   }
   @Override
   public int hashCode()
   {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	MVariable other = (MVariable) obj;
	if (type == null)
	{
	   if (other.type != null)
		return false;
	}
	else if (!type.equals(other.type))
	   return false;
	if (name == null)
	{
	   if (other.name != null)
		return false;
	}
	else if (!name.equals(other.name))
	   return false;
	return true;
   }
}
