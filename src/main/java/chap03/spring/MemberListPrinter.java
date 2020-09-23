package chap03.spring;

import java.util.Collection;

import chap03.Member;
import chap03.MemberDao;

public class MemberListPrinter {
	private MemberDao memberDao; 
	private MemberPrinter printer;
	
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}

}
