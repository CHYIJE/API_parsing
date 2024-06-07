package ch02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	private int id;
	private String username;
	private String email;
	private Address address;
	private Geo geo;
	private String phone;
	private String website;
	private Company company;
	private String name;

}

@ToString
class Address {
	private String street;
	private String suite;
	private String city;
	private String zipcode;
}

@ToString
class Geo {
	private String lat;
	private String lng;
}

@ToString
class Company {
	private String name;
	private String catchPhrase;
	private String bs;
}