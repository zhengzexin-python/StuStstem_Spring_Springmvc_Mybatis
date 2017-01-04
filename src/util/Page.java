package util;

/**
 * Created by 25397 on 2016/12/20.
 */
public class Page {
    private int currentPage=1;
    private int pageSize=3;
    private int nextPage;
    private int prevPage;
    private int totalPage;
    private int total;

    public Page() {
    }

    public Page(int currentPage, int pageSize, int nextPage, int prevPage, int totalPage, int total) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.nextPage = nextPage;
        this.prevPage = prevPage;
        this.totalPage = totalPage;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", nextPage=" + nextPage +
                ", prevPage=" + prevPage +
                ", totalPage=" + totalPage +
                ", total=" + total +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNextPage() {
        nextPage=currentPage+1;
        if(nextPage>totalPage){
            nextPage=totalPage;
        }
        return nextPage;
    }


    public int getPrevPage() {
        prevPage=currentPage-1;
        if(prevPage<1){
            prevPage=1;
        }
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        if(total>0)
            totalPage=(total-1)/pageSize+1;

    }
}
