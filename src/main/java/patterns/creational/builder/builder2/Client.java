package patterns.creational.builder.builder2;


import patterns.creational.builder.Address;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {
		patterns.creational.builder.Client.User user = createUser();
		// Client has to provide director with concrete builder
		UserDTO dto = directBuild(UserDTO.getBuilder(), user);
		System.out.println(dto);
	}

	/**
	 * This method serves the role of director in builder pattern.
	 */
	private static UserDTO directBuild(UserDTO.UserDTOBuilder builder, patterns.creational.builder.Client.User user) {
		return builder.withFirstName(user.getFirstName()).withLastName(user.getLastName())
				.withBirthday(user.getBirthday()).withAddress(user.getAddress()).build();
	}

	/**
	 * Returns a sample user.
	 */
	public static patterns.creational.builder.Client.User createUser() {
		patterns.creational.builder.Client.User user = new patterns.creational.builder.Client.User();
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		Address address = new Address();
		address.setHouseNumber("100");
		address.setStreet("state Street");
		address.setCity("Pawnee");
		address.setState("Indiana");
		address.setZipcode("47998");
		user.setAddress(address);
		return user;
	}

}
