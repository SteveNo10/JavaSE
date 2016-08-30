package com.ifnoelse.pdf;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.i18n.LocaleContextHolder;
import org.w3c.tidy.Configuration;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PDFHelper {
	
    //表格的设置
    private static final int spacing = 2;
    //表格的设置
    private static final int padding = 2;
    
	/**
	 * 生成PDF文件
	 * @param list 数据集
	 * @return
	 * @throws Exception 
	 */
	public static File GenerateFile(List<Map<String, Object>> list) throws Exception
	{
		if(list.isEmpty()) {
			throw new Exception("数据表为空");
		}
		
		try {
			List<String> titles = new ArrayList<String>();
			Map<String, Object> line = list.get(0);
			int colNum = 0;
			for(Map.Entry<String, Object> entry : line.entrySet()) {
				titles.add(entry.getKey());
				++colNum;
			}
			
			int[] cellsWidth = new int[colNum];
			for(int i=0; i<cellsWidth.length; ++i) {
				cellsWidth[i] = 10;
			}
			
//			Document document = new Document(new Rectangle(1500, 2000), 10, 10, 10, 10);
			Document document = new Document(new Rectangle(800, 2000), 10, 10, 10, 10);
            PdfWriter.getInstance(document, new FileOutputStream("d:\\exporttest.pdf"));
            document.open();
            // 中文字体
            BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font fontChinese = new Font(bfChinese, 12, Font.HELVETICA);
            // 创建有colNum列的表格
            PdfPTable datatable = new PdfPTable(colNum);
            
            datatable.setWidths(cellsWidth);
            datatable.setWidthPercentage(100); // 表格的宽度百分比
            datatable.getDefaultCell().setPadding(padding);
            datatable.getDefaultCell().setBorderWidth(spacing);
            datatable.getDefaultCell().setBackgroundColor(Color.ORANGE);
            datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            // 添加表头元素
            for(String title : titles) {
            	datatable.addCell(new Paragraph(title, fontChinese));
            }
            datatable.setHeaderRows(1); // 表头结束
            datatable.getDefaultCell().setBorderWidth(1);
            
            for(Map<String, Object> row : list) {
            	datatable.getDefaultCell().setGrayFill(0.9f);
            	for(String title : titles) {
            		datatable.addCell(new Paragraph(row.get(title).toString(), fontChinese));
            	}
            	datatable.getDefaultCell().setGrayFill(1.0f);
            }

            document.add(datatable);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
	/**
	 * 生成PDF文件
	 * @param strUrl 网页地址
	 * @return
	 */
	public static File GenerateFile(String urlStr) throws Exception
	{
		String outputFile = "d:/test.pdf";  
        OutputStream os;  
        try {  
            os = new FileOutputStream(outputFile);  
  
            ITextRenderer renderer = new ITextRenderer();  
  
            String str = getHtmlFile(urlStr);  
            renderer.setDocumentFromString(str);  
            ITextFontResolver fontResolver = renderer.getFontResolver();  
              
            fontResolver.addFont("C:/WINDOWS/Fonts/SimSun.ttc",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 宋体字  
//            fontResolver.addFont("C:/WINDOWS/Fonts/Arial.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);// 宋体字  
//            fontResolver.addFont("C:/Windows/Fonts/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            fontResolver.addFont("C:/Windows/Fonts/simkai.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            fontResolver.addFont("C:/Windows/Fonts/MSYH.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            fontResolver.addFont("C:/Windows/Fonts/msyhbd.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            fontResolver.addFont("C:/Windows/Fonts/arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); 
//            fontResolver.addFont("C:/WINDOWS/Fonts/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.layout();  
  
            renderer.createPDF(os);  
  
            System.out.println("转换成功！");  
            os.flush();  
            os.close();  
            return new File(outputFile);  
        } catch (FileNotFoundException e) {  
            // logger.error("不存在文件！" + e.getMessage());  
            throw new BaseException(e);  
        } catch (DocumentException e) {  
            // logger.error("生成pdf时出错了！" + e.getMessage());  
            throw new BaseException(e);  
        } catch (IOException e) {  
            // logger.error("pdf出错了！" + e.getMessage());  
            throw new BaseException(e);  
        }  
	}
	
	// 读取页面内容 add by huangt 2012.6.1  
    private static String getHtmlFile(String urlStr) throws BaseException {  
        URL url;  
        try {  
            if (urlStr.indexOf("?") != -1) {  
                urlStr = urlStr + "&locale="  
                        + LocaleContextHolder.getLocale().toString();  
            } else {  
                urlStr = urlStr + "?locale="  
                        + LocaleContextHolder.getLocale().toString();  
            }  
            url = new URL(urlStr);  
  
            URLConnection uc = url.openConnection();  
            InputStream is = uc.getInputStream();  
              
            Tidy tidy = new Tidy();  
  
            OutputStream os2 = new ByteArrayOutputStream();  
            tidy.setXHTML(true); // 设定输出为xhtml(还可以输出为xml)  
            tidy.setCharEncoding(Configuration.UTF8); // 设定编码以正常转换中文  
            tidy.setTidyMark(false); // 不设置它会在输出的文件中给加条meta信息  
            tidy.setXmlPi(true); // 让它加上<?xml version="1.0"?>  
            tidy.setIndentContent(true); // 缩进，可以省略，只是让格式看起来漂亮一些  
            tidy.parse(is, os2);  
  
            is.close();  
  
            // 解决乱码 --将转换后的输出流重新读取改变编码  
            String temp;  
            StringBuffer sb = new StringBuffer();  
            BufferedReader in = new BufferedReader(new InputStreamReader(  
                    new ByteArrayInputStream(  
                            ((ByteArrayOutputStream) os2).toByteArray()),  
                    "utf-8"));  
            while ((temp = in.readLine()) != null) {  
                sb.append(temp);  
            }  
  
            return sb.toString();  
        } catch (IOException e) {  
            // logger.error("读取客户端网页文本信息时出错了" + e.getMessage());  
            throw new BaseException(e);  
        }  
  
    }  
}
