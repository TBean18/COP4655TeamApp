package com.cop4655.puggymotivation;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Quotes")
public class Quotes extends ParseObject {

    public static final String KEY_AUTHOR = "Author";
    public static final String KEY_PHRASE = "Phrase";
    public static final String KEY_CATEGORY = "Category";
    public static final String KEY_CREATED_KEY = "createdAt";

    public String getAuthor(){
        return getString(KEY_AUTHOR);
    }

    public void setAuthor(String Author){
        put(KEY_AUTHOR, Author);
    }

    public String getPhrase(){
        return getString(KEY_PHRASE);
    }

    public void setPhrase(String Phrase){
        put(KEY_PHRASE, Phrase);
    }

    public String getCategory(){
        return getString(KEY_CATEGORY);
    }

    public void setCategory(String Category){
        put(KEY_CATEGORY, Category);
    }
}
