package chap03.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import chap03.ChangePasswordService;
import chap03.DuplicateMemberException;
import chap03.MemberNotFoundException;
import chap03.MemberRegisterService;
import chap03.RegisterRequest;
import chap03.WrongIdPasswordException;
import chap03.assembler.Assembler;

public class MainForAssembler {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}

	}
	
	
////////////////////
	
	private static Assembler assembler = new Assembler();
	
	private static void processNewCommand(String[] arg) {
		if(arg.length !=5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regService = assembler.getRegService();
		RegisterRequest r = new RegisterRequest();
		r.setEmail(arg[1]);
		r.setName(arg[2]);
		r.setPassword(arg[3]);
		r.setConfirmPassword(arg[4]);
		
		if(!r.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		
		try {
			regService.regist(r);
			System.out.println("등록했습니다.\n");
		}catch (DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}

	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changeService = assembler.getPwdService();
		try {
			changeService.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		}catch(MemberNotFoundException e) {
			System.out.println("존재하지않는 이메일입니다.\n");
		}catch(WrongIdPasswordException e) {
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
		
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}

}
