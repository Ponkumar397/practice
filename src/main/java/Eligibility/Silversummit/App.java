package Eligibility.Silversummit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.api.robot.desktop.DesktopKeyboard;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException, AWTException
    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\PonkumarE\\chromedriver\\chromedriver.exe");
		    ChromeOptions options=new ChromeOptions();
		    options.addArguments("--remote-allow-origins=*");
		    WebDriver driver=new ChromeDriver(options);
		    driver.get("https://silversummithealthplan.entrykeyid.com/as/authorization.oauth2?response_type=code&client_id=cnc-provider-mono&scope=openid%20profile&state=BpKA__s1TS6HMH09j4y4CWW8kdN4d8t7FUY7cEA_VsA%3D&redirect_uri=https://provider.silversummithealthplan.com/careconnect/login/oauth2/code/pingcloud&code_challenge_method=S256&nonce=zkoFis3JoCNl_UzQ3m7jNTJb973Gdm08hngFkNy982w&code_challenge=ESxGlLA5LXhi4JDtT55kdIpanVQs1yiDacpATxNkON0&app_origin=https://provider.silversummithealthplan.com/careconnect/login/oauth2/code/pingcloud&brand=silversummithealthplan");
		    driver.manage().window().maximize();
	    int err=1;
	    while(err<100)
	    {
	    try {
			driver.findElement(By.id("identifierInput")).sendKeys("abattershell@stplv.com");
			Thread.sleep(500);
			break;
		} catch (Exception e) {
			err+=1;
			Thread.sleep(1000);
			
		}}
	    driver.findElement(By.xpath("//a[contains(@class,'ping-button normal')]")).click();
	    int err1=1;
	    while(err1<100)
	    {
	    try {
			driver.findElement(By.id("password")).sendKeys("Therapy$45");
			break;
		} catch (Exception e) {
			err1+=1;
			Thread.sleep(1000);
		}}
	    Thread.sleep(500);
	    driver.findElement(By.id("signOnButton")).click();
	    int err2=1;
	    while(err2<100)
	    {
	    try {
			driver.findElement(By.id("providerProfileId")).click();
			Thread.sleep(1500);
			break;
		} catch (Exception e) {
			err2+=1;
			Thread.sleep(1000);
		}}
	    driver.findElement(By.xpath("//*[@id='providerProfileId']/option[1]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("providerProfileName")).click();
	    Thread.sleep(1500);
	    driver.findElement(By.xpath("//option[text()='Silver Summit']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("medicalDropdownSubmitID")).click();
	    Thread.sleep(1000);
	    int err3=1;
	    while(err3<100)
	    {
	    try {
			driver.findElement(By.xpath("//a[@class='eligibility']//i[1]")).click();
			break;
		} catch (Exception e) {
			err3+=1;
			Thread.sleep(1000);
		}}
	    File f=new File("C:\\Users\\PonkumarE\\Documents\\Silversummit\\Input\\input.xlsx");
	    FileInputStream fis=new FileInputStream(f);
	  	 XSSFWorkbook xsf=new XSSFWorkbook(fis);
	  	 XSSFSheet sheet= xsf.getSheetAt(0);
	  	DataFormatter formatter = new DataFormatter();	
	  	
	    DesktopKeyboard keyboard = new DesktopKeyboard();
	    Robot robot = new Robot();
	    for(int i=72;i<=sheet.getLastRowNum();i++)
	    {
	    	String memberid=formatter.formatCellValue(sheet.getRow(i).getCell(0));
	    	String dob=formatter.formatCellValue(sheet.getRow(i).getCell(1));
	    	String pin=formatter.formatCellValue(sheet.getRow(i).getCell(2));
	    	String dateofb="";
	        String[] dateComponents = dob.split("/");
	        if (dateComponents.length == 3) {
	            
	            int month = Integer.parseInt(dateComponents[0]);
	            int day = Integer.parseInt(dateComponents[1]);
	            int year = Integer.parseInt(dateComponents[2]);
	            System.out.println(year);
	            // Determine the century for the year component
	            if (year < 25) {
	                year += 2000;
	            } else {
	                year += 1900;
	            }
	            
	            // Create the output date string in "MM/dd/yyyy" format
	             dateofb = String.format("%02d/%02d/%04d", month, day, year);
	        }
	        Thread.sleep(1000);
	        int err4=1;
	        while(err4<100)
	        {
	    	   try {
				driver.findElement(By.name("memberIdOrLastName")).sendKeys(memberid);
				Thread.sleep(500);
				break;
			} catch (Exception e) {
				err4+=1;
				Thread.sleep(1000);
			}
	        }
	        driver.findElement(By.name("dob")).click();
	        Thread.sleep(500);
	        typeText(robot, dateofb);
	        Thread.sleep(500);
	        driver.findElement(By.name("check")).click();
	        Thread.sleep(2000);
	        Map patient=new LinkedHashMap();
	        Map pcp=new LinkedHashMap();
	        Map eligibility=new LinkedHashMap();
	        JSONArray arr=new JSONArray();
        	Map obj=new LinkedHashMap();
	        try
	        {
	        	
	        	driver.findElement(By.xpath("//span[text()='View details']")).click();
	        	Thread.sleep(3000);
	        	int err5=1;
	        	while(err5<100)
	        	{
	        		try {
						driver.findElement(By.id("viewClinicalInfoButton")).click();
						Thread.sleep(1000);
						break;
					} catch (Exception e) {
						err5+=1;
						Thread.sleep(1000);
					}
	        	}
	        	
	        	String name=driver.findElement(By.xpath("(//span[@class='info'])[1]")).getText();
	        	String gender=driver.findElement(By.xpath("(//span[@class='info'])[2]")).getText();
	        	String birthdate=driver.findElement(By.xpath("(//span[@class='info'])[3]")).getText();
	        	String age=driver.findElement(By.xpath("(//span[@class='info'])[4]")).getText();
	        	String memid=driver.findElement(By.xpath("(//span[@class='info'])[5]")).getText();
	        	String address1=driver.findElement(By.xpath("(//span[@class='info'])[6]")).getText();
	        	String address=address1.replaceAll("\n","");
	        	String date=driver.findElement(By.xpath("(//span[@class='info'])[7]")).getText();
	        	
				
	        	
				
	        	String startdate=driver.findElement(By.xpath("(//tr[@class='eligHistLess']//td)[1]")).getText();
	        	String enddate=driver.findElement(By.xpath("(//tr[@class='eligHistLess']//td)[2]")).getText();
	        	String productname=driver.findElement(By.xpath("(//tr[@class='eligHistLess']//td)[3]")).getText();
	        	patient.put("Pin#",pin);
	        	patient.put("Name",name);
	        	patient.put("Gender",gender);
	        	patient.put("Birthdate",birthdate);
	        	patient.put("Age",age);
	        	patient.put("Member #",memid);
	        	patient.put("Address",address);
	        	patient.put("Redetermination Date",date);
	        	
					 
					try {
						String	pcpname = driver.findElement(By.xpath("(//span[@class='info'])[8]")).getText();
						pcp.put("Name",pcpname);
					} catch (Exception e2) {
						
					}
					try {
						String pcpaddress1=driver.findElement(By.xpath("(//span[@class='info'])[9]")).getText();
						String pcpaddress = pcpaddress1.replaceAll("\n","");
						pcp.put("Address",pcpaddress);
					} catch (Exception e2) {
						
					}
					try {
						String practicetype = driver.findElement(By.xpath("(//span[@class='info'])[10]")).getText();
						pcp.put("Practice Type",practicetype);
					} catch (Exception e2) {
						
					}
				
	        	
	        	
	        	try {
					String phoneno = driver.findElement(By.xpath("(//span[@class='info'])[11]")).getText();
					pcp.put("Phone Number",phoneno);
				} catch (Exception e1) {
					
				}
	        	
	        	eligibility.put("Start Date",startdate);
	        	eligibility.put("End Date",enddate);
	        	eligibility.put("Product Name",productname);
	        	try
	        	{
	        		driver.findElement(By.xpath("//*[@id=\"memberdetails-page\"]/body/div[4]/div[2]/div/div[1]/button/img")).click();
              	  Thread.sleep(1000);
	        	}
	        	catch(Exception e)
	        	{
	        		
	        	}
	        	
	        	keyboard.keyDown(KeyEvent.VK_CONTROL);
	        	keyboard.keyDown(KeyEvent.VK_P);
	        	keyboard.keyUp(KeyEvent.VK_P);
                keyboard.keyUp(KeyEvent.VK_CONTROL);
	        	if(i==72)
	        	{
	        		Thread.sleep(15000);
	        	}
	        	else
	        	{
	        		Thread.sleep(6000);
	        	}
	        	 keyboard.keyDown(KeyEvent.VK_ENTER);
	                keyboard.keyUp(KeyEvent.VK_ENTER);
	                Thread.sleep(5000);
	                
	                String path1="C:\\Users\\PonkumarE\\Documents\\Silversummit\\pdf\\"+pin;
	                System.out.println(path1);
	                StringSelection stringSelection7 = new StringSelection(path1);
	                Clipboard clipboard7 = Toolkit.getDefaultToolkit().getSystemClipboard();
	                clipboard7.setContents(stringSelection7, stringSelection7);
	                robot.keyPress(KeyEvent.VK_CONTROL);
	                robot.keyPress(KeyEvent.VK_V);
	                robot.keyRelease(KeyEvent.VK_V);
	                robot.keyRelease(KeyEvent.VK_CONTROL);
	                Thread.sleep(1000);
	                keyboard.keyDown(KeyEvent.VK_ENTER);
	                keyboard.keyUp(KeyEvent.VK_ENTER);
	                  Thread.sleep(2000);
	                  try
	                  {
	                	  driver.findElement(By.xpath("//*[@id=\"memberdetails-page\"]/body/div[4]/div[2]/div/div[1]/button/img")).click();
	                	  Thread.sleep(1000);
	                  }
	                  catch(Exception e)
	                  {
	                	  
	                  }
	                  robot.keyPress(KeyEvent.VK_CONTROL);
		                robot.keyPress(KeyEvent.VK_HOME);
		                robot.keyRelease(KeyEvent.VK_HOME);
		                robot.keyRelease(KeyEvent.VK_CONTROL);
		                Thread.sleep(500);
	                  driver.findElement(By.xpath("//*[text()='Back to Eligibility Check']")).click();
	                 Thread.sleep(2000);
	                  
	        }
	        catch(Exception e)
	        {
	        	patient.put("Pin#",pin);
	        	patient.put("Name","Error : No result found");
	        	driver.findElement(By.xpath("//button[text()=' Remove']")).click();
	        	Thread.sleep(1000);
	        	driver.findElement(By.name("memberIdOrLastName")).clear();
	        	Thread.sleep(500);
	        	driver.findElement(By.name("dob")).clear();
	        	Thread.sleep(500);
	        	
	        }
	        obj.put("Patient Information",patient);
	        
        	try {
				obj.put("PCP Information",pcp);
				obj.put("Eligibility History",eligibility);
			} catch (Exception e) {
				
			}
        	arr.add(obj);
        	FileWriter file = new FileWriter("C:\\Users\\PonkumarE\\Documents\\Silversummit\\Json\\"+pin+".json");
            ObjectMapper mapper = new ObjectMapper();
    		LinkedHashSet<Map> set= new LinkedHashSet<>(arr);
            file.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(set).toString());
            file.flush();
            Thread.sleep(2000);
	    }
	    driver.quit();
	    }
	    public static void typeText(Robot robot, String text) {
	        for (char c : text.toCharArray()) {
	            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
	            robot.keyPress(keyCode);      
	            robot.keyRelease(keyCode);    
	        }
	    }
}
