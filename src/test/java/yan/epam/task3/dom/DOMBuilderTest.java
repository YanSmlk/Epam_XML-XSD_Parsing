package yan.epam.task3.dom;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import yan.epam.task3.builder.Director;
import yan.epam.task3.exception.XmlBuilderException;
import yan.epam.task3.paper.BasePaper;
import java.util.ArrayList;
import static org.testng.AssertJUnit.fail;


public class DOMBuilderTest
{
   private ArrayList<BasePaper> newspapers;
   private ArrayList<BasePaper> journals;
   private ArrayList<BasePaper> booklets;
   private ArrayList<BasePaper> papersArr;


    @AfterMethod
    public void clearMethodParam()
    {
        papersArr=null;
        newspapers=null;
        journals=null;
        booklets=null;
    }

    @Test
    public void noFileTest()
    {
        try
        {
            String filePath = "no.xml";
            papersArr = Director.createPapers("DOM", filePath);
            newspapers=Director.getNewspapers(papersArr);
            fail();
        }
        catch (XmlBuilderException ex)
        {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void papersArrayTest()
    {
        final int EXPECTED=17;
        try
        {
            String filePath = "Papers.xml";
            papersArr = Director.createPapers("DOM", filePath);
            Assert.assertEquals(papersArr.size(),EXPECTED);
        }
        catch (XmlBuilderException ex)
        {
            fail();
        }
    }

    @Test
    public void newspapersArrayTest()
    {
        final int EXPECTED=6;
        try
        {
            String filePath = "Papers.xml";
            papersArr = Director.createPapers("DOM", filePath);
            newspapers=Director.getNewspapers(papersArr);
            Assert.assertEquals(newspapers.size(),EXPECTED);
        }
        catch (XmlBuilderException ex)
        {
            fail();
        }
    }

    @Test
    public void journalsArrayTest()
    {
        final int EXPECTED=6;
        try
        {
            String filePath = "Papers.xml";
            papersArr = Director.createPapers("DOM", filePath);
            journals=Director.getJournals(papersArr);
            Assert.assertEquals(journals.size(),EXPECTED);
        }
        catch (XmlBuilderException ex)
        {
            fail();
        }
    }

    @Test
    public void bookletsArrayTest()
    {
        final int EXPECTED=5;
        try
        {
            String filePath = "Papers.xml";
            papersArr = Director.createPapers("DOM", filePath);
            booklets=Director.getBooklets(papersArr);
            Assert.assertEquals(booklets.size(),EXPECTED);
        }
        catch (XmlBuilderException ex)
        {
            fail();
        }
    }

}
