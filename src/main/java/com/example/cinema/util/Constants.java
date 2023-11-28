package com.example.cinema.util;

public class Constants {
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";
    public static final String DEFAULT_DAY = "30";
    public static final int SORT_DIRECTION_ASC = 0;
    public static final int SORT_DIRECTION_DESC = 1;
    public static final int SORT_BY_TIME = 0;
    public static final int SORT_BY_PRICE = 1;
    //rated
    public static final int ALL_AUDIENCES = 0;
    public static final int UNDER_13 = 1;
    public static final int OVER_13 = 2;
    public static final int OVER_16 = 3;
    public static final int OVER_18 = 4;
    //rated

    //Movies
    public static final int LIST_COMING_SOON_MOVIES = 0;
    public static final int LIST_NOW_SHOWING_MOVIES = 1;
    public static final int LIST_NEWLY_RELEASED_MOVIES = 2;
    //Movies
    public static final String DEFAULT_FORMAT_DATE = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    public static final String PHONE_NUMBER_PATTERN = "(0[3|5|7|8|9])+([0-9]{8})\\b";
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\" + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
    public static final int DEFAULT_BY_CINEMA = 0;
}
