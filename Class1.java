
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class1
{
	public static void main(String[] args) throws IOException {
		 File file;
		 Scanner sc = new Scanner(System.in);
		 String path;
		
		 
		if(args[0] == null)
		{
			System.out.println("Input File path");
			
			path = sc.next();
			
			file = new File(path);
		}
		else 
		{
			file = new File(args[0]);
		}
		
		
		
		int begin = 0;
        int counter = 0;
        
        System.out.println("Input begin : ");
        
        begin = sc.nextInt();
        
        List file_strings = new ArrayList();
        
       
        BufferedReader br = new BufferedReader(new FileReader(file));
    
        String str;
    
		while((str = br.readLine()) != null) {			
		      counter++;		      
		  if(counter > begin-1){
			  file_strings.add(str);
		  }
		}
	    
	    for(int i = 0; i < file_strings.size(); i++) {
	        System.out.println(file_strings.get(i));
	    }
	}
}
