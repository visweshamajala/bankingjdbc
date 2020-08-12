package service;

import java.sql.SQLException;

import bean.Account;
import bean.Loan;

public interface Iservices {

		
		public boolean validAccId(String id);
		public boolean validAccName(String name);
		public int depositAmount(String accId,int amt) throws SQLException;
		public int withdrawAmount(String accId,int amt) throws SQLException;
		public Account showAccountDetails(String accountNo) throws SQLException;
		public void createAccount(Account account) throws SQLException;
		public int getLoan(int loanId,int lamt) throws SQLException;
		public int payLoan(int loanId,int lamt) throws SQLException;
		public Loan showLoanDetails(int loanId) throws SQLException;
	
}
