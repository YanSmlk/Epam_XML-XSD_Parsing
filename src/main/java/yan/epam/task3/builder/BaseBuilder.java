package yan.epam.task3.builder;

import yan.epam.task3.exception.XmlBuilderException;
import yan.epam.task3.paper.BasePaper;
import java.util.ArrayList;

public abstract class BaseBuilder
{
    protected ArrayList<BasePaper> papersArr=new ArrayList<>();
    protected static final String NEWSPAPER="newspaper";
    protected static final String JOURNAL="journal";
    protected static final String BOOKLET="booklet";

    public ArrayList<BasePaper> getPapersArr()
    {
        return papersArr;
    }

    public abstract void buildPapersArr(String fileName) throws XmlBuilderException;

}
