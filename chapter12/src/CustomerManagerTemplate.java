import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagerTemplate {

	//고객 정보를 저장할 자료구조 선언
	static ArrayList<Customer> custList = new ArrayList<>();

	//리스트 정보를 조회하기 위해 인덱스를 필요로 함
	static int index = -1;

	static int count = 0;//custList.size()

	//기본 입력장치로부터 데이터를 입력받기 위해 Scanner객체 생성
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		while(true) {

			System.out.printf("\n[INFO] 고객 수 : %d, 인덱스 : %d\n", count, index);
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (P)revious, (N)ext, " +
					"(C)urrent, (U)pdate, (D)elete, (Q)uit");
			System.out.print("메뉴 입력: ");
			String menu = scan.next();
			menu = menu.toLowerCase();	//입력한 문자열을 모두소문자로 변환
			switch(menu.charAt(0)) {
			case 'i':
				System.out.println("고객정보 입력을 시작합니다.");

				break;
			case 'p' :
				System.out.println("이전 데이터를 출력합니다.");

				break;
			case 'n' :
				System.out.println("다음 데이터를 출력합니다.");

				break;
			case 'c' :
				System.out.println("현재 데이터를 출력합니다.");

				break;			
			case 'u' :
				System.out.println("데이터를 수정합니다.");

				break;
			case 'd' :
				System.out.println("데이터를 삭제합니다.");

				break;
			case 'q' :
				System.out.println("프로그램을 종료합니다.");
				scan.close();	//Scanner 객체를 닫아준다.
				System.exit(0);	//프로그램을 종료시킨다.
				break;	
			default : 
				System.out.println("메뉴를 잘 못 입력했습니다.");	
			}//end switch
		}//end while
	}//end main

}
