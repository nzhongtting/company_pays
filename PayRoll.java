import java.util.*;

class PayRoll // To test the applications
{
  utilityFn uf = new utilityFn(); // Instantiation - helpful class
  int staffAmt = 0 ;  // use amount of staff
  int actionCd = 0 ;  // use listing or exiting
  int addingCd = 0 ;  // to reward salaried-commission employees by adding

  Wage abstractEarn = null; 

  EmployeeName       EN = new EmployeeName(); // Employee Set name class
  EmployeeIRD        EI = new EmployeeIRD();  // Employee Set IRD class
  EmployeeCategory   EC = new EmployeeCategory(); // Employee Set Wage type class  

  private String payRollState ;   //variable - to identify the PayRoll 

  public void SetPayRollState(String text)
  {
    payRollState = text;
  }

  public String getPayRollState()
  {
    return payRollState;
  }


  public void runSetStaff() // // set amount of staff
  {

    staffAmt = uf.amountStaff();  // checking input number for staff
  
    Wage.wageInfo = new double[staffAmt][3];  //Instantiation - Wage info
  
    EN.epName = new String[staffAmt];
    EN.SetName(staffAmt);
  
    EI.irdNumbers = new int[staffAmt];
    EI.SetIRD(staffAmt);
  
    EC.wageCategories   = new int[staffAmt];
    EC.SetCategory(staffAmt);
  }

  public void runOutput()   // Output 
  {
    

    // OUTPUT -------------------------------------------------------------------------------------
    String isTrue = "N";  // variable - while done  
    do {
        actionCd = uf.controlMtd(1);  // checking input number for menu ("What do you want")

          if( actionCd == 1 || actionCd == 2 )  // action : 1 - nomal output list  , action : 2 - when it has "Base-salaried commission employees"
          {

              if(actionCd == 2 && utilityFn.print2d(Wage.wageInfo) > 0 )  // if there is category of "Base-salaried commission employees"  
              {
                addingCd = uf.controlMtd(2); Wage.addingNum = addingCd ;
              }
              else if(actionCd == 2 && utilityFn.print2d(Wage.wageInfo) == 0 )
              {
                Scanner ch = new Scanner(System.in);
                System.out.println("There is not info of BasePlusCommissionEmployee ! [if you want to output about BasePlusCommissionEmployee , set employee info of BasePlusCommissionEmployee AGAIN  or  'Enter' Key !] ");
                ch.nextLine();
                Wage.addingNum = 0;
              }
              else
              {
                Wage.addingNum = 0;
              }

              // None polymorphically --------------------------------------------------------------
               System.out.println("");
               System.out.println("Employees processed individually:");
               System.out.println("");
               
              for(int i=0;i<EC.wageCategories.length;i++) //length is the property of array
              {

                if(EC.wageCategories[i] == 0 )  // input number for Salaried employees
                {
                  System.out.println("salaried employee: "+EN.epName[i]);
                  String strIRD = uf.addHyphenIRD(EI.irdNumbers[i]);
                  System.out.println("IRD Number: "+strIRD);
                  EI.SE.earned(i);
                }
                else if(EC.wageCategories[i] == 1 )  // input number for Hourly paid employees
                {
                  System.out.println("hourly employee: "+EN.epName[i]);
                  String strIRD = uf.addHyphenIRD(EI.irdNumbers[i]);
                  System.out.println("IRD Number: "+strIRD);                  
                  EI.HE.earned(i);
                }      
                else if(EC.wageCategories[i] == 2 ) // input number for Commission only employees
                {
                  System.out.println("commission employee: "+EN.epName[i]); 
                  String strIRD = uf.addHyphenIRD(EI.irdNumbers[i]);
                  System.out.println("IRD Number: "+strIRD); 
                  EI.CE.earned(i);
                }
                else if(EC.wageCategories[i] == 3  )  // input number for Base-salaried commission employees
                {
                  System.out.println("base-salaried commission employee: "+EN.epName[i]);
                  String strIRD = uf.addHyphenIRD(EI.irdNumbers[i]);
                  System.out.println("IRD Number: "+strIRD); 
                  Wage.statePolymorph = 0;
                  EI.CE.earned(i);
                }
              }


              // polymorphically --------------------------------------------------------------
               
               String SumEmplyList = "";  // Category List of Employee 
               System.out.println("");
               System.out.println("Employees processed polymorphically:");
               System.out.println("");
              for(int i=0;i<EC.wageCategories.length;i++) //length is the property of array
              {
                if(EC.wageCategories[i] == 0 )  // // input number for Salaried employees
                {
                  abstractEarn = new SalariedEmployee();
                  System.out.println("salaried employee: "+EN.epName[i]);
                  String strIRD = uf.addHyphenIRD(EI.irdNumbers[i]);
                  System.out.println("IRD Number: "+strIRD);
                  abstractEarn.earned(i);
                  SumEmplyList = SumEmplyList + "Employee "+i+" is a Employee.SalariedEmployee.\n";
                }
                else if(EC.wageCategories[i] == 1 )   // // input number for Hourly paid employees
                {
                  abstractEarn = new HourlyEmployee();                  
                  System.out.println("hourly employee: "+EN.epName[i]);
                  String strIRD = uf.addHyphenIRD(EI.irdNumbers[i]);
                  System.out.println("IRD Number: "+strIRD);                  
                  abstractEarn.earned(i);
                  SumEmplyList = SumEmplyList + "Employee "+i+" is a Employee.HourlyEmployee.\n";
                }      
                else if(EC.wageCategories[i] == 2 ) // input number for Commission only employees
                {
                  abstractEarn = new CommissionEmployee();   
                  System.out.println("commission employee: "+EN.epName[i]);   
                  String strIRD = uf.addHyphenIRD(EI.irdNumbers[i]);
                  System.out.println("IRD Number: "+strIRD);                  
                  abstractEarn.earned(i);
                  SumEmplyList = SumEmplyList + "Employee "+i+" is a Employee.CommissionEmployee.\n";
                }
                else if(EC.wageCategories[i] == 3  )  // input number for Base-salaried commission employees
                {
                  abstractEarn = new CommissionEmployee();
                  System.out.println("base-salaried commission employee: "+EN.epName[i]);
                  String strIRD = uf.addHyphenIRD(EI.irdNumbers[i]);
                  System.out.println("IRD Number: "+strIRD);
                  Wage.statePolymorph = 1;  // polymorphically
                  abstractEarn.earned(i);
                  SumEmplyList = SumEmplyList + "Employee "+i+" is a Employee.BasePlusCommissionEmployee.\n";
                }
              }
              System.out.println(SumEmplyList);          
          }       
          else if( actionCd == 5  ) // to set the amount of employees again 
          {
            System.out.println("");
            System.out.println("Again -------------------------------------- ");
            System.out.println("");
            System.out.println("");
            isTrue = "Y";
          }
          else if( actionCd == 9  ) // to exit
          {
            System.out.println("");
            System.out.println("Exit -------------------------------------- ");
            System.out.println("");
            System.out.println("");            
            isTrue = "Y";
            this.payRollState = "Y" ;
          }
       } while (isTrue.equals("N"));
  }
}