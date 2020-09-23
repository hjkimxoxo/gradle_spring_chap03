package chap03.spring;

import chap03.Member;
import chap03.MemberDao;

public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public void printMemberinfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member==null) {
			System.out.println("데이터없음.\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	

}
