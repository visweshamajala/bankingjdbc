package main;

import java.util.Scanner;

import bean.Account;
import bean.Loan;
import bean.Transaction;
import service.Services;

public class USer {
	public static void main(String[] args) throws Exception {
	 Transaction account =null;	
	 Services service = new Services();
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Choose any one");
			System.out.println("Enter 1 for Create account");
			System.out.println("Enter 2 for Deposit");
			System.out.println("Enter 3 for Withdraw");
			System.out.println("Enter 4 for ShowAccountDetails");
			System.out.println("Enter 5 for GetLoan");
			System.out.println("Enter 6 for PayLoan");
			System.out.println("Enter 7 for ShowLoanDetails");
			System.out.println("Enter 8 Exit");
			switch(sc.nextInt()) {
			case 1 :
					account = new Transaction();
					while(true) {
					System.out.println("Enter account Id");
					String accId = sc.next();
					if(service.validAccId(accId)) {	
						account.setAccountId(accId);
						break;
						}else {
							System.out.println("Entered account No. is not in valid format");
							return;
						}
					}		
					
					while(true) {
						System.out.println("Enter user name");
						String uname = sc.next();
						if(service.validAccName(uname)) {
							account.setAccountName(uname);
							break;
						}else {
							System.out.println("Entered Name is not in valid format");
							return;	
						}
					}		
					System.out.println("Enter address: ");
					account.setAddres(sc.next());					
					System.out.println("Enter deposit amount");
					account.setDepositAmount(sc.nextInt());					
					System.out.println(" Applying Loans...");
					System.out.println("1 for Yes \n 2 for No :");
					int ch = sc.nextInt();
					if(ch==1) {
						System.out.println("Enter loanId");
						account.setLoanId(sc.nextInt());
						
						System.out.println("Enter loan Type \n Home\t Car \t  Education");
						System.out.println("Loan Type must be any of three");
						account.setLoanType((sc.next()));		
						
						System.out.println("Enter loan amount");
						account.setLoanAmount(sc.nextInt());						
					}
					System.out.println("created account success");
					service.createAccount(account);
					break;
					
			case 2:
					System.out.println("Enter accountId :");
					String accountId = sc.next();
					System.out.println("Enter amount :");
					int depamount = sc.nextInt();
					int depbal=service.depositAmount(accountId, depamount);
					System.out.println("updated bal"+depbal);
					break;
					
			case 3:
					System.out.println("Enter accountId :");
					String accountId1 = sc.next();
					System.out.println("Enter amt :");
					int widamount = sc.nextInt();
					int widbal=service.withdrawAmount(accountId1, widamount);
					System.out.println("updated bal"+widbal);
					break;
					
			case 4:
					System.out.println("Enter AccountId :");
					String acnt = sc.next();
					Account act = service.showAccountDetails(acnt);
					if(act!=null) {
						System.out.println("Account Id : "+act.getAccountId());
						System.out.println("Account Name : "+act.getAccountName());
						System.out.println("Account holder address : "+act.getAddres());
						System.out.println("Deposit Amount : "+act.getDepositAmount());System.out.println();
						break;
					}else {
						System.out.println("Not found");
						break;
					}
					
			case 5:
					System.out.println("Enter amount of loan: ");
					int loanamt = sc.nextInt();
					System.out.println("Enter loanId : ");
					int loanid = sc.nextInt();
					int loanbal = service.getLoan(loanid, loanamt);
					System.out.println(loanbal+" loan amount got");
					break;
			
			case 6:
					System.out.println("Enter amt ");
					int payamount = sc.nextInt();
					System.out.println("Enter loanId ");
					int loanid1 = sc.nextInt();
					int loanbal1 = service.payLoan(loanid1, payamount);
					System.out.println("paid loan amount "+loanbal1);
					break;
					
			case 7:
					System.out.println("Enter loanId ");
					int loanId = sc.nextInt();
					Loan loan = service.showLoanDetails(loanId);
					if(loan!=null)
						System.out.println("Loan Id = "+loan.getLoanId()+" Loan type = "+loan.getLoanType()+" Loan Amount = "+loan.getLoanAmount());
					else
						System.out.println("Entered loan id doesnt match");					
					break;
					
			case 8:
					System.out.println("Thank you!");
					sc.close();
					break;
			}
		}

		

	}

}
