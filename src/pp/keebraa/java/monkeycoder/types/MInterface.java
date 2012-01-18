package pp.keebraa.java.monkeycoder.types;

import java.util.List;

public class MInterface extends MType
{
   private List<MMethod> methods;
   
   public MInterface(String name, String packageName)
   {
	super(name, packageName);
   }
   
   public void addMethod(MMethod method)
   {
	this.methods.add(method);
   }
   
   public void setMethods(List<MMethod> methods)
   {
	this.methods = methods;
   }
   
   public List<MMethod> getMethods()
   {
	return methods;
   }
}
