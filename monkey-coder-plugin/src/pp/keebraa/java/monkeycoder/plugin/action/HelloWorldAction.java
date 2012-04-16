package pp.keebraa.java.monkeycoder.plugin.action;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IActionDelegate;

public class HelloWorldAction implements IActionDelegate
{

   private IProject project;

   @Override
   public void run(IAction arg0)
   {
	IJavaProject javaProject = JavaCore.create(project);
	Map<?, ?> options = javaProject.getOptions(true);
	CodeFormatter formatter = ToolFactory.createCodeFormatter(options);
	String content = "import java.lang.Integer; public class AAA{ @Deprecated public void main(){}}";
	IDocument doc = new Document(content);
	TextEdit edit = formatter.format(CodeFormatter.K_COMPILATION_UNIT, doc.get(), 0, doc.get().length(), 0, null);
	try
	{
	   edit.apply(doc);
	}
	catch (MalformedTreeException | BadLocationException e)
	{
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	}
	content = doc.get();
	System.out.println("======================================================");
	System.out.println(content);
   }

   @Override
   public void selectionChanged(IAction arg0, ISelection selection)
   {
	IStructuredSelection structuredSelection = (IStructuredSelection) selection;
	project = (IProject) structuredSelection.getFirstElement();
   }
}
