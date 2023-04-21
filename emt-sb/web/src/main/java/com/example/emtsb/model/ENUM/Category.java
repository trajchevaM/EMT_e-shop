package com.example.emtsb.model.ENUM;

public enum Category {
    NOVEL,
    THRILER,
    HISTORY,
    FANTASY,
    BIOGRAPHY,
    CLASSICS,
    DRAMA;

    public static boolean isItACategoryName(String name) {
        Category result = null;
        for (Category category : Category.values()) {
            if (category.name().equalsIgnoreCase(name)) {
                result = category;
                break;
            }
        }
        return result != null;
    }
}
