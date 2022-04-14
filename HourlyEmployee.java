import java.text.DecimalFormat;

class HourlyEmployee extends Wage   // HE - type : hourly employee: 
{
    public void setWageInfo(int EmployeeNum)
    {
                          String isTrue1 = "N";
                          do {
                              System.out.print("hourly wage :");
                              chkVstr = uf.chkStrValue(input.nextLine());
                              if( chkVstr != "N")
                              {
                                boolean isNum =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
                                if(isNum)
                                {
                                      double setNum = Double.parseDouble(chkVstr);    // Convert String to double
                                      if( setNum >= 16.50 )
                                      {
                                        // set value - hourly wage
                                        wageInfo[EmployeeNum][0] = setNum;
                                        isTrue1 = "Y";
                                      }
                                      else
                                      {
                                        System.out.println("Input number more than 16.50");
                                      }
                                }
                              }
                          } while (isTrue1.equals("N"));

                          String isTrue2 = "N";
                          do {
                              System.out.print("hours worked :");
                              chkVstr = uf.chkStrValue(input.nextLine());
                              if( chkVstr != "N")
                              {
                                boolean isNum =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
                                if(isNum)
                                {
                                      double setNum = Double.parseDouble(chkVstr);    // Convert String to double
                                      if( setNum > 0 && setNum <=65 )
                                      {
                                        // set value - hours worked
                                        wageInfo[EmployeeNum][1] = setNum;
                                        isTrue2 = "Y";
                                      }
                                      else
                                      {
                                        System.out.println("Input number more than 0 and don't input number more than 65");
                                      }
                                }
                              }
                          } while (isTrue2.equals("N"));
    }


    public void earned(int EmployeeNum) // HE
    {
      DecimalFormat formatter1 = new DecimalFormat("#,##0.00");
      String sa = formatter1.format(wageInfo[EmployeeNum][0]);
      String sb = formatter1.format(wageInfo[EmployeeNum][1]);
      double earned = wageInfo[EmployeeNum][0] * wageInfo[EmployeeNum][1] ;
      String sc = formatter1.format(earned);
      System.out.println("hourly wage: $"+sa +", hours worked: "+sb);
      System.out.println("earned: $" + sc );
      System.out.println("");
    }
  
}