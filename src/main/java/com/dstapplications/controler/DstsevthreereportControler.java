package com.dstapplications.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dstapplications.model.DstSevThreeModel;
import com.dstapplications.utilities.ListFieldsSevThree;




/**
 * Created by vinod on 12/08/18.
 */
@Controller
public class DstsevthreereportControler {
	
	private List<DstSevThreeModel> listFieldsThree;
	
	@Autowired
	private ListFieldsSevThree listFieldsSevThree;

	@RequestMapping("/")
    public String redirtHome(){
	System.out.println("hello");
        return "dstcsaviews/home";
    }
 

    public void display(){
	 
    	if(listFieldsThree !=null ) {
			 for (DstSevThreeModel dstSevThreeModel: listFieldsThree){
				 System.out.println("JIRA ID's    "+dstSevThreeModel.getKey());
				 System.out.println("JIRA Stream    "+dstSevThreeModel.getStream());
			 }
    		
    		System.out.println("Data List ------------"+listFieldsThree.size());
    		
    		System.out.println("Available Data of Key"+listFieldsThree.get(4).getKey());
    	}	 
    }
 
 @RequestMapping("/sevthree/file")
    public String fileUpload(){
    	
       return "dstcsaviews/sevthreefileupload";
    }
 
 @PostMapping("/sevthree/upload") 
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            System.out.println("It is an empty file");
            return "questionviews/fileupload";
        }

        listFieldsThree=listFieldsSevThree.getListofJiraFields(file);
        display();
        return "dstcsaviews/home";
    }
 @RequestMapping("/sevthree/file/export")
 public String exportData() {
     
	 listFieldsSevThree.updateSevThreeData();
	 
	 return "dstcsaviews/home";
}
 

}
