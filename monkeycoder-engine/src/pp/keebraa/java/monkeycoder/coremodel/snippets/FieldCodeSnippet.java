package pp.keebraa.java.monkeycoder.coremodel.snippets;

import java.util.HashSet;
import java.util.Set;

import pp.keebraa.java.monkeycoder.coremodel.types.MAnnotation;
import pp.keebraa.java.monkeycoder.coremodel.types.MField;
import pp.keebraa.java.monkeycoder.coremodel.types.MType;

/**
 * This snippet generates code for variable initialization. IF your field object
 * contains both right and left part, you get something like public String name
 * = "myName";. In other words - you get your variable and initialization
 * expression after equal clause. Otherwise, it your field has only leftPart
 * (variable), you get something like public static String myVariable; in other
 * words - without initialization expression.
 * 
 * @author taqi
 * 
 */
public class FieldCodeSnippet implements SetCodeSnippet
{
    private MField field;

    public FieldCodeSnippet(MField field)
    {
        this.field = field;
    }

    @Override
    public Set<CodeSnippet> getCodeSnippets()
    {
        return new HashSet<CodeSnippet>();
    }

    @Override
    public void addCodeSnippet(CodeSnippet snippet)
    {
    }

    @Override
    public String getCode()
    {
        StringBuilder builder = new StringBuilder();
        for (MAnnotation annotation : field.getAnnotations())
        {
            builder.append(annotation.getCodeSnippet().getCode());
        }
        builder.append(field.getModificator().getValue());
        if (field.isStatic())
        {
            builder.append("static ");
        }
        builder.append(field.getVariable().getType().getClassName() + " ");
        builder.append(field.getVariable().getName());
        if (field.getRightPart() != null)
        {
            builder.append(" = ");
            builder.append(field.getRightPart().getCodeSnippet().getCode());
        }
        builder.append(";\n");
        return builder.toString();
    }

    @Override
    public Set<MType> getUsedTypes()
    {
        Set<MType> types = new HashSet<MType>();
        types.addAll(field.getRightPart().getCodeSnippet().getUsedTypes());
        types.addAll(field.getLeftPart().getCodeSnippet().getUsedTypes());
        return types;
    }
}
