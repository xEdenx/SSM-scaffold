package common;

import java.io.Serializable;
import java.util.List;

public class PageVo<E> implements Serializable {
    private long pageNumber;
    private long pageSize;
    private long pageTotal;
    private long recordTotal;
    private boolean succ = true;
    private List<E> objects;

    public PageVo() {
    }

    public PageVo(long pageNumber, long pageSize, long recordTotal) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.recordTotal = recordTotal;
        this.pageTotal = (long) ((int) Math.ceil((double) recordTotal
                / Double.parseDouble(String.valueOf(pageSize))));
    }

    public long getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageTotal() {
        return this.pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public long getRecordTotal() {
        return this.recordTotal;
    }

    public void setRecordTotal(long recordTotal) {
        this.recordTotal = recordTotal;
    }

    public List<E> getObjects() {
        return this.objects;
    }

    public void setObjects(List<E> objects) {
        this.objects = objects;
    }

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

}
