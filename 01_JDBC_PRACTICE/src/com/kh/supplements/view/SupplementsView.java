package com.kh.supplements.view;

import java.util.List;
import java.util.Scanner;

import com.kh.supplements.controller.SupplementsController;
import com.kh.supplements.model.dto.SupplementsDto;

public class SupplementsView {
	
	private Scanner sc = new Scanner(System.in);
	private SupplementsController supCon = new SupplementsController();
	
	public void mainMenu() {
		
		
		while(true) {
			System.out.println("----영양제 품목 관리 프로그램----");
			System.out.println("1. 영양제 품목 추가하기");
			System.out.println("2. 영양제 품목 수정하기");
			System.out.println("3. 영양제 목록 확인하기");
			System.out.println("4. 영양제 품목 삭제하기");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택해주세요. > ");
			
			String menu = sc.nextLine();
			
			switch(menu) {
			case "0" : sc.close(); return; 
			case "1" : save(); break;
			case "2" : update(); break;
			case "3" : findAll(); break;
			case "4" : delete();break;
			default : System.out.println("없는 메뉴입니다.");
			}
			
		}
	}
	
	
	
	private void save() {
		System.out.print("영양제 이름을 입력하세요 > ");
		String supName = sc.nextLine();
		System.out.print("영양제 가격을 입력하세요 > ");
		String supPriceStr = sc.nextLine();
		System.out.print("영양제 개수를 입력하세요 > ");
		String pillsStr = sc.nextLine();
		
		int supPrice = 0;
		int pills = 0;
		
		SupplementsDto sdto = new SupplementsDto();
		try {
		supPrice = Integer.parseInt(supPriceStr);
		pills = Integer.parseInt(pillsStr);
		} catch(NumberFormatException e) {
			System.out.println("숫자를 입력해주세요");
			return;
		}
		
		sdto.setSupName(supName);
		sdto.setSupPrice(supPrice);
		sdto.setPills(pills);
		
		int result = supCon.save(sdto);
		if(result > 0) {
			System.out.println("추가에 성공하였습니다.");
		} else { 
			System.out.println("추가에 실패하였습니다.");
		}
	}
	
	private void update() {
		
	}
	
	private void findAll() {
		System.out.println("-----영양제 전체 품목입니다.-----");
		List<SupplementsDto> list = supCon.findAll();
		
		System.out.println("조회된 영양제는 모두 " + list.size() + "개 입니다.");
		
		if(list.isEmpty()) {
			System.out.println("영양제 조회 결과가 존재하지 않습니다.");
		} else {
			for(SupplementsDto sdto : list) {
				System.out.println("===================================================================");
				System.out.print("영양제 번호 : " + sdto.getSupNo() ); 
				System.out.print(", 이름 : " + sdto.getSupName());
				System.out.print(", 가격 : " + sdto.getSupPrice() + "원");
				System.out.print(", 알약수 : " + sdto.getPills() +"개" );
				System.out.println();
			}
		}
		
	}
	
	private void delete() {
		
	}

}
