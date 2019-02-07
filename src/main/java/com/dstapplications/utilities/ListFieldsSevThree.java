package com.dstapplications.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dstapplications.model.DstSevThreeModel;


/**
 * Created by vinod on 12/08/18.
 */
@Component
public class ListFieldsSevThree {
	
	private DstSevThreeModel dstSevThreeModel;
	private static String UPLOADED_FOLDER = "C://tmp//";
	private List<DstSevThreeModel> dstSevThreeList=new ArrayList<DstSevThreeModel>();
	
	public List<DstSevThreeModel> getListofJiraFields(MultipartFile file){
		
		
		  try {

	           byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	            
	            System.out.println("FileName++++++++++"+UPLOADED_FOLDER + file.getOriginalFilename());
	            System.out.println("File uploaded successfully"+path);
	           
	            /* 
	            // Creating a Workbook from an Excel file (.xls or .xlsx)
	            Workbook workbook = WorkbookFactory.create(new File(path.toString()));*/
			  
			  FileInputStream input_document = new FileInputStream(new File(UPLOADED_FOLDER + file.getOriginalFilename()));
              HSSFWorkbook workbook = new HSSFWorkbook(input_document);    
              

	            // Retrieving the number of sheets in the Workbook
	            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

	            // Getting the Sheet at index zero
	            HSSFSheet  sheet = workbook.getSheetAt(0);
	            
	            // Create a DataFormatter to format and get each cell's value as String
	            DataFormatter dataFormatter = new DataFormatter();
	          int rownumber=1;
	          for (Row row: sheet) {
	        	  
	            	int cellnumber=0;
	            	if(rownumber>=5) {
	            		dstSevThreeModel=new DstSevThreeModel();	
	            		
	                for(Cell cell: row)  {
		                    String cellValue = dataFormatter.formatCellValue(cell);
		                    cellnumber=cellnumber+1;
		                    
		                    if(cellnumber==1) {
		                    	dstSevThreeModel.setIssue_Type(cellValue);
		                    }
		                    if(cellnumber==2) {
		                    	dstSevThreeModel.setKey(cellValue);
		                    }
		                    if(cellnumber==3) {
		                    	dstSevThreeModel.setSummary(cellValue);;
		                    }
		                    if(cellnumber==4) {
		                    	dstSevThreeModel.setAssignee(cellValue);;
		                    }
		                    if(cellnumber==5) {
		                    	dstSevThreeModel.setReporter(cellValue);
		                    }
		                    if(cellnumber==6) {
		                    	dstSevThreeModel.setStatus(cellValue);
		                    }
		                    if(cellnumber==7) {
		                    	dstSevThreeModel.setResolution(cellValue);
		                    }
		                    if(cellnumber==8) {
		                    	dstSevThreeModel.setCreated(cellValue);
		                    }
		                    if(cellnumber==9) {
		                    	dstSevThreeModel.setUpdated(cellValue);
		                    }
		                    if(cellnumber==10) {
		                    	dstSevThreeModel.setDays_since_last_comment(cellValue);
		                    }
		                    if(cellnumber==11) {
		                    	dstSevThreeModel.setStream(cellValue);
		                    }
		                    if(cellnumber==12) {
		                    	dstSevThreeModel.setPriority(cellValue);
		                    }
	                	}
	                dstSevThreeList.add(dstSevThreeModel); 
	                }
	            	 rownumber=rownumber+1;
		              
	               
	            
	            }

	            workbook.close();
	                    
	        } catch (IOException | EncryptedDocumentException e) {
	            e.printStackTrace();
	        }
		return dstSevThreeList;
	}
	
	public void updateSevThreeData() { 
		
		try {
                
                FileInputStream fis= new FileInputStream(new File(UPLOADED_FOLDER +"slabackloganalasys.xlsx")); //Read the spreadsheet that needs to be updated
                 
                XSSFWorkbook workbook = new XSSFWorkbook (fis); //Access the workbook
                 
                XSSFSheet sheet = workbook.getSheetAt(2); //Access the worksheet, so that we can update / modify it.
                 
                
                DataFormatter dataFormatter = new DataFormatter();
                
                
                DstSevThreeModel dstSevThreeModel;
                
              int datasize=dstSevThreeList.size();
              int datarownumber=0;
  	          int rownumber=1;
  	      //  if(datarownumber<dstSevThreeList.size()) {
  	          for (Row row: sheet) {
  	        	  
  	        	if(row!= null) {
  	            	int cellnumber=0;
  	            	if(rownumber>=2 ) {
  	            		
  	            		
  	            		 
  	            		dstSevThreeModel=new DstSevThreeModel();
  	            		
  	            		dstSevThreeModel = dstSevThreeList.get(datarownumber);
  	            		
  	            		datarownumber=datarownumber+1;
  	     					
	  	                for(Cell cell: row)  {
	  		                    //String cellValue = dataFormatter.formatCellValue(cell);
	  		                    cellnumber=cellnumber+1;
	  		                    
	  		                    if(cellnumber==1) {
	  		                    	cell.setCellValue(dstSevThreeModel.getKey());
	  		                    }
	  		                    if(cellnumber==2) {
	  		                    	cell.setCellValue("OverRide2");
	  		                    }
	  		                    if(cellnumber==3) {
	  		                    	cell.setCellValue("OverRide3");
	  		                    }
	  		                    
	  		                }
  	            		 
	  	            	
  	                }
  	            	
  	            	 rownumber=rownumber+1;
  	        		}	
  	            }
  	          
  	        
  	          
  	          
                
                          
                fis.close(); //Close the InputStream
                
                FileOutputStream output_file =new FileOutputStream(new File(UPLOADED_FOLDER +"slabackloganalasys.xlsx"));  //Open FileOutputStream to write updates
                 
                workbook.write(output_file); //write changes
                 
                output_file.close();  //close the stream 
                workbook.close();
		
		
		}
		 catch (IOException | EncryptedDocumentException e) {
	            e.printStackTrace();
	        }
        }

}
