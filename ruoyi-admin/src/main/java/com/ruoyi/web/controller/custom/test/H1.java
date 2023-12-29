package com.ruoyi.web.controller.custom.test;

/**
 * 功能描述
 *
 * @author: sunlei
 * @date: 2023年12月25日 10:10
 */
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class H1 {
    public static void main(String[] args) {
        try {
            // 加载PDF文件
            PDDocument document = PDDocument.load(new File("f://111.pdf"));

            // 获取第一页
            PDPage page = document.getPage(0);

            // 渲染PDF页面为图像
            PDFRenderer renderer = new PDFRenderer(document);
            BufferedImage image = renderer.renderImageWithDPI(0, 300); // 设置dpi为300

            // 目标颜色（灰色）的RGB值
            int targetRed = 159;
            int targetGreen = 153;
            int targetBlue = 153;

            // 初始化最小和最大坐标值
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;

            // 遍历图像的每个像素
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    // 获取像素的RGB值
                    int rgb = image.getRGB(x, y);
                    Color color = new Color(rgb);

                    // 判断像素的颜色是否与目标颜色匹配
                    if (color.getRed() == targetRed && color.getGreen() == targetGreen && color.getBlue() == targetBlue) {
                        // 更新最小和最大坐标值
                        minX = Math.min(minX, x);
                        minY = Math.min(minY, y);
                        maxX = Math.max(maxX, x);
                        maxY = Math.max(maxY, y);
                    }
                }
            }

            // 计算区域的宽度、高度和中心坐标
            int width = maxX - minX + 1;
            int height = maxY - minY + 1;
            int centerX = (minX + maxX) / 2;
            int centerY = (minY + maxY) / 2;

            // 输出结果
            System.out.println("宽度: " + width);
            System.out.println("高度: " + height);
            System.out.println("中心坐标: (" + centerX + ", " + centerY + ")");

            // 关闭PDF文档
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}