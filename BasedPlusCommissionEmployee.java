import java.util.*;

class BasedPlusCommissionEmployee // BPE - type : base-salaried commission employee: 
{
 utilityFn uf = new utilityFn();
 Scanner input = new Scanner(System.in);
 String chkVstr = "";  
  
  public double SetBasedPlus(int EmployeeNum) // set - base salary 
  {
    double result = 0 ;
                          String isTrue = "N";
                          do {
                              System.out.print("base salary :");
                              chkVstr = uf.chkStrValue(input.nextLine());
                              if( chkVstr != "N")
                              {
                                boolean isNum =  chkVstr.matches("[+-]?\\d*(\\.\\d+)?"); // checking number
                                if(isNum)
                                {
                                      double setNum = Double.parseDouble(chkVstr);    // Convert String to int
                                      if( setNum > 0 )
                                      {
                                        // set value - base salary
                                        result = setNum;
                                        isTrue = "Y";
                                      }
                                }
                              }
                          } while (isTrue.equals("N"));    
    
  return  result;
  }

}