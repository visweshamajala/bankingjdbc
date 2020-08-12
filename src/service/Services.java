package service;
import java.sql.SQLException;

import bean.Account;
import bean.Loan;
//import dao.BankDao;

import dao.Dao;


public class Services implements Iservices{
		Dao dao;
		
		public Services() throws Exception {
			dao= new Dao();
		}

		@Override
		public boolean validAccId(String id) {
			String regexId = "^[0-9]{7}[A-Za-z]{4}$";
			return id.matches(regexId);
		}

		@Override
		public boolean validAccName(String name) {
			String regexName = "^[A-Z]{1}[a-z]{2,30}$";
			return name.matches(regexName);
		}

		@Override
		public int depositAmount(String accountId, int amt) throws SQLException {
			// TODO Auto-generated method stub
			return dao.depositAmount(accountId, amt);
		}

		@Override
		public int withdrawAmount(String accountId, int amt) throws SQLException {
			// TODO Auto-generated method stub
			return dao.withdrawAmount(accountId, amt);
		}

		@Override
		public Account showAccountDetails(String accountNo) throws SQLException {
			return dao.showAccountDetails(accountNo);
			
		}

		@Override
		public void createAccount(Account account) throws SQLException {
			dao.createAccount(account);
			
		}
		
		public int getLoan(int loanid,int loanamt) throws SQLException {
			return dao.getLoan(loanid, loanamt);
		}

		@Override
		public Loan showLoanDetails(int loanid) throws SQLException {
			return dao.showLoanDetails(loanid);
			
		}

		@Override
		public int payLoan(int loanid, int loanamt) throws SQLException {
			return dao.payLoan(loanid, loanamt);
		}

	}
	

