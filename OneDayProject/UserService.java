package day04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class EX01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DAO database = new DAO();
        String loginId = "";

        int menu = -1;
        while(menu != 0){
            System.out.println("1. 회원가입 / 2. 로그인 / 3. 회원정보 수정 / 4. 탈퇴 / 0. 종료");
            menu = sc.nextInt();

            if(menu == 1){
                database.signUp();
            } else if(menu == 2){
                loginId = database.login();
            } else if(menu == 3){
                if(!Objects.equals(loginId, "")){
                    database.updateUser(loginId);
                }
                else{
                    System.out.println("로그인 상태가 아닙니다.");
                }
            } else if(menu == 4){
                if(!Objects.equals(loginId, "")){
                    if(database.deleteUser(loginId)){
                        loginId = "";
                    }
                }
                else{
                    System.out.println("로그인 상태가 아닙니다.");
                }
            }
        }
    }
}

class User{
    private String id;
    private String pw;
    private String name;

    User(String id, String pw, String name){
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class DAO{
    Map<String, User> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void signUp(){
        System.out.println("아이디, 비밀번호, 이름을 입력해주세요.");
        String id = sc.next();
        String pw = sc.next();
        String name = sc.next();
        sc.nextLine();

        map.put(id, new User(id, pw, name));
        System.out.println(name + "님 가입을 환영합니다.");
    }

    public String login(){
        System.out.println("아이디, 비밀번호를 입력해주세요.");
        String id = sc.next();
        String pw = sc.next();
        sc.nextLine();

        // 입력한 id랑 원래 db에 있는 id랑 비교해서 같으면 로그인 성공 (로그인 상태 변화)
        if (map.containsKey(id)) {
            User user = map.get(id);
            if(Objects.equals(pw, user.getPw())) {
                return id;
            }
        }
        return "";
    }

    public void updateUser(String loginId){
        System.out.println("비밀번호 이름을 바꿔주세요.");
        System.out.print("비밀번호: ");
        String pw = sc.nextLine();
        System.out.print("이름: ");
        String name = sc.nextLine();

        User user = map.get(loginId);
        user.setPw(pw);
        user.setName(name);
    }

    public boolean deleteUser(String loginId){
        map.remove(loginId);
        return true;
    }
}
