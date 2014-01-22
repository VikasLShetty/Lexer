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
public class mylexer2{
public static void main(String[] args) throws FileNotFoundException,IOException{
	/*
	FileInputStream fstream = new FileInputStream("D:\files\testfile.txt");
	BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	*/
	String teststring="int a,b; \n int c,d,e;";
	Map<String, String> patterns = new HashMap<String, String>();
	patterns.put("id", "[a-zA-Z][a-zA-Z0-9]*");
	patterns.put("dec","(\\s)*int(\\s)+");
	int n=2;
	int idcnt=0;
	state def = new state();
	/*
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
	String s = cvtLineTerminators (teststring);
	Pattern p[]= new Pattern[n];
	int i=0;
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
    try{
    while (s.length()>0)
    {
		Matcher m = p[1].matcher (s);
		Matcher m2=p[0].matcher(s);
		if(m.find() && !def.isAlive() && m.start()==0){
    	  def.init();
		  s = s.substring(m.end());
		  continue;
      }
    	if(m2.find() && def.isAlive() && m2.start()==0){
    		idcnt++;
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
   System.out.println("no. of identifiers = "+idcnt);
	
    
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

