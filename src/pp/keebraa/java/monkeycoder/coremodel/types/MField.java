package pp.keebraa.java.monkeycoder.coremodel.types;

import java.util.ArrayList;
import java.util.List;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.FieldCodeSnippet;

/**
 * Represents one class field. (e.g. public String name;) LeftPart field is the
 * variable. Th rightPart is its initialization with some expression or another
 * variable.
 * 
 * @author taqi
 * 
 */
public class MField implements MSyntax
{
    private MModificator modificator;

    private boolean isStatic;

    private MVariable leftPart;

    private MSyntax rightPart;

    private List<MAnnotation> annotations;

    public MField(MModificator modificator, boolean isStatic,
            List<MAnnotation> annotations, MVariable leftPart, MSyntax rightPart)
    {
        super();
        this.modificator = modificator;
        this.isStatic = isStatic;
        this.leftPart = leftPart;
        this.rightPart = rightPart;
        if (annotations == null)
        {
            annotations = new ArrayList<MAnnotation>();
        }
        this.annotations = annotations;
    }

    public MField(MVariable variable)
    {
        this(MModificator.DEFAULT, false, null, variable, null);
    }

    public MModificator getModificator()
    {
        return modificator;
    }

    public void setModificator(MModificator modificator)
    {
        this.modificator = modificator;
    }

    public MVariable getLeftPart()
    {
        return leftPart;
    }

    public void setLeftPart(MVariable leftPart)
    {
        this.leftPart = leftPart;
    }

    public MSyntax getRightPart()
    {
        return rightPart;
    }

    public void setRightPart(MSyntax rightPart)
    {
        this.rightPart = rightPart;
    }

    public boolean isStatic()
    {
        return isStatic;
    }

    public void setStatic(boolean isStatic)
    {
        this.isStatic = isStatic;
    }

    public MVariable getVariable()
    {
        return leftPart;
    }

    public void setVariable(MVariable variable)
    {
        this.leftPart = variable;
    }

    public void setAnnotations(List<MAnnotation> annotations)
    {
        this.annotations = annotations;
    }

    public void addAnnotation(MAnnotation annotation)
    {
        this.annotations.add(annotation);
    }

    public List<MAnnotation> getAnnotations()
    {
        return annotations;
    }

    @Override
    public CodeSnippet getCodeSnippet()
    {
        return new FieldCodeSnippet(this);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isStatic ? 1231 : 1237);
        result = prime * result
                + ((modificator == null) ? 0 : modificator.hashCode());
        result = prime * result
                + ((rightPart == null) ? 0 : rightPart.hashCode());
        result = prime * result
                + ((leftPart == null) ? 0 : leftPart.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MField other = (MField) obj;
        if (isStatic != other.isStatic)
            return false;
        if (modificator != other.modificator)
            return false;
        if (rightPart == null)
        {
            if (other.rightPart != null)
                return false;
        }
        else if (!rightPart.equals(other.rightPart))
            return false;
        if (leftPart == null)
        {
            if (other.leftPart != null)
                return false;
        }
        else if (!leftPart.equals(other.leftPart))
            return false;
        return true;
    }
}
