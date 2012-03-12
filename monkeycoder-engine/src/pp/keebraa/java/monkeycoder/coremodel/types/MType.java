package pp.keebraa.java.monkeycoder.coremodel.types;

/**
 * Basic class for types, such as String, etc.
 * 
 * @author taqi
 * 
 */
public class MType
{
   private String className;
   private String packageName;

   public MType(String className, String packageName)
   {
	this.className = className;
	this.packageName = (packageName == null)? "" : packageName;
   }

   public String getClassName()
   {
	return className;
   }

   public void setClassName(String className)
   {
	this.className = className;
   }

   public String getPackageName()
   {
	return packageName;
   }

   public void setPackageName(String packageName)
   {
	this.packageName = packageName;
   }

   /**
    * If your type is a simple (in your class you don't need import of this
    * type), this method must return false;
    * 
    * @return
    */
   public boolean isSimple()
   {
	return false;
   }

   /**
    * Return true if your class is in the same package with current type;
    * 
    * @param packageString
    *           package of your class
    * @return true, if they are in the same package.
    */
   public boolean isInTheSamePackage(String packageString)
   {
	return packageName.equals(packageString);
   }

   @Override
   public int hashCode()
   {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((className == null) ? 0 : className.hashCode());
	result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
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
	MType other = (MType) obj;
	if (className == null)
	{
	   if (other.className != null)
		return false;
	}
	else if (!className.equals(other.className))
	   return false;
	if (packageName == null)
	{
	   if (other.packageName != null)
		return false;
	}
	else if (!packageName.equals(other.packageName))
	   return false;
	return true;
   }
}
