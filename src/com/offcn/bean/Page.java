package com.offcn.bean;

public class Page {
    public static final int PAGE_SIZE = 3;

    public static int getPageSize() {
        return PAGE_SIZE;
    }

    private int currentPage;
    private int totalPage;
    private int totalNum;



    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalNum=" + totalNum +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }


    public Page(int currentPage, int totalPage, int totalNum) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalNum = totalNum;
    }

    public Page() {
    }


}
