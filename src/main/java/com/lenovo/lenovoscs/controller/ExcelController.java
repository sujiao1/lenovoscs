package com.lenovo.lenovoscs.controller;

import com.lenovo.lenovoscs.bean.Msg;
import com.lenovo.lenovoscs.bean.PN;
import com.lenovo.lenovoscs.bean.PO;
import com.lenovo.lenovoscs.service.ExcelService;
import com.lenovo.lenovoscs.service.Impl.ExcelPNServiceImpl;
import com.lenovo.lenovoscs.service.Impl.ExcelServiceImpl;
import com.lenovo.lenovoscs.service.PNService;
import com.lenovo.lenovoscs.service.POService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/views")
public class ExcelController {

    @Autowired
    @Resource
    private POService poService;

    @Autowired
    @Resource
    private PNService pnService;

    @Autowired
    @Resource
    private ExcelServiceImpl excelService;

    @Autowired
    @Resource
    private ExcelPNServiceImpl excelPNService;

    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        List<PO> poList = poService.getAllPO();

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("sheet1");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("PO Display");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第17个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 16);
        sheet.addMergedRegion(rowRegion);

		/*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
		sheet.addMergedRegion(columnRegion);*/


        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("PO#");//为第一个单元格设值
        row.createCell(1).setCellValue("Remark");//为第二个单元格设值
        row.createCell(2).setCellValue("Ship To");//为第三个单元格设值
        row.createCell(3).setCellValue("Carrier");//为第4三个单元格设值
        row.createCell(4).setCellValue("Sold To");//为第5个单元格设值
        row.createCell(5).setCellValue("Customer");//为第6个单元格设值
        row.createCell(6).setCellValue("Order Type");//为第7个单元格设值
        row.createCell(7).setCellValue("Exchange Provision Item");//为第8个单元格设值
        row.createCell(8).setCellValue("Condition and Item");//为第9个单元格设值
        row.createCell(9).setCellValue("Po Date");//为第10个单元格设值
        row.createCell(10).setCellValue("Delivery Date");//为第11个单元格设值
        row.createCell(11).setCellValue("Drop OrderTime");//为第12个单元格设值
        row.createCell(12).setCellValue("Target Date");//为第13个单元格设值
        row.createCell(13).setCellValue("createdBy");//为第14个单元格设值
        row.createCell(14).setCellValue("lastModifiedBy");//为第15个单元格设值
        row.createCell(15).setCellValue("PNnumber");//为第16个单元格设值
        row.createCell(16).setCellValue("PN_Quantity");//为第17个单元格设值

        for (int i = 0; i < poList.size(); i++) {
            row = sheet.createRow(i + 2);
            PO po = poList.get(i);
            row.createCell(0).setCellValue(po.getPonumber());
            row.createCell(1).setCellValue(po.getRemark());
            row.createCell(2).setCellValue(po.getShipTo());
            row.createCell(3).setCellValue(po.getCarrier());
            row.createCell(4).setCellValue(po.getSoldTo());
            row.createCell(5).setCellValue(po.getCustomer());
            row.createCell(6).setCellValue(po.getOrderType());
            row.createCell(7).setCellValue(po.getExchangeProvisionItem());
            row.createCell(8).setCellValue(po.getConditionItem());
            if(po.getPoDate()==null) {
                row.createCell(9).setCellValue("");
            }else {
                row.createCell(9).setCellValue(po.getPoDate());
            }

            if(po.getDeliveryDate()==null) {
                row.createCell(10).setCellValue("");
            }else {
                row.createCell(10).setCellValue(po.getDeliveryDate());
            }

            if(po.getDropOrderTime()==null) {
                row.createCell(11).setCellValue("");
            }else {
                row.createCell(11).setCellValue(po.getDropOrderTime());
            }

            if(po.getTargetDate()==null) {
                row.createCell(12).setCellValue("");
            }else {
                row.createCell(12).setCellValue(po.getTargetDate());
            }

            row.createCell(13).setCellValue(po.getCreatedBy());
            row.createCell(14).setCellValue(po.getLastModifiedBy());
            if(po.getPnnumber()==null) {
                row.createCell(15).setCellValue("");
            }else {
                row.createCell(15).setCellValue(po.getPnnumber());
            }
            //row.createCell(15).setCellValue(po.getPnnumber());
            if(po.getPnQuantity()==null) {
                row.createCell(16).setCellValue("");
            }else {
                row.createCell(16).setCellValue(po.getPnQuantity());
            }
            //row.createCell(16).setCellValue(po.getPnQuantity());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 16; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=PO Display.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();


    }

    @RequestMapping("/exportPN")
    @ResponseBody
    public void exportPN(HttpServletResponse response) throws IOException {
        List<PN> pnList = pnService.getAllPN();

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("sheet1");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("PN Display");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第15个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 8);
        sheet.addMergedRegion(rowRegion);

		/*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
		sheet.addMergedRegion(columnRegion);*/

        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("PN #");//为第一个单元格设值
        row.createCell(1).setCellValue("PONumber");//为第二个单元格设值
        row.createCell(2).setCellValue("PN Des");//为第三个单元格设值
        row.createCell(3).setCellValue("Categroy");//为第4个单元格设值
        row.createCell(4).setCellValue("Unit");//为第5三个单元格设值
        row.createCell(5).setCellValue("Price");//为第6个单元格设值
        row.createCell(6).setCellValue("PN Quantity");//为第7个单元格设值
        row.createCell(7).setCellValue("Parts Amount");//为第8个单元格设值
        row.createCell(8).setCellValue("PN Status");//为第9个单元格设值

        //row.createCell(15).setCellValue("lastModifiedBy");//为第15个单元格设值

        for (int i = 0; i < pnList.size(); i++) {
            row = sheet.createRow(i + 2);
            PN pn = pnList.get(i);
            row.createCell(0).setCellValue(pn.getPnnumber());
            if(pn.getPrice() == null){
                row.createCell(1).setCellValue("");
            }else {
                row.createCell(1).setCellValue(pn.getNumber());
            }
            row.createCell(2).setCellValue(pn.getPnDes());
            row.createCell(3).setCellValue(pn.getCategory());
            row.createCell(4).setCellValue(pn.getUnit());
            if(pn.getPrice() == null){
                row.createCell(5).setCellValue("");
            }else {
                row.createCell(5).setCellValue(pn.getPrice().toString());
            }

            if(pn.getPnQuantity()==null){
                row.createCell(6).setCellValue("");
            }else{
                row.createCell(6).setCellValue(pn.getPnQuantity());
            }
            row.createCell(7).setCellValue(pn.getPartsAmount());
            if(pn.getFlag()== null){
                row.createCell(8).setCellValue("");
            }else {
                row.createCell(8).setCellValue(pn.getFlag());
            }
            //row.createCell(8).setCellValue(pn.getConditionItem());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=PN Display.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }

    @RequestMapping("/exportASN/{ASNnumber}")
    @ResponseBody
    public void exportASN(HttpServletResponse response,@PathVariable("ASNnumber") Integer ASNnumber) throws IOException {

        List<PN> pnList = pnService.getPNequal(ASNnumber);

        for  ( int  i  =   0 ; i  <  pnList.size()  -   1 ; i ++ )  {
            for  ( int  j  =  pnList.size()  -   1 ; j  >  i; j -- )  {
                if  (pnList.get(j).getId() == pnList.get(i).getId())  {
                    pnList.remove(j);
                }
            }
        }

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("sheet1");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("PN Display");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第15个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 8);
        sheet.addMergedRegion(rowRegion);

		/*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
		sheet.addMergedRegion(columnRegion);*/

        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("PN #");//为第一个单元格设值
        row.createCell(1).setCellValue("PONumber");//为第二个单元格设值
        row.createCell(2).setCellValue("PN Des");//为第三个单元格设值
        row.createCell(3).setCellValue("Categroy");//为第4个单元格设值
        row.createCell(4).setCellValue("Unit");//为第5三个单元格设值
        row.createCell(5).setCellValue("Price");//为第6个单元格设值
        row.createCell(6).setCellValue("PN Quantity");//为第7个单元格设值
        row.createCell(7).setCellValue("Parts Amount");//为第8个单元格设值
        row.createCell(8).setCellValue("PN Status");//为第9个单元格设值

        //row.createCell(15).setCellValue("lastModifiedBy");//为第15个单元格设值

        for (int i = 0; i < pnList.size(); i++) {
            row = sheet.createRow(i + 2);
            PN pn = pnList.get(i);
            row.createCell(0).setCellValue(pn.getPnnumber());
            if(pn.getPrice() == null){
                row.createCell(1).setCellValue("");
            }else {
                row.createCell(1).setCellValue(pn.getNumber());
            }
            row.createCell(2).setCellValue(pn.getPnDes());
            row.createCell(3).setCellValue(pn.getCategory());
            row.createCell(4).setCellValue(pn.getUnit());
            if(pn.getPrice() == null){
                row.createCell(5).setCellValue("");
            }else {
                row.createCell(5).setCellValue(pn.getPrice().toString());
            }

            if(pn.getPnQuantity()==null){
                row.createCell(6).setCellValue("");
            }else{
                row.createCell(6).setCellValue(pn.getPnQuantity());
            }
            row.createCell(7).setCellValue(pn.getPartsAmount());
            if(pn.getFlag()== null){
                row.createCell(8).setCellValue("");
            }else {
                row.createCell(8).setCellValue(pn.getFlag());
            }
            //row.createCell(8).setCellValue(pn.getConditionItem());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=PN Display-status.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }

    @RequestMapping(value = "/import")
    public String exImport(@RequestParam(value = "filename") MultipartFile file, HttpSession session) {
        Msg msg = new Msg();
        boolean a = false;

        String fileName = file.getOriginalFilename();

        try {
            a = excelService.batchImport(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/views/procument.html";
    }

    @RequestMapping("/ImportPN")
    public String ImportPN(@RequestParam(value = "filename") MultipartFile file, HttpSession session) {
        Msg msg = new Msg();
        boolean a = false;

        String fileName = file.getOriginalFilename();

        try {
            a = excelPNService.batchImport(fileName, file);
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/views/podetail.html";
    }

    /**
     * 下载PO模板文件
     * @param response
     * @throws Exception
     */
    @RequestMapping("/exportTemplate")
    @ResponseBody
    public void exportTemplate(HttpServletResponse response) throws Exception{

        HSSFWorkbook hssfWorkbookwb = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbookwb.createSheet("sheet1");
        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("PO Display");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第15个单元格结束
         */
        CellRangeAddress cellAddresses = new CellRangeAddress(0, 0, 0, 16);
        sheet.addMergedRegion(cellAddresses);

        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("PO#");//为第一个单元格设值
        row.createCell(1).setCellValue("Remark");//为第二个单元格设值
        row.createCell(2).setCellValue("Ship To");//为第三个单元格设值
        row.createCell(3).setCellValue("Carrier");//为第4三个单元格设值
        row.createCell(4).setCellValue("Sold To");//为第5个单元格设值
        row.createCell(5).setCellValue("Customer");//为第6个单元格设值
        row.createCell(6).setCellValue("Order Type");//为第7个单元格设值
        row.createCell(7).setCellValue("Exchange Provision Item");//为第8个单元格设值
        row.createCell(8).setCellValue("Condition and Item");//为第9个单元格设值
        row.createCell(9).setCellValue("Po Date");//为第10个单元格设值
        row.createCell(10).setCellValue("Delivery Date");//为第11个单元格设值
        row.createCell(11).setCellValue("Drop OrderTime");//为第12个单元格设值
        row.createCell(12).setCellValue("Target Date");//为第13个单元格设值
        row.createCell(13).setCellValue("createdBy");//为第14个单元格设值
        row.createCell(14).setCellValue("lastModifiedBy");//为第15个单元格设值
        row.createCell(15).setCellValue("PNnumber");//为第16个单元格设值
        row.createCell(16).setCellValue("PN_Quantity");//为第17个单元格设值

        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 16; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=PO Display.xls");//默认Excel名称
        hssfWorkbookwb.write(os);
        os.flush();
        os.close();
    }

    /**
     * 下载PN模板文件
     * @param response
     * @throws Exception
     */
    @RequestMapping("/exportPNTemplate")
    @ResponseBody
    public void exportPNTemplate(HttpServletResponse response) throws Exception{
        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("sheet1");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("PN Display");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第15个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 8);
        sheet.addMergedRegion(rowRegion);

		/*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
		sheet.addMergedRegion(columnRegion);*/


        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("PN #");//为第一个单元格设值
        row.createCell(1).setCellValue("PONumber");//为第二个单元格设值
        row.createCell(2).setCellValue("PN Des");//为第三个单元格设值
        row.createCell(3).setCellValue("Categroy");//为第4个单元格设值
        row.createCell(4).setCellValue("Unit");//为第5三个单元格设值
        row.createCell(5).setCellValue("Price");//为第6个单元格设值
        row.createCell(6).setCellValue("PN Quantity");//为第7个单元格设值
        row.createCell(7).setCellValue("Parts Amount");//为第8个单元格设值
        row.createCell(8).setCellValue("PN Status");//为第9个单元格设值

        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=PN Display.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }
}
