package com.liying.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liying.util.annotation.MapperCell;


public final class FastExcel implements Closeable {

    private static final Logger     LOG    = LoggerFactory.getLogger(FastExcel.class);
    /**
     * 时日类型的数据默认格式化方式
     */
    private              DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private       int      startRow;
    private       String   sheetName;
    private final String   excelFilePath;
    private final Workbook workbook;
    private final File     excelFile;

    /**
     * 构造方法，传入需要操作的excel文件路径
     *
     * @param excelFilePath 需要操作的excel文件的路径
     * @throws IOException            IO流异常
     * @throws InvalidFormatException 非法的格式异常
     */
    public FastExcel(String excelFilePath) throws IOException, InvalidFormatException {
        this.startRow = 0;
        this.sheetName = "Sheet1";
        this.excelFilePath = excelFilePath;
        this.excelFile = new File(this.excelFilePath);
        this.workbook = WorkbookFactory.create(this.excelFile);
    }

    
    public FastExcel(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        this.startRow = 0;
        this.excelFilePath = excelFilePath;
        this.excelFile = new File(this.excelFilePath);
        this.workbook =  new SXSSFWorkbook();
    }
    /**
     * 开始读取的行数，这里指的是标题内容行的行数，不是数据开始的那行
     *
     * @param startRow 开始行数
     */
    public void setStartRow(int startRow) {
        if (startRow < 1) {
            throw new RuntimeException("最小为1");
        }
        this.startRow = --startRow;
    }

    /**
     * 设置需要读取的sheet名字，不设置默认的名字是Sheet1，也就是excel默认给的名字，所以如果文件没有自已修改，这个方法也就不用调了
     *
     * @param sheetName 需要读取的Sheet名字
     */
    public void setSheetName(String sheetName) {
        Sheet sheet = this.workbook.getSheet(sheetName);
        if (null == sheet) {
            //throw new RuntimeException("sheetName:" + sheetName + " is not exist");
        }
        this.sheetName = sheetName;
    }

    /**
     * 设置时间数据格式
     *
     * @param format 格式
     */
    public void setFormat(String format) {
        this.format = new SimpleDateFormat(format);
    }

    /**
     * 解析读取excel文件
     *
     * @param clazz 对应的映射类型
     * @param <T>   泛型
     * @return 读取结果
     */
    public <T> List<T> parse(Class<T> clazz) {
        List<T> resultList = null;
        try {
            Sheet sheet = workbook.getSheet(this.sheetName);
            if (null != sheet) {
                resultList = new ArrayList<T>(sheet.getLastRowNum() - 1);
                Row row = sheet.getRow(this.startRow);

                Map<String, Field> fieldMap = new HashMap<String, Field>();
                Map<String, String> titalMap = new HashMap<String, String>();

                Field[] fields = clazz.getDeclaredFields();
                //这里开始处理映射类型里的注解
                for (Field field : fields) {
                    if (field.isAnnotationPresent(MapperCell.class)) {
                        MapperCell mapperCell = field.getAnnotation(MapperCell.class);
                        fieldMap.put(mapperCell.cellName(), field);
                    }
                }

                for (Cell tital : row) {
                    CellReference cellRef = new CellReference(tital);
                    titalMap.put(cellRef.getCellRefParts()[2], tital.getRichStringCellValue().getString());
                }

                for (int i = this.startRow + 1; i <= sheet.getLastRowNum(); i++) {
                    T t = clazz.newInstance();
                    Row dataRow = sheet.getRow(i);
                    for (Cell data : dataRow) {
                        CellReference cellRef = new CellReference(data);
                        String cellTag = cellRef.getCellRefParts()[2];
                        String name = titalMap.get(cellTag);
                        Field field = fieldMap.get(name);
                        if (null != field) {
                            field.setAccessible(true);
                            getCellValue(data, t, field);
                        }
                    }
                    resultList.add(t);
                }
            }
        } catch (InstantiationException e) {
            LOG.error("初始化异常", e);
        } catch (IllegalAccessException e) {
            LOG.error("初始化异常", e);
        } catch (ParseException e) {
            LOG.debug("时间格式化异常:{}", e);
        }
        return resultList;
    }


    private void getCellValue(Cell cell, Object o, Field field) throws IllegalAccessException, ParseException {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                field.setBoolean(o, cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                field.setByte(o, cell.getErrorCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                field.set(o, cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    if (field.getType().getName().equals(Date.class.getName())) {
                        field.set(o, cell.getDateCellValue());
                    } else {
                        field.set(o, format.format(cell.getDateCellValue()));
                    }
                } else {
                    if (field.getType().isAssignableFrom(Integer.class) || field.getType().getName().equals("int")) {
                        field.setInt(o, (int) cell.getNumericCellValue());
                    } else if (field.getType().isAssignableFrom(Short.class) || field.getType().getName().equals("short")) {
                        field.setShort(o, (short) cell.getNumericCellValue());
                    } else if (field.getType().isAssignableFrom(Float.class) || field.getType().getName().equals("float")) {
                        field.setFloat(o, (float) cell.getNumericCellValue());
                    } else if (field.getType().isAssignableFrom(Byte.class) || field.getType().getName().equals("byte")) {
                        field.setByte(o, (byte) cell.getNumericCellValue());
                    } else if (field.getType().isAssignableFrom(Double.class) || field.getType().getName().equals("double")) {
                        field.setDouble(o, cell.getNumericCellValue());
                    } else if (field.getType().isAssignableFrom(String.class)) {
                        String s = String.valueOf(cell.getNumericCellValue());
                        if (s.contains("E")) {
                            s = s.trim();
                            BigDecimal bigDecimal = new BigDecimal(s);
                            s = bigDecimal.toPlainString();
                        }
                        field.set(o, s);
                    } else {
                        field.set(o, cell.getNumericCellValue());
                    }
                }
                break;
            case Cell.CELL_TYPE_STRING:
                if (field.getType().getName().equals(Date.class.getName())) {
                    field.set(o, format.parse(cell.getRichStringCellValue().getString()));
                } else {
                    field.set(o, cell.getRichStringCellValue().getString());
                }
                break;
            default:
                field.set(o, cell.getStringCellValue());
                break;
        }
    }

    /**
     * 将数据写入excel文件
     *
     * @param list 数据列表
     * @param <T>  泛型
     * @return 写入结果
     */
    public <T> boolean createExcel(List<T> list) {
        boolean result = false;
        FileOutputStream fileOutputStream = null;
        if (null != list && !list.isEmpty()) {
            T test = list.get(0);
            Map<String, Field> fieldMap = new HashMap<String, Field>();
            Map<Integer, String> titalMap = new HashMap<Integer, String>();
            Field[] fields = test.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MapperCell.class)) {
                    MapperCell mapperCell = field.getAnnotation(MapperCell.class);
                    fieldMap.put(mapperCell.cellName(), field);
                    titalMap.put(mapperCell.order(), mapperCell.cellName());
                }
            }
            try {
                Sheet sheet = workbook.createSheet(this.sheetName);
                Collection<String> values = titalMap.values();
                String[] s = new String[values.size()];
                values.toArray(s);

                for (int i = 0, length = list.size(); i < length; i++) {
                    Row row = sheet.createRow(i);
                    for (int j = 0; j < s.length; j++) {
                        if (i == 0) {
                            Cell cell = row.createCell(j);
                            cell.setCellValue(s[j]);
                        } else {
                            Cell cell = row.createCell(j);
                            for (Map.Entry<String, Field> data : fieldMap.entrySet()) {
                                if (data.getKey().equals(s[j])) {
                                    Field field = data.getValue();
                                    field.setAccessible(true);
                                    cell.setCellValue(field.get(list.get(i)).toString());
                                    break;
                                }
                            }
                        }

                    }
                }
                File file = new File(this.excelFilePath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(this.excelFilePath);
                workbook.write(fileOutputStream);
            } catch (IOException e) {
                LOG.error("流异常", e);
            } catch (IllegalAccessException e) {
                LOG.error("反射异常", e);
            } finally {
                if (null != fileOutputStream) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        LOG.error("关闭流异常", e);
                    }
                }
            }
            result = true;
        }
        return result;
    }

    /**
     * 获取指定单元格的值
     *
     * @param rowNumber  行数，从1开始
     * @param cellNumber 列数，从1开始
     * @return 该单元格的值
     */
    public String getCellValue(int rowNumber, int cellNumber) {
        String result;
        checkRowAndCell(rowNumber, cellNumber);
        Sheet sheet = this.workbook.getSheet(this.sheetName);
        Row row = sheet.getRow(--rowNumber);
        Cell cell = row.getCell(--cellNumber);
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                result = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                result = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_ERROR:
                result = String.valueOf(cell.getErrorCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                result = cell.getCellFormula();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = format.format(cell.getDateCellValue());
                } else {
                    result = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            default:
                result = cell.getStringCellValue();
                break;
        }
        return result;
    }

    public void close() throws IOException {
        this.workbook.close();
    }

    private void checkRowAndCell(int rowNumber, int cellNumber) {
        if (rowNumber < 1) {
            throw new RuntimeException("rowNumber less than 1");
        }
        if (cellNumber < 1) {
            throw new RuntimeException("cellNumber less than 1");
        }
    }
}

