package pp.keebraa.java.mockeycode.testutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pp.keebraa.java.monkeycoder.coremodel.snippets.CodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.ListCodeSnippet;
import pp.keebraa.java.monkeycoder.coremodel.snippets.SetCodeSnippet;

/**
 * {@link CodeSnippet} interface has two sub-interfaces: {@link SetCodeSnippet}
 * and {@link ListCodeSnippet}. This util is for SetCodeSnippet testing: you
 * can't exactly know what code your snippet should generate - SetCodeSnippet
 * has no order for code lines. Thats why you should use this class to check are
 * your generated code and expected are equals.
 * 
 * @author taqi
 * 
 */
public class SetCodeSnippetTestUtil
{
   private List<String> expectedLines;
   private String separator;

   public SetCodeSnippetTestUtil()
   {
	expectedLines = new ArrayList<String>();
	separator = "\n";
   }

   public void addExpectedLine(String line)
   {
	expectedLines.add(line);
   }

   public void setSeparator(String separator)
   {
	this.separator = separator;
   }

   /**
    * Note, that String.split() does not contain as a result - empty lines. So,
    * thats why we should set -1 in this method to check also empty line after
    * this shippet.
    * 
    * @param resultCode
    * @return
    */
   public boolean isEqualTo(String resultCode)
   {
	boolean result = true;
	String[] resultLinesArray = resultCode.split(separator, -1);
	List<String> resultLines = Arrays.asList(resultLinesArray);
	result &= resultLines.containsAll(expectedLines);
	result &= expectedLines.containsAll(resultLines);
	return result;
   }
}
