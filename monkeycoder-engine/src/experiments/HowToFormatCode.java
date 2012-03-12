package experiments;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

public class HowToFormatCode
{
   public static void main(String[] args) throws MalformedTreeException, BadLocationException
   {
	CodeFormatter formatter = ToolFactory.createCodeFormatter(null);
	String code = "import java.lang.Integer; @Deprecated public class AAA { @Deprecated public void main(){}}";
	TextEdit textEdit = null;
	for(int i = 0; i < Integer.MAX_VALUE; i++)
	{
	   textEdit = formatter.format(CodeFormatter.K_UNKNOWN, code, 0, code.length(), 0, null);
	   if(textEdit != null)
		System.out.println("with "+i);
	}
	IDocument doc = new Document();
	doc.set(code);
	textEdit.apply(doc);
	System.out.println(doc.get());
   }
}
