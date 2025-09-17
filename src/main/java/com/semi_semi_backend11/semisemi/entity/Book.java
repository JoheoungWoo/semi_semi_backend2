import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "BOOK")
public class Book {

    @Id // 기본 키
    @Column(name = "isbn", length = 20)
    private String isbn;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "author", nullable = false, length = 50)
    private String author;

    @Column(name = "content", length = 200)
    private String content;

    @Column(name = "publisher", length = 50)
    private String publisher;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "genre", length = 30)
    private String genre;

    @Column(name = "is_available", nullable = false, length = 1)
    private char isAvailable;
}