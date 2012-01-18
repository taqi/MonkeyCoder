package pp.keebraa.java.monkeycoder.types;

import java.util.Map;

/**
 * Resolve all types in the project
 * 
 * @author taqi
 * 
 */
public class TypeRepository
{
   private Map<String, MType> types;
   
   public MType getTypeByName(String className)
   {
	return types.get(className);
   }
   
   public void addClass(MType type)
   {
	types.put(type.getClassName(), type);
   }
   
   public void addClass(String className, String packageName)
   {
	MType type = new MType(className, packageName);
	types.put(className, type);
   }
}
