import java.util.*;
// Employee ---------------------------------------------------------------------------------------
class Employee
{
  Scanner sc = new Scanner(System.in);
  String[] epName ;          // Employee name
  int[] irdNumbers;          // Employee IRD number
  int[] wageCategories ;     // Employee category of wage
  utilityFn uf = new utilityFn();
  String chkVstr = "";
  SalariedEmployee SE = new SalariedEmployee();
  HourlyEmployee HE = new HourlyEmployee();
  CommissionEmployee CE = new CommissionEmployee();
}

class EmployeeName extends Employee   // for Employee name
{
  public void SetName(int amountStaff)
  {
    for (int i = 0; i < amountStaff; i++)
    {
        System.out.print("Enter Name ["+(i+1)+"] :");
        chkVstr = uf.chkStrValue(sc.nextLine());
        if( chkVstr != "N")
        {
          // System.out.println("chkVstr :"+chkVstr);     
          epName[i] = chkVstr ;
        }
        else
        {
          System.out.println("Please enter a valid value ! [01]");
          i--;
        }
    }
  }
}

class EmployeeIRD extends Employee  // for Employee IRD
{
  public void SetIRD(int amountStaff)
  {


    for (int i = 0; i < amountStaff; i++)
    {

      System.out.print("Enter IRD Number ["+(i+1)+"] :");
      chkVstr = uf.chkStrValue(sc.nextLine());
      
      if( chkVstr != "N")    // There is value ( no Enter ! )
      {
        boolean isNumeric =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
        if( isNumeric ) // only number
        {

          // System.out.println("num");
          if( chkVstr.length() == 9 )  // IRD number must be 9spell
          {
            int number = Integer.parseInt(chkVstr);    // Convert String to int
            irdNumbers[i] = number ;
          }
          else if( chkVstr.length() > 9 )  // no 9spell
          {
            System.out.println("Please enter a valid value ![04]");
            i--;
          }
          else if( chkVstr.length() < 9 )  // no 9spell
          {
            System.out.println("Please enter a valid value ![05]");
            i--;
          }
        }
        else
        {
          // System.out.println("str");
          System.out.println("Please enter a valid value ![02]");
          i--;
        }
      }
      else
      {
        System.out.println("Please enter a valid value ![03]");
        i--;
      }
    }
  }
}


class EmployeeCategory extends Employee   // for Employee four categories 
{
  public void SetCategory(int amountStaff)
  {

    for (int i = 0; i < amountStaff; i++)
    {
      System.out.print("Enter wage type (0:Salaried),(1:Hourly),(2:Commission),(3:BasedPlusCommission) ["+(i+1)+"] :");
      chkVstr = uf.chkStrValue(sc.nextLine());
      if( chkVstr != "N")
      {

        boolean isNumeric =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
        
        if( isNumeric )  // only number
        {
                   if( chkVstr.length() == 1 )
                   {
                    int number = Integer.parseInt(chkVstr);    // Convert String to int

                     if(number >= 0 && number <= 3)
                     {
                     wageCategories[i] = number ;

                       if(number == 0)        // set info for salaried
                       {
                         SE.setWageInfo(i);
                       }
                       else if(number == 1)   // set info for Hourly
                       {
                         HE.setWageInfo(i);
                       }
                       else if(number == 2)   // set info for Commission
                       {
                         CE.setWageInfo(i);
                       }
                       else if(number == 3)   // set info for BasedPlusCommission
                       {
                         CE.setWageInfo(i);
                         Wage.wageInfo[i][2] = CE.BPE.SetBasedPlus(i);
                       }
                     }
                     else
                     {
                      System.out.println("Please enter a valid value ![08]");
                      i--;
                     }                     
                   }
                   else
                   {
                    System.out.println("Please enter a valid value ![07]");
                    i--;                     
                   }
        }
        else
        {
          // System.out.println("str");
          System.out.println("Please enter a valid value ![06]");
          i--;
        }

      }
      else
      {
          // System.out.println("str");
          System.out.println("Please enter a valid value ![09]");
          i--;
      }
    }    
    
  }
}