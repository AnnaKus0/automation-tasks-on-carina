package com.solvd.constans;

public enum SidebarTitle {
    HOME("Home"),
    CATALOG("Catalog"),
    BLOG("Blog"),
    ABOUT_US("About Us"),
    WISH_LIST("Wish list"),
    REFER_A_FRIEND("Refer a friend"),
    LOGIN("Login"),
    CREATE_ACCOUNT("Create account"),
    ACCOUNT("Account"),
    LOGOUT("Logout");

    private String title;

    SidebarTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}