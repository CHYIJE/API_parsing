package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {

	public static void main(String[] args) {

		//
		Student student1 = new Student("고길동", 40, "애완학과");
		Student student2 = new Student("둘리", 5, "파괴학과");

		//
		Student[] studentArr = { student1, student2 };

		// --> 특정 형식(구조화) 있는 문자열로 변환하고 싶다. --> Json 형태
//		Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// 객체를 --> Json 형식에 문자열로 변환 시켜 ! --> 메서드 toJson()
		String student1Str = gson.toJson(student1);
		System.out.println(student1Str);

		// setPrettyPrinting() -> 이쁘게 출력하라 옵션
		Gson gson2 = new Gson();
		String student2Str = gson2.toJson(student2);
		System.out.println(student2Str);

		// 객체에서 ---> 문자열 형태로 가능 그럼 반대로는 어떻게 하지??
		// 문자열에서 ---> 클래스 형태로 어떻게 변경할까?

		// Object 형태로 변환
		Student studentObject = gson.fromJson(student1Str, Student.class);
		System.out.println(studentObject.getName());

		// 배열 형태로 변환
		Student[] StringArr = gson.fromJson(gson.toJson(studentArr), Student[].class);
		System.err.println(StringArr);
		
		for (Student student : StringArr) {
			System.err.println(student.toString());
		}
		
		System.out.println("-----------------------------");
		System.out.println(gson.toJson(StringArr));
		
		System.out.println("Student 끝");

		Dog dog1 = new Dog("고출력", 12);
		Dog dog2 = new Dog("저출력", 5);
		
		Dog [] dogArr = {dog1, dog2};
		
		Gson dogGson1 = new GsonBuilder().setPrettyPrinting().create();
		
		String dog1Str = dogGson1.toJson(dog1);
		System.out.println(dog1Str);
		
		Gson dogGson2 = new Gson();
		String dog2Str = dogGson2.toJson(dog2);
		System.out.println(dog2Str);
		
		Dog dogObject = dogGson1.fromJson(dog1Str, Dog.class);
		System.out.println(dogObject.getName());
		
		Dog[] strDogArr = dogGson1.fromJson(dogGson1.toJson(dogArr), Dog[].class);
		System.out.println(dogArr + "주소값나옴");
		
		for(Dog dog : dogArr) {
			System.out.println(dog.toString());
		}
		
		System.out.println("----------------");
		System.out.println(dogGson1.toJson(dogArr));
		System.out.println("dog의 끝");
		
	}

}
