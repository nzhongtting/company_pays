import java.util.*;

// helpful class
class utilityFn  
{
   Scanner input = new Scanner(System.in);
   String chkVstr = "";  
  
    public String chkStrValue(String inValue)  // Checking for valid value of String
    {
        String result ="N";  // default - inapposite
      
        if( inValue.trim().length() == 0 )  // Checking Enter
        {
          result = "N";
        }
        else
        {
          result = inValue; 
        }
      
      return result;
    }

    public int amountStaff()
    {
      int result = 0 ;
                          String isTrue = "N";
                          do {
                              System.out.print("How many staff do you have ? :");
                              chkVstr = this.chkStrValue(input.nextLine());
                              if( chkVstr != "N")
                              {
                                boolean isNum =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
                                if(isNum)
                                {
                                  if( chkVstr.length() <= 9 )
                                  {
                                      int setNum=Integer.parseInt(chkVstr);       // Convert String to int
                                      if( setNum > 0 )
                                      {
                                        result = setNum ;
                                        isTrue = "Y";
                                      }
                                  }
                                }
                              }
                          } while (isTrue.equals("N"));
      return result;
    }

    public int controlMtd( int num )    // menu prompt !
    {
      int result = 0 ;
      
      String msg = "";
      if(num ==1)
      {
        // (1:just output old list of employee's wage )
        msg = "What do you want (2:to output list for rewarding salaried-commission employees) , (5:to set employee AGAIN) , (9:Exit) :";
      }
      else if(num==2)
      {
        msg = "Base salary increase, e.g. 5 , 8 and 10(%):";
      }
                          String isTrue = "N";
                          do {
                              System.out.println("");
                              System.out.print(msg);
                              chkVstr = this.chkStrValue(input.nextLine());
                              if( chkVstr != "N")
                              {
                                boolean isNum =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
                                if(isNum)
                                {
                                      int setNum=Integer.parseInt(chkVstr);       // Convert String to int
                                      if( setNum > 0 )
                                      {
                                        result = setNum ;
                                        isTrue = "Y";
                                      }
                                  
                                }
                              }
                          } while (isTrue.equals("N"));
      return result; 
    }

    public String addHyphenIRD(int number)  // add hyphen(-) for IRD
    {
      String result = "";
      
      String str = String.format("%09d", number); // "111222" to "000111222"
      
      result = str.substring(0,3) + "-" +str.substring(3,6) +"-" + str.substring(6,9);
      
      return result;
    }

    public static int print2d(double[][] wageInfo) // check base salaries for rewarding salaried-commission employees
    { 
      int m = wageInfo.length;
      double c = 0;
      int d = 0 ;
      for (int i = 0; i < m; i++)
      {
        c = wageInfo[i][2] ;
        if( c > 0 )  d++;
      }
      return d ;
    }    


}