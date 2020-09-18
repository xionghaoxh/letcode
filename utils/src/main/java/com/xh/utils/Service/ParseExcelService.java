package com.xh.utils.Service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public interface ParseExcelService {
    /**
     * 上传文件
     * @param file
     * @return
     * @throws Exception
     */
    public String uploadFile(MultipartFile file)throws Exception;
    /**
     * 解析Excel文件
     * @param file
     * @return
     * @throws IOException
     */
    public List parseExcel (MultipartFile file) throws Exception;

    /**
     * Excel  行列值互换
     * @param file
     * @return
     * @throws Exception
     */
    public File ExchangeOfRanksExcel(MultipartFile file)throws Exception;
    /**
     * 检查文件类型
     * @param file
     * @return
     * @throws Exception
     */
    public  boolean checkFileFormat(MultipartFile file)throws Exception;

    /**
     * 生成工作簿
     * @param in
     * @param filename
     * @return
     * @throws Exception
     */
    Workbook getWorkbook(InputStream in, String filename) throws Exception;
}
