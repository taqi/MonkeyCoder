package pp.keebraa.java.monkeycoder.coremodel.types;

/**
 * Pay attention that modificator contains space after its clause. The main goal
 * for it is that we don't need to add one space after DEFAULT clause.
 * 
 * @author taqi
 * 
 */
public enum MModificator
{
   PUBLIC("public "), PROTECTED("protected "), DEFAULT(""), PRIVATE("private ");

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
