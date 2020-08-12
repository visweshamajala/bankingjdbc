package dao;
import java.sql.SQLException;
import bean.Account;
import bean.Loan;

public interface Idao {	
		public int depositAmount(String accountId,int depamt) throws SQLException;
		public int withdrawAmount(String accountId,int widamt) throws SQLException;
		public Account showAccountDetails(String accountNo) throws SQLException;
		public void createAccount(Account account) throws SQLException;	
		public int getLoan(int loanid,int loanamt) throws SQLException;
		public int payLoan(int loanid,int loanamt) throws SQLException;
		public Loan showLoanDetails(int loanid) throws SQLException;
	}


