package com.xh.utils.Service.Impl;

import com.xh.utils.Service.ParseExcelService;
import com.xh.utils.utils.FileUtils;
import com.xh.utils.utils.eumns.FileType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParseExcelServiceImpl implements ParseExcelService {
    private  final String URL="D/:";



    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        if(file.isEmpty()){
            return "文件为空";
        }
        //获取文件名
        String filename = file.getOriginalFilename();
        System.out.println("获取的文件名为："+filename);
        //文件类型第一种方式（后缀）
        String suffixName  = filename.substring(filename.lastIndexOf("."));
        System.out.println("上传的文件名后缀为："+suffixName);
        //文件类型第二种方式（魔法判断）
        //判断后缀，来筛选文件类型
        boolean b = checkFileFormat(file);
        if(!b){
            return "错误的文件";
        }
        System.out.println(file.getContentType());
        //新名称
        filename= UUID.randomUUID()+suffixName;
        System.out.println("上传文件保存名称为："+filename);
        File dest = new File(URL + "//"+filename);
        System.out.println(URL);
        //文件上传后保存的地址
        String path = dest.getPath();
        System.out.println("文件上传保存后的路径：" + path);
        if(!dest.exists()){
            dest.mkdirs();
        }
        //到这里位置，我们得到文件就是Excel文件。
        try{
            file.transferTo(dest);
            return "上传成功";
        }catch (IOException e){
            return "上传失败";
        }
    }

    /**
     * 解析上传的Excel文件
     * @param file
     * @return
     * @throws Exception
     */

    @Override
    public List  parseExcel(MultipartFile file) throws Exception {
        InputStream in = file.getInputStream();
        String filename = file.getOriginalFilename();
        List list = null;
        Workbook work =null;
        list = new ArrayList<>();
        //创建Excel工作薄

        work = this.getWorkbook(in, filename);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        return list;
    }

    @Override
    public File ExchangeOfRanksExcel(MultipartFile file) throws Exception {
        return null;
    }

    /**
     * 给我一个文件 然后 去判断 上传文件 是否为excle
     * @param file
     * @return
     */
    @Override
    public boolean checkFileFormat(MultipartFile file) throws Exception {
        if (file == null) {
            return false;
        }
        try {
            String type = FileUtils.getFileType(file.getInputStream());
//            if(FileType.TXT.getValue().equals(type)){//TXT,DOCX
//                return true;
//            }
            if(FileType.XLS_DOC.getValue().equals(type)){//PPT,DOC,XLS
                return true;
            }
            if(FileType.XLSX_DOCX.getValue().equals(type)){//XLSX
                return true;
            }
//            if(FileType.PDF.getValue().equals(type)){//PDF
//                return true;
//            }
//            if(FileType.PNG.getValue().equals(type)){//PNG
//                return true;
//            }
//            if(FileType.JPEG.getValue().equals(type)){//JPG
//                return true;
//            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public Workbook getWorkbook(InputStream in, String fileName) throws Exception {
        Workbook book = null;
        String filetype = fileName.substring(fileName.lastIndexOf("."));

        if(".xls".equals(filetype)) {
            book = new HSSFWorkbook(in);
        } else if (".xlsx".equals(filetype)) {
            book = new XSSFWorkbook(in);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return book;
    }

}
