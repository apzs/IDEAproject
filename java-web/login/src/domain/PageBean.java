package domain;

import java.util.List;

/**
 * 分页功能
  @author 无名氏
 * @Data 2021/7/4
 */
public class PageBean<T> {
    /**
     * totalCount: 查询到的总记录数
     * totalPage:  总页数
     * list:       当前页的数据
     * currentPage:当前页码
     * rows;        每一页包含的行数
     */
    private int totalCount;
    private int totalPage;
    private List<T> list;
    private int currentPage;
    private int rows;

    public PageBean() {
    }

    public PageBean(int currentPage, int rows) {
        this.currentPage = currentPage;
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
