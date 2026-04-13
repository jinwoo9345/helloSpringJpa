package kr.ac.hansung.cse.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CategoryForm {
    private Long id;

    @NotBlank(message = "카테고리 이름을 입력하세요")
    @Size(max = 50, message = "50자 이내로 입력하세요")
    private String name;

    // 카테고리 등록 요청시
    public Category toEntity() {
        return new Category(this.name);
    }

    // 카테고리 조회 요청시
    public static CategoryForm from(Category category) {
        CategoryForm categoryForm = new CategoryForm();
        categoryForm.id = category.getId();
        categoryForm.name = category.getName();

        return categoryForm;
    }

}
