package pp.keebraa.java.monkeycoder.coremodel.types;

import java.util.List;

public interface MSyntaxConstruction extends MSyntax
{
   public void addSyntax(MSyntax syntax);
   public List<MSyntax> getSyntax();
}
