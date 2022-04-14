import java.text.DecimalFormat;

class CommissionEmployee extends Wage // CE  - type : commission employee
{
    BasedPlusCommissionEmployee BPE = new BasedPlusCommissionEmployee();
 
    public void setWageInfo(int EmployeeNum)
    {
                          String isTrue1 = "N";
                          do {
                              System.out.print("gross sales :");
                              chkVstr = uf.chkStrValue(input.nextLine());
                              if( chkVstr != "N")
                              {
                                boolean isNum =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
                                if(isNum)
                                {
                                      double setNum = Double.parseDouble(chkVstr);    // Convert String to int
                                      if( setNum > 0 )
                                      {
                                        // set value - gross sales
                                        wageInfo[EmployeeNum][0] = setNum;
                                        isTrue1 = "Y";
                                      }
                                      else
                                      {
                                        System.out.println(" Input number more than 0 ");
                                      }
                                }
                              }
                          } while (isTrue1.equals("N"));

                          String isTrue2 = "N";
                          do {
                              System.out.print("commission rate :");
                              chkVstr = uf.chkStrValue(input.nextLine());
                              if( chkVstr != "N")
                              {
                                boolean isNum =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
                                if(isNum)
                                {
                                      double setNum = Double.parseDouble(chkVstr);    // Convert String to int
                                      if( setNum > 0 && setNum <=1 )
                                      {
                                        // set value - commission rate
                                        wageInfo[EmployeeNum][1] = setNum;
                                        isTrue2 = "Y";
                                      }
                                      else
                                      {
                                        System.out.println("Input number more than 0 and don't input more than 1");
                                      }
                                }
                              }
                          } while (isTrue2.equals("N"));
                          
    }

    public void earned(int EmployeeNum)
    {

      
      StringBuffer sb = new StringBuffer();
      StringBuffer sc = new StringBuffer();
      StringBuffer sd = new StringBuffer();

      DecimalFormat formatter3 = new DecimalFormat("#,##0.00");

      if( wageInfo[EmployeeNum][2] == 0 ) // for CommissionEmployee
      {

        String ret = formatter3.format(wageInfo[EmployeeNum][0]);
        sb.append(String.format("%.2f", wageInfo[EmployeeNum][1]));        
        System.out.println("gross sales: $"+ret +"; commission rate: "+sb.toString()); 
        double earned = wageInfo[EmployeeNum][0] * wageInfo[EmployeeNum][1] ;
        sc.append(String.format("%.2f", earned));
        System.out.println("earned: $" + sc.toString()  );
        System.out.println("");
      }
      else if( wageInfo[EmployeeNum][2] > 0 ) // for BasedPlusCommissionEmployee
      {

        String ret = formatter3.format(wageInfo[EmployeeNum][0]);
        sb.append(String.format("%.2f", wageInfo[EmployeeNum][1]));
        sc.append(String.format("%.2f", wageInfo[EmployeeNum][2]));

        System.out.println("gross sales: $"+ret +"; commission rate: "+sb.toString()+", base salary: $"+sc.toString());
        
        double addAmount = 0 ;
        double finalAmount = 0;
        if( addingNum > 0 && statePolymorph == 1 )  // "base salary increase" and "polymorphically"
        {
          addAmount = (( wageInfo[EmployeeNum][2] * addingNum ) / 100) + wageInfo[EmployeeNum][2] ;
        }
        else
        {
          addAmount = wageInfo[EmployeeNum][2] ;
        }

        finalAmount = ( wageInfo[EmployeeNum][0] * wageInfo[EmployeeNum][1] ) + addAmount;
        sd.append(String.format("%.2f", finalAmount));

      System.out.println("earned: $" + sd.toString()  );
      System.out.println("");
      }
    }
}