package pp.keebraa.java.monkeycoder.types.def;

import pp.keebraa.java.monkeycoder.coremodel.types.MType;

public class MString extends MType
{
   private static MString singleton;
   
   private MString()
   {
	super("String", "");
   }
   
   public static MString instance()
   {
	if(singleton == null)
	{
	   singleton = new MString();
	}
	return singleton;
   }
   
   @Override
   public boolean isSimple()
   {
	return true;
   }
}
