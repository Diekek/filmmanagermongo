package it.apuliadigitalmaker.dev2022.filmmanager.requestDto;

public class CategoryRequestDto {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryRequestDto [name=" + name + "]";
	}

	public CategoryRequestDto() {
		super();
	}

	public CategoryRequestDto(String name) {
		super();
		this.name = name;
	}
	
	

}
