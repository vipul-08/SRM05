import java.util.*;
import java.lang.*;
import java.io.*;
class Srm05B
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int tCases = sc.nextInt();
		sc.nextLine();
		String ans[] = new String[tCases];
		for(int i = 0 ; i < tCases ; i++) {
		    String ip = sc.nextLine();
		    if(ip.indexOf('.') >0) {
		        String parts[] = ip.split("\\.");
		        if(parts.length != 4)
		            ans[i] = "invalid";
		        else {
		            for(int j = 0 ; j < 4 ; j++) {
		                if(parts[j].length() == 0 ) {
		                    ans[i] = "invalid";
		                    break;
		                }
		                else
    		            {
    		                if( parts[j].charAt(0) == '0') {
    		                    if(parts[j].length() == 1) {
    		                        if(j<3)
                                        continue;
                                    else if(j == 3)
                                        ans[i] = "ipv4";
    		                    }
    		                    else {
    		                        ans[i] = "invalid";
    		                        break;
    		                    }
    		                }
    		                if (parts[j].matches("[0-9]+") && parts[j].length() <= 3) {
                                int temp = Integer.parseInt(parts[j]);
                                if(temp >=0 && temp <= 255) {
                                    if(j<3)
                                        continue;
                                    else if(j == 3)
                                        ans[i] = "ipv4";
                                }
                                else {
                                    ans[i] = "invalid";
                                    break;
                                }
                            }
                            else {
                                ans[i] = "invalid";
                                break;
                            }
    		            }  
		            }
		        }
		    }
		    else if(ip.indexOf(':') > 0) {
		        String parts[] = ip.split("\\:");
		        if(parts.length != 8)
		            ans[i] = "invalid";
		        else {
		            for(int j = 0 ; j < 8 ; j++) {
		                if(parts[j].charAt(0) == '0') {
		                    if(parts[j].length() == 1) {
		                        if(j<7)
    		                        continue;
    		                    else if(j==7)
    		                        ans[i] = "ipv6";
		                    }
		                    else {
		                        ans[i] = "invalid";
		                        break;
		                    }
		                }
		                if(parts[j].matches("[0-9a-f]+") && parts[j].length() <= 4) {
		                    if(j<7)
		                        continue;
		                    else if(j==7)
		                        ans[i] = "ipv6";
		                }
		                else {
		                    ans[i] = "invalid";
		                    break;
		                }
		            }
		        }
		    }
		    else
		        ans[i] = "invalid";
		}
		for(String i : ans)
			System.out.println(i);
	}
}