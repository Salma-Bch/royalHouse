package model;

public class Mobilier {

    private String type;
    private String style;
    private String name;

    public Mobilier(String type, String style, String name) {
        this.type = type;
        this.style = style;
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setName(String name) {
        this.name = name;
    }
}
