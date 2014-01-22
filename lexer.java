import java.util.regex.*;
import java.util.*;
import java.io.*;

class state{
	int flag;
	void state(){
	flag=0;
	}
	void init(){
		flag=1;
	}
	void die(){
		flag=0;
	}
	boolean isAlive(){
		if(flag==0)
			return false;
		else
			return true;
	}
}

public class lexer{
public static void main(String[] args) throws FileNotFoundException,IOException{
	
	//intialise counter variables
	//int count=0;
	
	//take input from file
	/*
	FileInputStream fstream = new FileInputStream("D:\files\testfile.txt");
	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append('\n');
            line = br.readLine();
        }
        teststring = sb.toString();
    } finally {
        br.close();
    }
    */
	
	//give input dirrectly as String
	//String teststring="";
	
	Map<String, String> patterns = new HashMap<String, String>();
	
	//registering patterns to match
	//patterns.put("patttern_name", "regex");
	
	//registering states
	//state state_name = new state();
	
	//replace tabs and newline with \t and \n
	String s = cvtLineTerminators (teststring);
	
	
	//compile all the aformentioned patterns
	Pattern p[]= new Pattern[n];
	for(String pattern:patterns.keySet()){
	try
    {
       p[i++] = Pattern.compile (patterns.get(pattern));
    }
    catch (PatternSyntaxException e)
    {
       System.out.println ("Erroneous pattern: " + e.getPattern ());
       return;
    }
	}
    
	//match the patterns with the appropriate actions
	/*
	try{
    while (s.length()>0)
    {
		Matcher m1 = p[1].matcher (s);
		Matcher m2=p[0].matcher(s);
		if(m1.find() && !state_name.isAlive() && m.start()==0){
    	  state_name.init();
		  s = s.substring(m.end());
		  continue;
      }
    	if(m2.find() && state_name.isAlive() && m2.start()==0){
    		count++;
    		if(s.charAt(m2.end())==';')
			def.die();
    		s = s.substring(m2.end());
			continue;
    	}
    	else
    		s = s.substring(1);
      
    }
	}
	catch(Exception e){
	}
	*/
   
   //print out the inference
   //System.out.println(result);
	
    
}
static String cvtLineTerminators (String s)
{
   StringBuffer sb = new StringBuffer (80);
   int oldindex = 0, newindex;
   while ((newindex = s.indexOf ("\\n", oldindex)) != -1)
   {
      sb.append (s.substring (oldindex, newindex));
      oldindex = newindex + 2;
      sb.append ('\n');
   }
   sb.append (s.substring (oldindex));
   s = sb.toString ();
   sb = new StringBuffer (80);
   oldindex = 0;
   while ((newindex = s.indexOf ("\\r", oldindex)) != -1)
   {
      sb.append (s.substring (oldindex, newindex));
      oldindex = newindex + 2;
      sb.append ('\r');
   }
   sb.append (s.substring (oldindex));
   return sb.toString ();
}
}

