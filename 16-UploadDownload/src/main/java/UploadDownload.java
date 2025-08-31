import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UploadDownload {
    public static void main(String[] args) throws IOException {

        String fruitName = "Apple";
        String updatedValue = "598";
        Path downloadDir = Paths.get(System.getProperty("user.home"), "Downloads");
        Path target = downloadDir.resolve("download.xlsx");
        Path temp   = downloadDir.resolve("download.xlsx.crdownload");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDir.toString());
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/upload-download-test/");

        // clean previous
        Files.deleteIfExists(target);
        Files.deleteIfExists(temp);

        // trigger download
        driver.findElement(By.cssSelector("#downloadButton")).click();

        // wait until finished
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(d -> Files.exists(target) && !Files.exists(temp));

        String fileName = target.toString();

        //Edit excel - getColumnNumber of Price, getRowNumber of Apple -> update excel with row,col
        int col = getColumnNumber(fileName, "Price");
        int row = getRowNumber(fileName, "Apple");
        Assert.assertTrue( updateCell(fileName, row, col, updatedValue));

        //Upload
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys(fileName);

        //Wait for success message to show up and wait for disappear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // locator for the toast
        By toastLocatorByXPath = By.xpath("//div[contains(text(),'Updated Excel Data Successfully.')]");
        By toastLocatorByCSS = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
        By allToasts = By.cssSelector(".Toastify__toast-body");

        // wait for it to be visible first (optional)
        wait.until(ExpectedConditions.visibilityOfElementLocated(allToasts));
        String toastText = driver.findElement(allToasts).getText();

        // then wait for it to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(allToasts));

        Assert.assertEquals("Updated Excel Data Successfully.", toastText);

        //Verify updated excel data showing in the web table
        String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
        String actualPrice = driver.findElement(By.xpath(
                "//div[text()='" + fruitName + "']/parent::div/following-sibling::div[@id='cell-" + priceColumn + "-undefined']")).getText();
        System.out.println(actualPrice);
        Assert.assertEquals("598", actualPrice);
        //get price of apple
    }

    private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {
        ArrayList<String> a=new ArrayList<String>();
        FileInputStream fis=new FileInputStream(fileName);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Sheet1"); //Identify Testcases column by scanning the entire 1st row
        Row rowField = sheet.getRow(row-1);
        Cell cellField = rowField.getCell(col-1);
        cellField.setCellValue(updatedValue);
        FileOutputStream fos = new FileOutputStream(fileName);
        try {
            workbook.write(fos);
            fos.flush();
        } finally {
            fos.close();
            workbook.close();
        }
        return true;
    }

    private static int getRowNumber(String fileName, String text) throws IOException {
        ArrayList<String> a=new ArrayList<String>();
        FileInputStream fis=new FileInputStream(fileName);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);

        XSSFSheet sheet=workbook.getSheet("Sheet1"); //Identify Testcases column by scanning the entire 1st row
        Iterator<Row> rows= sheet.iterator(); // sheet is collection of rows

        int k = 1;
        int rowIndex = -1;
        while(rows.hasNext()){
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
            while(cells.hasNext())
            {
                Cell cell = cells.next();
                if(cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(text)){
                    rowIndex = k;
                }
            }
            k++;
        }
        System.out.println("Get Row Number:" + rowIndex);
        return rowIndex;
    }

    private static int getColumnNumber(String fileName, String colName) throws IOException {
        ArrayList<String> a=new ArrayList<String>();
        FileInputStream fis=new FileInputStream(fileName);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);

        XSSFSheet sheet=workbook.getSheet("Sheet1"); //Identify Testcases column by scanning the entire 1st row
        Iterator<Row> rows= sheet.iterator(); // sheet is collection of rows
        Row firstrow= rows.next();
        Iterator<Cell> ce=firstrow.cellIterator(); //row is collection of cells
        int k=1;
        int column = 0;
        while(ce.hasNext()) {
            Cell value = ce.next();
            if (value.getStringCellValue().equalsIgnoreCase(colName)) {
                column = k;
            }
            k++;
        }
    	System.out.println("Get Column Number:" + column);
		return column;
    }
}


