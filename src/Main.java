import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

public class Main
{
   public static void main(String[] args) throws MalformedTreeException, BadLocationException
   {
	CodeFormatter formatter = ToolFactory.createCodeFormatter(null);
	String code = "public class AAA { public void main(){}}";
	TextEdit textEdit = formatter.format(CodeFormatter.K_COMPILATION_UNIT, code, 0, code.length(), 0, null);
	IDocument doc = new Document();
	doc.set(code);
	textEdit.apply(doc);
	System.out.println(doc.get());
   }
}
