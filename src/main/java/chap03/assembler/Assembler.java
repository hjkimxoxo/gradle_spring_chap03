package chap03.assembler;

import chap03.ChangePasswordService;
import chap03.MemberDao;
import chap03.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regService; 
	private ChangePasswordService pwdService;
	
	public Assembler() {
		memberDao = new MemberDao();
		regService = new MemberRegisterService(memberDao);
		pwdService = new ChangePasswordService();
		pwdService.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getRegService() {
		return regService;
	}

	public ChangePasswordService getPwdService() {
		return pwdService;
	}
	
	

}
