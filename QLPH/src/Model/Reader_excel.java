package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Reader_excel {

	public static ArrayList<Phong_hoc> getCell(String link) throws IOException {

		ArrayList<Phong_hoc> lib = new ArrayList<Phong_hoc>();
		Phong_hoc tmp = new Phong_hoc("", "", "", "");
		// input
		FileInputStream inputStream = new FileInputStream(new File(link));
		// doc xls->HSSF, xlsx -> XSSF
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		// lay so cot
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next(); // bo qua dong 1

			//
			Iterator<Cell> cellIterator = row.cellIterator();
			tmp = new Phong_hoc("", "", "", "");

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getAddress().toString().substring(0, 1)) {
				case "A": {
					tmp.Set_Room(cell.toString());
					// System.out.print(" "+cell.toString());
				}
					;
				case "B": {
					tmp.Set_Class(cell.toString());
					// System.out.print(" "+cell.toString());
				}
					;
				case "C": {
					tmp.Set_State(cell.toString());
				}
					;
				case "D": {
					if (cell.toString().contains("mark")) {
						tmp.Detail = "null";
						// System.out.println(cell.toString());
					} else
						
						tmp.Detail = cell.toString();
				}

				}
			}
			lib.add(tmp); // them vao mang
		}
	//	System.out.println("okok");
		return lib;
	}

}
