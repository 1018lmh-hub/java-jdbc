package com.kh.species.view;

import java.util.List;
import java.util.Scanner;

import com.kh.species.controller.SpeciesController;
import com.kh.species.model.dto.SpeciesDto;

public class SpeciesView {
	private Scanner sc = new Scanner(System.in);
	private SpeciesController speciesController = new SpeciesController();
	
	public void mainMenu() {
		// 오늘 실습 겸 숙제
		/*
		 * 오늘 4개를 만들거임 추가 조회 변경 삭제
		 * 
		 * 테이블 3종세트 오늘 배운 구조로 만들기
		 */
		while(true) {
			System.out.println("--- 종 관리 프로그램 ---");
			System.out.println("1. 종 추가하기");
			System.out.println("2. 종 전체 조회하기");
			System.out.println("3. 종 정보변경하기");
			System.out.println("4. 종 삭제하기");
			System.out.println("5. 아이디로 검색하기");
			System.out.println("6. 이름 키워드로 검색하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴를 선택해주세요 >");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : save(); break;
			case "2" : findAll(); break;
			case "3" : update();break;
			case "4" : delete(); break;
			case "5" : findById(); break;
			case "6" : findByKeyword(); break;
			case "9" : sc.close(); return;
			default : System.out.println("없는 메뉴입니다.");
			
			}
		}
	}
	
	private void save() {
		System.out.println("종 추가~~");
		System.out.print("종 이름을 입력하세요 >"); 
		String speciesName = sc.nextLine();
		System.out.print("종 분류를 입력하세요 >"); 
		String speciesClass = sc.nextLine();
		// View 할 일 끝났따!! -> 컨트롤러 요청
		
		int result = speciesController.save(speciesName, speciesClass);
		
		//Controller에서 반환받은 값으로 결과 출력
		if(result > 0) {
			System.out.println("종 추가에 성공했습니다.");
			
		} else {
			System.out.println("종 추가에 실패했습니다."); 
		}
	}
	
	private void findAll() {
		System.out.println("\n종 전체 조회하기"); 
		
		//컨트롤러에게 종 전체 데이터 요청
		List<SpeciesDto> list = speciesController.findAll();
		
		
		// 뷰에서 2절
		System.out.println("\n 조회된 종 수는 총 " + list.size() + "개 입니다.");
		//조회결과가 있을 수도 있음
		//조회결과가 없을 수도 있음
		if(list.isEmpty()) {
			System.out.println("조회결과가 존재하지 않습니다.");
		} else {
			for(SpeciesDto sd : list) {
				System.out.println("======================================");
				System.out.print("번호 : " + sd.getSpeciesId() + ",");
				System.out.print("종이름 : " + sd.getSpeciesName() + ",");
				System.out.print("종분류 : " + sd.getSpeciesClass());
				System.out.println();
			}
		}
		
	}
	
	private void update() {
		
		//SPECIES_ID 값을 입력받아서
		//SPECIES_NAME과 SPECIES_CLASS값을 수정하는 기능
		
		System.out.println("종 수 정 기 능 입 니 다 . ");
		System.out.print("수정하실 종의 ID값을 입력해주세요 >");
		String speciesId = sc.nextLine();
		
		System.out.print("수정하실 종 이름을 입력하세요 > ");
		String speciesName = sc.nextLine();
		System.out.print("수정하실 종 분류를 입력하세요 > ");
		String speciesClass = sc.nextLine();
		
		int result = speciesController.update(new SpeciesDto(speciesId, speciesName, speciesClass));
	
		if(result > 0) {
			System.out.println("종 변경에 성공했습니다!");
		} else {
			System.out.println("종 변경에 실패했습니다");
		}
		
	}
	
	private void delete() {
		System.out.println("종 삭제 기능입니다!");
		System.out.print("삭제하실 ID를 입력해주세요 > ");
		String speciesId = sc.nextLine();
		
		int result = speciesController.delete(speciesId);
		
		if(result > 0) {
			System.out.println("삭제 성공 ~");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	private void findById() {
		// 사용자에게 SPECIES_ID를 입력받아서 조회된 결과를 출력
		System.out.println("아이디로 검색 서비스입니다.");
		System.out.print("검색하실 아이디를 입력해주세요 > ");
		String speciesId = sc.nextLine();
		
		SpeciesDto sd = speciesController.findById(speciesId);
		
		if(sd != null) {
			System.out.println(sd.getSpeciesId() + "검색결과");
			System.out.println("종 이름 : " + sd.getSpeciesName());
			System.out.println("종 이름 : " + sd.getSpeciesClass());
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}
	
	public void findByKeyword() {
		System.out.print("검색하고 싶은 키워드를 입력해주세요 > ");
		String keyword = sc.nextLine();
		
		List<SpeciesDto> list = speciesController.findByKeyword(keyword);
		
		//뷰에서 뭘 하냐?
		if(list.isEmpty()) {
			System.out.println("조회결과가 존재하지 않습니다."); 
		} else {
			for(SpeciesDto sd : list) {
				System.out.println(sd); 
			}
		}
			
		
			
	}

	
}
