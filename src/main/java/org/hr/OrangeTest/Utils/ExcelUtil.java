package org.hr.OrangeTest.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hr.OrangeTest.DTO.AssignLvDTO;
import org.hr.OrangeTest.DTO.LoginDTO;

public class ExcelUtil {

	private static FileInputStream inputStream = null;
	private static Workbook wrkbk = null;

	private static Sheet getSheet(int sheetNo) throws IOException {
		// to take data from local drive
		// File file=new File("E:\\Selenium\\_eclispe_worspace\\OrangeTest\\data.xlsx");

		// to take data from project space
		File f = new File("src/main/java");
		File fs = new File(f, "data_orangetest.xlsx");
		inputStream = new FileInputStream(new File(fs.getAbsolutePath()));
		wrkbk = new XSSFWorkbook(inputStream);
		Sheet sheet = wrkbk.getSheetAt(sheetNo);
		return sheet;

	}

	// LoginTest
	public static List<LoginDTO> getLoginData() throws IOException {
		List<LoginDTO> lgndt = new ArrayList<LoginDTO>();
		DataFormatter formatter = new DataFormatter();
		Iterator<Row> rowiterator = ExcelUtil.getSheet(0).iterator();
		Row nxtrw = rowiterator.next();  //skip first row
		while (rowiterator.hasNext()) {
			nxtrw = rowiterator.next();  //reading from second row
			Iterator<Cell> celliterator = nxtrw.cellIterator();

			LoginDTO logindt = new LoginDTO();
			byte cellcounter = 0;
			while (celliterator.hasNext()) {
				Cell cell = celliterator.next();

				switch (cellcounter) {
				case 0: /* A1 */
					logindt.setUsername(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 1: /* B1 */
					logindt.setPassword(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 2: /* A2 */
					logindt.setPassword(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 3: /* B2 */
					logindt.setPassword(formatter.formatCellValue(cell));
					break;
				}
			}
			lgndt.add(logindt);
		}
		return lgndt;
	}

	// AssignLeaveTest
	public static List<AssignLvDTO> getAssignLvData() throws IOException {
		List<AssignLvDTO> AsgnLvData = new ArrayList<AssignLvDTO>();
		DataFormatter formatter = new DataFormatter();
		Iterator<Row> rowiterator = ExcelUtil.getSheet(1).iterator();
		while (rowiterator.hasNext()) {
			Row nxtrw = rowiterator.next();

			if (nxtrw.getRowNum() == 0) {
				continue; // skip header
			}

			Iterator<Cell> celliterator = nxtrw.cellIterator();
			AssignLvDTO asnlvdto = new AssignLvDTO();
			byte cellcounter = 0;
			while (celliterator.hasNext()) {
				Cell cell = celliterator.next();
				switch (cellcounter) {
				case 0:
					/* A1 */ asnlvdto.setEmpNm(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 1:
					/* B1 */ asnlvdto.setLvTyp(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 2:
					/* C1 */ asnlvdto.setFromMnt(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 3:
					/* D1 */ asnlvdto.setFromYr(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 4:
					/* E1 */ asnlvdto.setFromDay(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 5:
					/* F1 */ asnlvdto.setToMnt(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 6:
					/* G1 */ asnlvdto.setToYr(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 7:
					/* H1 */ asnlvdto.setToDay(formatter.formatCellValue(cell));
					cellcounter++;
					break;
				case 8:
					/* I1 */ asnlvdto.setCmnt(formatter.formatCellValue(cell));
					break;
				}
			}
			AsgnLvData.add(asnlvdto);
		}
		close();
		return AsgnLvData;
	}

	private static void close() throws IOException {
		wrkbk.close();
		inputStream.close();
	}

}
