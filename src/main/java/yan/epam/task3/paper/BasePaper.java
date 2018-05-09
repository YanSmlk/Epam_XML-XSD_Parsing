package yan.epam.task3.paper;

public interface BasePaper
{
    String getId();
    String getTitle();
    boolean getMounthly();
    boolean getColored();
    int getPages();
    boolean getGlossy();

    void setTitle(String title);
    void setMounthly(Boolean mounthly);
    void setColored(Boolean colored);
    void setPages(int pages);
    void setGlossy(Boolean glossy);
}
