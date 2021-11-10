package it.apuliadigitalmaker.dev2022.filmmanager.responseDto;

public class CategoryResponseDto {
	
	private String name;
	
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CategoryResponseDto() {
		super();
	}

	public CategoryResponseDto(String name, String string) {
		super();
		this.name = name;
		this.id = string;
	}

	@Override
	public String toString() {
		return "CategoryResponseDto [name=" + name + ", id=" + id + "]";
	}


	
	

}
