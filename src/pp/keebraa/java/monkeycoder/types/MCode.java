package pp.keebraa.java.monkeycoder.types;

import java.util.Set;

public interface MCode
{
   /**
    * All implementors of this interface should generate its code by this
    * method.
    * 
    * @param codeBuilder
    *           - StringBuilder for the whole code;
    */
   public void generateCode(StringBuilder codeBuilder);

   /**
    * All implementors should return all types, that they need for code, via
    * this method.
    * 
    * @return used types;
    */
   public Set<MType> getUsedTypes();
}
