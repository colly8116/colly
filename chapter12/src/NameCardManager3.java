import java.util.ArrayList;
import java.util.Scanner;

public class NameCardManager3 {

	static ArrayList<NameCard> nameCardList = new ArrayList<>();
	
	static int index = -1;
	
	//스캐너
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//메뉴 처리
		while(true) {
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (S)elect, (U)pdate, (D)elete, (Q)uit");
			String menu = scan.nextLine();
//			menu = menu.toLowerCase();
//			switch(menu.charAt(0)) {
			switch(menu.toLowerCase().charAt(0)) {
			case 'i' :
				System.out.println("명함 정보를 입력합니다.");
				insertNameCardInfo();
				break;
			case 's' :
				System.out.println("명함 정보를 조회합니다.");
				index = searchNameCardByName();
				if(index >= 0) {
					printNameCardInfo(index);
				}else {
					System.out.println("조회한 정보가 없습니다.");
				}
				break;
			case 'u' :
				System.out.println("명함 정보를 수정합니다.");
				index = searchNameCardByName();
				if(index >= 0) {
					updateNameCardInfo(index);
				}else {
					System.out.println("수정할 정보가 없습니다.");
				}
				break;
			case 'd' :
				System.out.println("명함 정보를 삭제합니다.");
				index = searchNameCardByName();
				if(index >= 0) {
					deleteNameCardInfo(index);
				}else {
					System.out.println("삭제할 정보가 없습니다.");
				}
				break;
			case 'q' :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("없는 메뉴 입니다.");
				break;
			}
		}//end while
	}//end main
	
	private static void deleteNameCardInfo(int idx) {
		nameCardList.remove(idx);
	}

	private static void updateNameCardInfo(int idx) {
		System.out.println("명함 정보를 수정합니다......");
		NameCard nameCard = nameCardList.get(idx);
		System.out.printf("회사이름(%s)", nameCard.getOfficeName());
		String officeName = scan.nextLine().trim();
		if(officeName != null && officeName.length()>=0) {
			nameCard.setOfficeName(officeName);
		}
		System.out.printf("직무(%s)", nameCard.getJob());
		String job = scan.nextLine().trim();
		if(job != null && job.length() >= 0) {
			nameCard.setJob(job);
		}
		System.out.printf("전화번호(%s)", nameCard.getPhone());
		String phone = scan.nextLine().trim();
		if(phone != null && phone.length() >= 0) {
			nameCard.setPhone(phone);
		}
		System.out.printf("회사전화번호(%s)", nameCard.getOfficePhone());
		String officePhone = scan.nextLine().trim();
		if(officePhone != null && officePhone.length() >= 0) {
			nameCard.setOfficePhone(officePhone);
		}
		System.out.printf("이메일(%s)", nameCard.getEmail());
		String email = scan.nextLine().trim();
		if(email != null && email.length() >= 0) {
			nameCard.setEmail(email);
		}
	}//end updateNameCardInfo()
	
	private static int searchNameCardByName() {
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine().trim();
		for(int i=0; i<nameCardList.size(); i++) {
			if(nameCardList.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	private static void insertNameCardInfo() {
		NameCard nameCard = new NameCard();			
		System.out.print("이름: ");			nameCard.setName(scan.nextLine().trim());
		System.out.print("회사명: ");		nameCard.setOfficeName(scan.nextLine().trim());
		System.out.print("직무: ");			nameCard.setJob(scan.nextLine().trim());
		System.out.print("전화번호: ");		nameCard.setPhone(scan.nextLine().trim());
		System.out.print("회사전화번호: ");	nameCard.setOfficePhone(scan.nextLine().trim());
		System.out.print("이메일주소: ");	nameCard.setEmail(scan.nextLine().trim());
		nameCardList.add(nameCard);
		printNameCardInfo(nameCardList.size()-1);
	}
	private static void printNameCardInfo(int idx) {
		NameCard nameCard = nameCardList.get(idx);
		System.out.printf("이름: %s, 회사명: %s, 직무: %s, \n전화: %s, 회사전화: %s, 이메일: %s\n", 
				nameCard.getName(), nameCard.getOfficeName(), 
				nameCard.getJob(), nameCard.getPhone(), 
				nameCard.getOfficePhone(), nameCard.getEmail());
	}
}//end class
