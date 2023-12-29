package com.ruoyi.common.po;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @author: sunlei
 * @date: 2023年12月25日 14:05
 */
public class PdfInfo implements Serializable {

    private int page;


    private int width;
    private int height;
    private int xcenter;

    private int ycenter;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getXcenter() {
        return xcenter;
    }

    public void setXcenter(int xcenter) {
        this.xcenter = xcenter;
    }

    public int getYcenter() {
        return ycenter;
    }

    public void setYcenter(int ycenter) {
        this.ycenter = ycenter;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
