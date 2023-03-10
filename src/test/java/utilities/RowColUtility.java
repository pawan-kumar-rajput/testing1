package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowColUtility {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static int getRowCount(String xlfile,String xlsheet) throws Exception{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		int rowCount=ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws Exception{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum)throws Exception {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			//data=cell.toString;
			DataFormatter formatter=new DataFormatter();
			data=formatter.formatCellValue(cell);
			return data;
		}
		catch(Exception e) {
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data)throws Exception {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlfile);
		wb.close();
		fis.close();
		fos.close();
	}
}
