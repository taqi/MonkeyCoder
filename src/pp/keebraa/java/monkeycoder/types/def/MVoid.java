package pp.keebraa.java.monkeycoder.types.def;

import pp.keebraa.java.monkeycoder.types.MType;

public class MVoid extends MType
{
   private static MVoid singleton;
   
   private MVoid()
   {
	super("void", "");
   }
   
   public static MVoid instance()
   {
	if(singleton == null)
	{
	   singleton = new MVoid();
	}
	return singleton;
   }
   @Override
   public boolean isSimple()
   {
	return true;
   }
}
