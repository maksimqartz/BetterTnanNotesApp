package betterthannotes.model;

import jakarta.persistence.*;
import lombok.*;

/*
Цель: Один "блок" на странице (например, текст в Markdown).
id: уникальный идентификатор блока.
content: текст (в Markdown).
orderIndex: порядок отображения блока на странице.
page: ссылка на родительскую страницу (многие-к-одному).
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @Lob
    private String content;  // Markdown content

    private Integer orderIndex;
}
