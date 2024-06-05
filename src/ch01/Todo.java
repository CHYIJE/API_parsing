package ch01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Todo {
	private int userId;
	private int id;
	private String title;
	private boolean completed;
}
