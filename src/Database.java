public class Database{
    private int account[][] = {
        {201511032, 88888, 80500},
        {201563244, 12345, 3000},
        {201410230, 54321, 27450},
        {201596427, 98765, 6500},
        {201456329, 65432, 13200}
    };
    private int currentAccount = account.length;

    public boolean authenticateAccount(int accountNumberInput, int pinInput){        
        boolean found = false;
        for(int row = 0; row < account.length; row++){             
            if (account[row][0] == accountNumberInput && account[row][1] == pinInput) {
                setUserAccount(row);
                found = true;
            }
        }return found;        
    }

    public void setUserAccount(int row){
        this.currentAccount = row;
    }

    public int getUserAccount(){
        return this.currentAccount;
    }
   
    public void setBalance(int row, int amount){
        this.account[row][2] += amount;
    }

    public int getBalance(int row){
        return this.account[row][2];
    }

    public void debit(int row, int amount){
        this.account[row][2] -= amount;
    }    
}