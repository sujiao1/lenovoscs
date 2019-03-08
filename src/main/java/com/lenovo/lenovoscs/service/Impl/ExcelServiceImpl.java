package com.lenovo.lenovoscs.service.Impl;

import com.lenovo.lenovoscs.bean.Mapper;
import com.lenovo.lenovoscs.bean.MyException;
import com.lenovo.lenovoscs.bean.PN;
import com.lenovo.lenovoscs.bean.PO;
import com.lenovo.lenovoscs.dao.POMapper;
import com.lenovo.lenovoscs.service.ExcelService;
import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.StringUtils;
import javafx.scene.control.DateCell;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.StringUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.swing.MenuItemLayoutHelper;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.awt.SystemColor.info;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private POMapper poMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {

        boolean notNull = false;
        String dbtime2 = "1900-01-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = format.parse(dbtime2);
        ArrayList<PO> poList = new ArrayList<>();
        ArrayList<PN> pnArrayList = new ArrayList<>();
        ArrayList<Mapper> mappers = new ArrayList<>();
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
        PO po;
        PN pn;
        Mapper mapper;
        for (int r = 2; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            System.out.println("row="+sheet.getLastRowNum());
            ArrayList<String> listRow = new ArrayList<>();
            if (row == null) {
                continue;
            }/*else if(row.getCell(0)==null||
                        StringUtils.isNullOrEmpty((row.getCell(0).getStringCellValue()))){
                    continue;
                }*/
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

            po = new PO();
            pn = new PN();
            mapper = new Mapper();

                /*if( row.getCell(0).getCellType() !=1){//循环时，得到每一行的单元格进行判断
                    throw new MyException("导入失败(第"+(r+1)+"行,用户名请设为文本格式)");
                }*/
            //获取单元格
            Cell cell = row.getCell(0);
            //设置单元格类型
            cell.setCellType(CellType.STRING);
            String ponumber = row.getCell(0).getStringCellValue();//得到每一行第一个单元格的值
            System.out.println("2222" + ponumber);
            if (ponumber == null || ponumber.isEmpty()) {//判断是否为空
                throw new MyException("导入失败(第" + (r + 1) + "行,ponumber未填写)");
            }

            /**
             * remark
             * */
            String remark = "";
            if(row.getCell(1) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(1).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell remarkcell = row.getCell(1);
                //设置单元格类型
                remarkcell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                remark = row.getCell(1).getStringCellValue();
            }

            System.out.print("remark="+remark);

            /**
             *ship TO
             */
            String shipTo = "";
            if(row.getCell(2) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(2).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell shipToCell = row.getCell(2);
                //设置单元格类型
                shipToCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                shipTo = row.getCell(2).getStringCellValue();
            }

            System.out.print("shipTo="+shipTo);


            String carrier = "";
            if(row.getCell(3) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(3).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell carrierCell = row.getCell(3);
                //设置单元格类型
                carrierCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                carrier = row.getCell(3).getStringCellValue();
            }
            System.out.print("carrier="+carrier);



            String soldTo = "";
            if(row.getCell(4) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(4).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell soldToCell = row.getCell(4);
                //设置单元格类型
                soldToCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                soldTo = row.getCell(4).getStringCellValue();
            }
            System.out.print("soldTo="+soldTo);


            String customer = "";
            if(row.getCell(5) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(5).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell customerCell = row.getCell(5);
                //设置单元格类型
                customerCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                customer = row.getCell(5).getStringCellValue();
            }
            System.out.print("customer="+customer);


            String orderType = "";
            if(row.getCell(6) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(6).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell orderTypeCell = row.getCell(6);
                //设置单元格类型
                orderTypeCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                orderType = row.getCell(6).getStringCellValue();
            }
            System.out.print("orderType="+orderType);


            String exchangeProvisionItem = "";
            if(row.getCell(7) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(7).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell exchangeProvisionItemCell = row.getCell(7);
                //设置单元格类型
                exchangeProvisionItemCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                exchangeProvisionItem = row.getCell(7).getStringCellValue();
            }
            System.out.print("exchangeProvisionItem="+exchangeProvisionItem);


            String conditionItem = "";
            if(row.getCell(8) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(8).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell conditionItemCell = row.getCell(8);
                //设置单元格类型
                conditionItemCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                conditionItem = row.getCell(8).getStringCellValue();
            }
            System.out.print("conditionItem="+conditionItem);

            Date poDate = null;
            if(row.getCell(9) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(9).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。

                Cell poDateCell = row.getCell(9);
                //设置单元格类型
                /*//row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());

                poDate = getCellValue(poDateCell.);*/
                if (poDateCell.getCellTypeEnum() != CellType.STRING && HSSFDateUtil.isCellDateFormatted(poDateCell))
                {
                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date poDate1 = HSSFDateUtil.getJavaDate(poDateCell.getNumericCellValue());
                    poDate = DateUtils.addDays(poDate1, (int)((poDate1.getTime()-date2.getTime())/(1000*3600*24)));

                    // poDate = sdf.format(date);
                }
                //Date podata2 = df.parse(poDate1);
                //poDate = new SimpleDateFormat("yyyy-MM--dd").format(podata2);
                System.out.print("poDate="+poDate);
            }


            Date deliveryDate =null;
            if(row.getCell(10) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(10).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell deliveryDateCell = row.getCell(10);
                if (deliveryDateCell.getCellTypeEnum() != CellType.STRING && HSSFDateUtil.isCellDateFormatted(deliveryDateCell))
                {
                    Date deliveryDate1 = HSSFDateUtil.getJavaDate(deliveryDateCell.getNumericCellValue());
                    deliveryDate = DateUtils.addDays(deliveryDate1, (int)((deliveryDate1.getTime()-date2.getTime())/(1000*3600*24)));

                    // poDate = sdf.format(date);
                }
            }
            System.out.print("deliveryDate="+deliveryDate);

            Date dropOrderTime=null ;
            if(row.getCell(11) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(11).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell dropOrderTimeCell = row.getCell(11);
                if (dropOrderTimeCell.getCellTypeEnum() != CellType.STRING && HSSFDateUtil.isCellDateFormatted(dropOrderTimeCell))
                {
                    Date dropOrderTime1 = HSSFDateUtil.getJavaDate(dropOrderTimeCell.getNumericCellValue());
                    int b = (int)((dropOrderTime1.getTime()-date2.getTime())/(1000*3600*24));
                    dropOrderTime = DateUtils.addDays(dropOrderTime1,b );
                    // poDate = sdf.format(date);
                }
            }
            System.out.print("dropOrderTime="+dropOrderTime);

            Date targetDate = null ;
            if(row.getCell(12) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(12).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell targetDateCell = row.getCell(12);
                if (targetDateCell.getCellTypeEnum() != CellType.STRING && HSSFDateUtil.isCellDateFormatted(targetDateCell))
                {
                    Date targetDate1 = HSSFDateUtil.getJavaDate(targetDateCell.getNumericCellValue());
                    int a = (int)((targetDate1.getTime()-date2.getTime())/(1000*3600*24));
                    targetDate = DateUtils.addDays(targetDate1, a);
                    // poDate = sdf.format(date);
                }
            }
            System.out.print("targetDate="+targetDate);


            String createdBy = "";
            if(row.getCell(13) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(13).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell createdByCell = row.getCell(13);
                //设置单元格类型
                createdByCell.setCellType(CellType.STRING);
                //row.getCell(j).setCellValue(new HSSFRichTextString(String.valueOf(listRow.get(j))));
                //row.getCell(1).setCellValue(row.getCell(1).getStringCellValue());
                createdBy = row.getCell(13).getStringCellValue();
            }
            System.out.print("createdBy="+createdBy);


            String lastModifiedBy = "";
            if(row.getCell(14) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(14).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell lastModifiedByCell = row.getCell(14);
                //设置单元格类型
                lastModifiedByCell.setCellType(CellType.STRING);
                lastModifiedBy = row.getCell(14).getStringCellValue();
            }
            System.out.print("lastModifiedBy="+lastModifiedBy);

            String pnnumber = "";
            if(row.getCell(15) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(15).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell pnnumberCell = row.getCell(15);
                //设置单元格类型
                pnnumberCell.setCellType(CellType.STRING);
                pnnumber = row.getCell(15).getStringCellValue();
            }
            System.out.print("pnnumber="+pnnumber);

            String pnQuantity = "";
            if(row.getCell(16) == null){//单元格没有值(等于null)时，getCell方法获取不到单元格,要用createCell方法。
                row.createCell(16).setCellValue("");
            }else {//单元格有值时，getCell方法获获取到单元格。
                Cell pnQuantityCell = row.getCell(16);
                //设置单元格类型
                pnQuantityCell.setCellType(CellType.STRING);
                pnQuantity = row.getCell(16).getStringCellValue();
            }
            System.out.print("pnQuantity="+pnQuantity);

            //完整的循环一次 就组成了一个对象
            po.setPonumber(Integer.parseInt(row.getCell(0).getStringCellValue()));
            po.setRemark(remark);
            po.setShipTo(shipTo);
            po.setCarrier(carrier);
            po.setSoldTo(soldTo);
            po.setCustomer(customer);
            po.setOrderType(orderType);
            po.setExchangeProvisionItem(exchangeProvisionItem);
            po.setConditionItem(conditionItem);
            po.setPoDate(poDate);
            po.setDeliveryDate(deliveryDate);
            po.setDropOrderTime(dropOrderTime);
            po.setTargetDate(targetDate);
            po.setCreatedBy(carrier);
            po.setLastModifiedBy(lastModifiedBy);
            po.setPnnumber(Integer.parseInt(pnnumber));
            po.setPnQuantity(Integer.parseInt(pnQuantity));
            pn.setPnnumber(Integer.parseInt(pnnumber));
            pn.setPnQuantity(Integer.parseInt(pnQuantity));
            mapper.setPnnumber(Integer.parseInt(pnnumber));
            mapper.setPonumber(Integer.parseInt(row.getCell(0).getStringCellValue()));
            //po.setFlag(1);
            poList.add(po);
            pnArrayList.add(pn);
            mappers.add(mapper);
        }
        for (PO poResord : poList) {
            Integer ponumber = poResord.getPonumber();
            PO po1 = poMapper.selectPOByponumber(ponumber);
            if (po1 == null) {
                poMapper.insert(poResord);
                System.out.println(" 插入 " + poResord);
            } else {
                poMapper.updatePOByponumber(poResord);
                System.out.println(" 更新 " + poResord);
            }
        }
        return notNull;
    }


    /**
     * 对Excel的各个单元格的格式进行判断并转换
     */
    public String getCellValue(HSSFCell cell) {
        String cellValue = "";
        DecimalFormat df = new DecimalFormat("#");
        switch (cell.getCellType()) {
            case NUMERIC:
                cellValue = cell.getRichStringCellValue().getString().trim();
                break;
            case STRING:
                cellValue = df.format(cell.getNumericCellValue()).toString();
                break;
            case BLANK:
                cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            case FORMULA:
                cellValue = cell.getCellFormula();
                break;
            default:
                cellValue = "";
        }
        return cellValue;
    }

}

