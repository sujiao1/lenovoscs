package com.lenovo.lenovoscs.service.Impl;

import com.lenovo.lenovoscs.bean.MyException;
import com.lenovo.lenovoscs.bean.PN;
import com.lenovo.lenovoscs.bean.PO;
import com.lenovo.lenovoscs.dao.PNMapper;
import com.lenovo.lenovoscs.service.ExcelService;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ExcelPNServiceImpl implements ExcelService {

    @Autowired
    private PNMapper pnMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {

        boolean notNull = false;
        String dbtime2 = "1900-01-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date2 = format.parse(dbtime2);
        ArrayList<PN> pnList = new ArrayList<>();

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }

        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }

        PN pn;
        for (int r = 2; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            System.out.println("row="+sheet.getLastRowNum());
            ArrayList<String> listRow = new ArrayList<>();
            if (row == null) {
                continue;
            }

            //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("columnCount"+columnCount);
            for(int j=1;j<=columnCount;j++){
                if(row.getCell(j) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                    row.createCell(j).setCellValue("");
                }else {//单元格有值时，getCell方法获获取到单元格。
                    Cell cell = row.getCell(j);
                    //设置单元格类型
                    cell.setCellType(CellType.STRING);
                    //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                    row.getCell(j).setCellValue(row.getCell(j).getStringCellValue());
                }
            }

            for(int i=1;i<=columnCount;i++){
                String value = row.getCell(i).getStringCellValue();
                System.out.print("value="+value);
            }

            pn = new PN();

            //获取单元格
            Cell cell = row.getCell(0);
            //设置单元格类型
            cell.setCellType(CellType.STRING);
            String pnnumber = row.getCell(0).getStringCellValue();//得到每一行第一个单元格的值
            System.out.println("2222" + pnnumber);
            if (pnnumber == null || pnnumber.isEmpty()) {//判断是否为空
                throw new MyException("导入失败(第" + (r + 1) + "行,pnnumber未填写)");
            }

            //获取单元格
            Cell ponumbercell = row.getCell(1);
            //设置单元格类型
            ponumbercell.setCellType(CellType.STRING);
            String ponumber = row.getCell(1).getStringCellValue();//得到每一行第一个单元格的值
            System.out.println("2222" + ponumber);
            if (ponumber == null || ponumber.isEmpty()) {//判断是否为空
                throw new MyException("导入失败(第" + (r + 1) + "行,ponumber未填写)");
            }

            /**
             * pnDes
             * */
            String pnDes = "";
            if(row.getCell(2) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(2).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell pnDescell = row.getCell(1);
                //设置单元格类型
                pnDescell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                pnDes = row.getCell(2).getStringCellValue();
            }

            System.out.print("pnDes="+pnDes);

            /**
             *ship TO
             */
            String category = "";
            if(row.getCell(3) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(3).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell categoryCell = row.getCell(2);
                //设置单元格类型
                categoryCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                category = row.getCell(3).getStringCellValue();
            }

            System.out.print("category="+category);


            String unit = "";
            if(row.getCell(4) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(4).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell unitCell = row.getCell(4);
                //设置单元格类型
                unitCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                unit = row.getCell(4).getStringCellValue();
            }
            System.out.print("carrier="+unit);



            BigDecimal price = null;
            if(row.getCell(5) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(5).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell priceCell = row.getCell(5);
                //设置单元格类型
                //priceCell.setCellType(CellType.NUMERIC);
                /*String price1 = String.valueOf(priceCell.getStringCellValue());
                price = new BigDecimal(price1.trim());*/
                String value = priceCell.getStringCellValue();
                //解决1234.0  去掉后面的.0
                if(null!=value&&!"".equals(value.trim())){
                    String[] item = value.split("[.]");
                    if(1<item.length&&"0".equals(item[1])){
                        value=item[0];
                        price = new BigDecimal(value);
                    }
                }

            }
            System.out.print("price="+price);


            Integer pnQuantity = null;
            if(row.getCell(6) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(6).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell pnQuantityCell = row.getCell(6);
                //设置单元格类型
                /*String pnQuantity1 = row.getCell(5).getStringCellValue();
                pnQuantity = Integer.parseInt(pnQuantity1.trim());*/
                String value = pnQuantityCell.getStringCellValue();
                //解决1234.0  去掉后面的.0
                if(null!=value&&!"".equals(value.trim())){
                    String[] item = value.split("[.]");
                    if(1<item.length&&"0".equals(item[1])){
                        value=item[0];
                        pnQuantity = Integer.parseInt(value);
                    }
                }
            }
            System.out.print("customer="+pnQuantity);


            String partsAmount = "";
            if(row.getCell(7) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(7).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell partsAmountCell = row.getCell(7);
                //设置单元格类型
                partsAmountCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                partsAmount = row.getCell(7).getStringCellValue();
            }
            System.out.print("orderType="+partsAmount);


            /*Integer flag = null;
            if(row.getCell(8) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(8).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell flagCell = row.getCell(8);
                //设置单元格类型
                String value = flagCell.getStringCellValue();
                //解决1234.0  去掉后面的.0
                if(null!=value&&!"".equals(value.trim())){
                    String[] item = value.split("[.]");
                    if(1<item.length&&"0".equals(item[1])){
                        value=item[0];
                        flag = Integer.parseInt(value);
                    }
                }
            }
            System.out.print("flag="+flag);*/

            //完整的循环一次 就组成了一个对象
            pn.setPnnumber(Integer.parseInt(pnnumber));
            pn.setNumber(Integer.parseInt(ponumber));
            pn.setPnDes(pnDes);
            pn.setCategory(category);
            pn.setUnit(unit);
            pn.setPrice(price);
            pn.setPnQuantity(pnQuantity);
            pn.setPartsAmount(partsAmount);
            pn.setFlag(1);
            pnList.add(pn);
        }
        for (PN pnResord : pnList) {
            Integer pnnumber = pnResord.getPnnumber();
            PN pn1 = pnMapper.selectPNBypnnumber(pnnumber);
            if (pn1 == null) {
                pnMapper.insert(pnResord);
                System.out.println(" 插入 " + pnResord);
            } else {
                pnMapper.updataPNBypnnumber(pnResord);
                System.out.println(" 更新 " + pnResord);
            }
        }
        return notNull;
    }
}
