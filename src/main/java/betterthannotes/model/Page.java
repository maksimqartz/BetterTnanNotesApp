package betterthannotes.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code Page} - класс представляет одну "страницу" с заголовком и списком блоков.
 * - id: уникальный идентификатор страницы.
 * - title: заголовок страницы.
 * - blocks: список блоков, принадлежащих этой странице (один-ко-многим).
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks = new ArrayList<>();
}