package pp.keebraa.java.mockeycode.coremodel.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.expressions.ExpressionSnippet;
import pp.keebraa.java.monkeycoder.coremodel.types.MAnnotation;
import pp.keebraa.java.monkeycoder.coremodel.types.MField;
import pp.keebraa.java.monkeycoder.coremodel.types.MModificator;
import pp.keebraa.java.monkeycoder.coremodel.types.MVariable;
import pp.keebraa.java.monkeycoder.coremodel.types.expressions.ExpressionSyntax;
import pp.keebraa.java.monkeycoder.types.def.DefTypes;

public class MFieldTest
{
    @Test
    public void generateCodeSimpleField()
    {
        String expectedString = "public String someName;\n";
        MVariable variable = new MVariable(DefTypes.STRING, "someName");
        MField stringName = new MField(variable);
        stringName.setModificator(MModificator.PUBLIC);
        CodeSnippet snippet = stringName.getCodeSnippet();
        String code = snippet.getCode();
        assertNotNull(code);
        assertEquals(expectedString, code);
    }

    @Test
    public void generateCodeSimpleStaticField()
    {
        String expectedString = "public static String someName;\n";
        MVariable variable = new MVariable(DefTypes.STRING, "someName");
        MField stringName = new MField(variable);
        stringName.setModificator(MModificator.PUBLIC);
        stringName.setStatic(true);
        CodeSnippet snippet = stringName.getCodeSnippet();
        String code = snippet.getCode();
        assertNotNull(code);
        assertEquals(expectedString, code);
    }

    @Test
    public void generateCodeSimpleFieldWithOneAnnotation()
    {
        String expectedString = "@Column\npublic String someName;\n";
        MAnnotation annotation = new MAnnotation("Column",
                "com.hibernate.annotations", null);
        List<MAnnotation> annotations = new ArrayList<MAnnotation>();
        annotations.add(annotation);
        MVariable variable = new MVariable(DefTypes.STRING, "someName");
        MField stringName = new MField(variable);
        stringName.setModificator(MModificator.PUBLIC);
        stringName.setAnnotations(annotations);
        CodeSnippet snippet = stringName.getCodeSnippet();
        String code = snippet.getCode();
        assertNotNull(code);
        assertEquals(expectedString, code);
    }

    @Test
    public void generateCodeSimpleFieldWithRightPart()
    {
        StringBuilder expectedCodeBuilder = new StringBuilder();
        expectedCodeBuilder.append("public String someName = \"a\";\n");
        ExpressionSyntax rightPart = Mockito.mock(ExpressionSyntax.class);
        ExpressionSnippet rightPartSnippet = Mockito.mock(ExpressionSnippet.class);
        Mockito.when(rightPart.getCodeSnippet()).thenReturn(rightPartSnippet);
        Mockito.when(rightPartSnippet.getCode()).thenReturn("\"a\"");
        MVariable variable = new MVariable(DefTypes.STRING, "someName");
        MField stringName = new MField(variable);
        stringName.setRightPart(rightPart);
        stringName.setModificator(MModificator.PUBLIC);
        CodeSnippet snippet = stringName.getCodeSnippet();
        String code = snippet.getCode();
        assertNotNull(code);
        assertEquals(expectedCodeBuilder.toString(), code);
    }
}
