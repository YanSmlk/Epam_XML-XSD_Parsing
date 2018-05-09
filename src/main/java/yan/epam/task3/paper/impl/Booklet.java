package yan.epam.task3.paper.impl;

import yan.epam.task3.paper.BasePaper;

public class Booklet implements BasePaper
{
    private String id;
    private String title;
    private boolean mounthly;
    private boolean colored;
    private int pages;
    private boolean glossy;

    public Booklet(String id, String title, boolean mounthly, boolean colored, int pages, boolean glossy)
    {
        this.id=id;
        this.title=title;
        this.mounthly=mounthly;
        this.colored=colored;
        this.pages=pages;
        this.glossy=glossy;
    }

    public Booklet(String id)
    {
        this.id=id;
    }

    @Override
    public void setTitle(String title)
    {
        this.title=title;
    }

    @Override
    public void setMounthly(Boolean mounthly)
    {
        this.mounthly=mounthly;
    }

    @Override
    public void setColored(Boolean colored)
    {
        this.colored=colored;
    }

    @Override
    public void setPages(int pages)
    {
        this.pages=pages;
    }

    @Override
    public void setGlossy(Boolean glossy)
    {
        this.glossy=glossy;
    }


    @Override
    public String getId()
    {
        return id;
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean getMounthly(){return mounthly;}

    @Override
    public boolean getColored(){return colored;}

    @Override
    public int getPages() {
        return pages;
    }

    @Override
    public boolean getGlossy(){return glossy;}

    @Override
    public String toString()
    {
        return  "Booklet" +
                " id:" + id+
                " tittle:" + title +
                " mounthly:" + mounthly+
                " colored:" + colored+
                " pages:" + pages+
                " glossy:" + glossy;
    }

}
