package com.example.undertakes.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 导出Excel工具类
 *
 * @author liuxinxin
 * @email 
 * @date 2018/11/7 16:40  
 * @param 
 * @return 
 */
public class ExcelUtil {

    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(int count, String sheetName, String []headers, String title, List<List<String>> result, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet();
        wb.setSheetName(count,sheetName);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth((short) 20);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        int index=0;
        HSSFRow row = sheet.createRow(index);
        index++;
        //表头样式
        HSSFCellStyle titleStyle = titleStyle(wb, (short) 13);
        //判断是否添加表头
        if (title!=null){
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length-1));
            row.createCell(0).setCellValue(title);
            row.setHeight((short) 400);
            for (Cell cell : row) {
                cell.setCellStyle(titleStyle);
            }
            row = sheet.createRow(index);
            index++;
        }
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<headers.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(titleStyle);
        }
        HSSFCellStyle hssfCellStyle = addBordStyle(wb, (short) 11);
        //创建内容
        for (List<String> m : result) {
            row = sheet.createRow(index);
            row.setHeight((short)400);
            int cellIndex = 0;
            for (String str : m) {
                cell = row.createCell((short) cellIndex);
                cell.setCellStyle(hssfCellStyle);
                cell.setCellValue(str);
                cellIndex++;
            }
            index++;
        }
        return wb;
    }

    public static String getCellValue(Cell cell){
        String value = null;
        switch (cell.getCellTypeEnum()) {
            case NUMERIC: // 数字
                //如果为时间格式的内容
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    value=sdf.format(HSSFDateUtil.getJavaDate(cell.
                            getNumericCellValue())).toString();
                    break;
                } else {
                    value = new DecimalFormat().format(cell.getNumericCellValue());
                }
                break;
            case STRING: // 字符串
                value = cell.getStringCellValue();
                break;
            case BOOLEAN: // Boolean
                value = cell.getBooleanCellValue() + "";
                break;
            case FORMULA: // 公式
                value = cell.getCellFormula() + "";
                break;
            case BLANK: // 空值
                value = "";
                break;
            case ERROR: // 故障
                value = "非法字符";
                break;
            default:
                value = "未知类型";
                break;
        }
        return value;

    }

    /**
     * @Author liuxinxin
     * @Description
     * @Date 2018/11/3 10:15
     * @Param workbook、fontSize（字体大小）
     * @Return
     */
    public static HSSFCellStyle titleStyle(HSSFWorkbook workbook,short fontSize){
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints(fontSize);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);
        return style;
    }


    /**
     * @Author liuxinxin
     * @Description 添加边框并垂直居中、自动换行
     * @Date 2018/11/3 10:16
     * @Param workbook、fontSize（字体大小）
     * @Return
     */
    public static HSSFCellStyle addBordStyle(HSSFWorkbook workbook,short fontSize){
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        hssfCellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        hssfCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        hssfCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        hssfCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        hssfCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        hssfCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        hssfCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        hssfCellStyle.setWrapText(true);
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints(fontSize);
        hssfCellStyle.setFont(font);
        return hssfCellStyle;
    }
}