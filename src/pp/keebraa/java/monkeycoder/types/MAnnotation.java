package pp.keebraa.java.monkeycoder.types;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MAnnotation extends MType implements MCode
{
   private Map<String, MTypeValue> values;

   public MAnnotation(String name, String packageName, Map<String, MTypeValue> values)
   {
	super(name, packageName);
	if (values == null)
	{
	   values = new HashMap<String, MTypeValue>();
	}
	this.values = values;
   }

   @Override
   public void generateCode(StringBuilder codeBuilder)
   {
	codeBuilder.append("@" + getClassName());
	if (values.keySet().size() > 0)
	{
	   codeBuilder.append("(");
	   Iterator<String> keyIterator = values.keySet().iterator();
	   while (keyIterator.hasNext())
	   {
		String key = keyIterator.next();
		codeBuilder.append(key + " = ");
		codeBuilder.append(values.get(key).getValue());
		if (keyIterator.hasNext())
		   codeBuilder.append(", ");
	   }
	   codeBuilder.append(")");
	}
	codeBuilder.append("\n");
   }
   
   @Override
   public Set<MType> getUsedTypes()
   {
	Set<MType> types = new HashSet<MType>();
	for(String key : values.keySet())
	{
	   MType type = values.get(key).getType();
	   types.add(type);
	}
	types.add(this);
	return types;
   }

   @Override
   public boolean isSimple()
   {
	return getPackageName().trim().equals("");
   }
}
