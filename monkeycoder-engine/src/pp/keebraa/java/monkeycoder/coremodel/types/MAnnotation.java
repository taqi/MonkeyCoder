package pp.keebraa.java.monkeycoder.coremodel.types;

import java.util.HashMap;
import java.util.Map;

import pp.keebraa.java.monkeycoder.coremodel.snippets.AnnotationCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;

public class MAnnotation extends MType implements MSyntax
{
   private Map<String, MVariable> values;

   public MAnnotation(String name, String packageName, Map<String, MVariable> values)
   {
	super(name, packageName);
	if (values == null)
	{
	   values = new HashMap<String, MVariable>();
	}
	this.values = values;
   }

   public Map<String, MVariable> getValues()
   {
	return values;
   }
   
   public void setValues(Map<String, MVariable> values)
   {
	this.values = values;
   }
   
   public void addValue(String key, MVariable value)
   {
	values.put(key, value);
   }
   
   @Override
   public boolean isSimple()
   {
	return getPackageName().trim().equals("");
   }

   @Override
   public CodeSnippet getCodeSnippet()
   {
	return new AnnotationCodeSnippet(this);
   }
}
