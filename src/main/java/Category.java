import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId", nullable = false)
    private int categoryId;

    @Column(name = "CategoryDescription")
    private String categoryDescription;

    public Category(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Category() {
    }

    // Getters and Setters

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
