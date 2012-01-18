package pp.keebraa.java.monkeycoder.types;

public enum MModificator
{
   PUBLIC("public "),
   PROTECTED("protected "),
   DEFAULT(""),
   PRIVATE("private ");
   
   private String value;
   
   MModificator(String value)
   {
	this.value = value;
   }
   
   public String getValue()
   {
	return value;
   }
}
