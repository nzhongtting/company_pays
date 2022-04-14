class Main {
  public static void main(String[] args) {

        PayRoll PR = new PayRoll();

        PR.SetPayRollState("N");
        do {
        PR.runSetStaff();
        PR.runOutput();
      } while (PR.getPayRollState().equals("N"));

  }
}
