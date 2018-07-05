package com.blogapp.models;

public class BlogPost {
    private static int maxID = 0;
    private int id;
    private String author;
    private String content;

    public BlogPost(){
        new BlogPost( null, null);
    }

    public BlogPost( String author, String content) {
        maxID += 1;
        setId(maxID);
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static int getMaxID(){
        return maxID;
    }
}
