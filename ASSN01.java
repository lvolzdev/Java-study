package day02;

// 우리는 상점에서 핸드폰 구매
// 쏘니는 핸드폰을 삼
// 베컴도 핸드폰 삼

// 쏘니가 핸드폰 킴
// "야 내 핸드폰 켜볼게"
// "삐비빅" (핸드폰이 내는 소리)

// 베컴도 핸드폰 킴
// "turn on"
// "bbeep"

// 1. 객체 찾기
// 2. 각 객체가 가져야 하는 필드, 메소드 생각

public class ASSN01 {
    public static void main(String[] args) {
        Person sonny = new Person("쏘니");
        Person harry = new Person("해리케인");

        Phone samsung = new Phone("삼성", "삐비빅");
        Phone apple = new Phone("애플", "bbeep");

        sonny.buyThePhone();
        harry.buyThePhone();

        sonny.setSaying("야 내 핸드폰 켜볼게");
        samsung.turnOn(sonny);

        harry.setSaying("turn on");
        apple.turnOn(harry);
    }
}

class Person {
    String name;
    String saying;

    Person(String name) {
        this.name = name;
    }

    void setSaying(String saying) {
        this.saying = saying;
    }

    // 핸드폰을 구매하다
    void buyThePhone() {
        System.out.println(name + "가(이) 핸드폰을 구매했습니다.");
        System.out.println();
    }
}

class Phone {
    String model;
    String sound;

    Phone(String model, String sound) {
        this.model = model;
        this.sound = sound;
    }

    // 핸드폰을 키다
    void turnOn(Person person) {
        System.out.println(person.name + "가(이) 핸드폰을 켰습니다.");
        System.out.println(person.saying);
        System.out.println(sound);
        System.out.println();
    }
}

class Store {

}
