package org.skypro.skyshop.product;

import java.util.Objects;

public class Article  implements Searchable  {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + text +  " ";
    }

    @Override
    public String getSearchTerm() {
        return name + "  " + text;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }
//
//        @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Article)) return false;
//        return Objects.equals(name, ((Article)o).name);
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Article)) return false;
//        Article article = (Article) o;
//        return Objects.equals(name, article.name);
//    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Searchable other) {
        int lengthComp = Integer.compare
                (other.getSearchTerm().length(), this.getSearchTerm().length());
        if (lengthComp != 0) {
            return lengthComp;
        }
        return this.getSearchTerm().compareTo(other.getSearchTerm());
    }
}
