import java.text.DecimalFormat;

class SalariedEmployee extends Wage   // SE  - type : salaried employee 
{

    public void setWageInfo(int EmployeeNum)
    {
                          String isTrue = "N";
                          do {
                              System.out.print("WeeklySalary :");
                              chkVstr = uf.chkStrValue(input.nextLine());
                              if( chkVstr != "N")
                              {
                                boolean isNum =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
                                if(isNum)
                                {
                                      double setNum = Double.parseDouble(chkVstr);    // Convert String to double
                                      if( setNum > 0 )
                                      {
                                        // set value - weekly salary
                                        wageInfo[EmployeeNum][0] = setNum;
                                        isTrue = "Y";
                                      }
                                      else
                                      {
                                        System.out.println("weekly salary should be greater than 0.0");
                                      }
                                }
                              }
                          } while (isTrue.equals("N"));
    }

    public void earned(int EmployeeNum)
    {
      DecimalFormat formatter2 = new DecimalFormat("#,##0.00");
      String ret = formatter2.format(wageInfo[EmployeeNum][0]);
      System.out.println("weekly salary: $" + ret );
      System.out.println("earned: $" + ret );
      System.out.println("");
    }

}